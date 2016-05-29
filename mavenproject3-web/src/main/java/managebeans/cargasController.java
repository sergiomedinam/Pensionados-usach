package managebeans;

import entities.cargas;
import entities.parametros;

import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.cargasFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@Named("cargasController")
@SessionScoped
public class cargasController implements Serializable {
    
    @Inject
    private parametrosController parametros;
    @EJB
    private cargasFacadeLocal ejbFacade;
    private List<cargas> items = null;
    private cargas selected;

    public cargasController() {
    }

    public cargas getSelected() {
        return selected;
    }

    public void setSelected(cargas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private cargasFacadeLocal getFacade() {
        return ejbFacade;
    }

    public cargas prepareCreate() {
        selected = new cargas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setTitular(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("cargasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("cargasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("cargasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<cargas> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    
    public List<cargas> CargasPensionados(String rut) {
        List<cargas> Cargas = new ArrayList<cargas>();
        getItems();
        for (cargas item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                    Cargas.add(item);          
            }
        }
        return Cargas;
    }
    public int ValorTotal(String rut) {
        int total = 0;
        
        return total;
    }
    
    public int ValorCatastrofico(String rut){
        List <parametros> Parametros = parametros.getItems();
        List <cargas> Cargas = CargasPensionados(rut);
        int total = 0;
        int UF = 0;
        int prima_titular = 0;
        int prima_conyuge = 0;
        int prima_hijo = 0;
        int Nhijo = 0;
        int Nconyuge = 0;
        for(parametros par : Parametros){
            if (par.getId() == 1) {
                UF = par.getValor_uf();
                prima_titular = par.getPrima_catastrofico_titular();
                prima_conyuge = par.getPrima_catastrofico_conyuge();
                prima_hijo = par.getPrima_catastrofico_hijos();
            }
        }
        
        for (cargas item : Cargas) {
            if (item.getSeguro().getNombre_seguro().equals("CATASTROFICO")){
                Nhijo = item.getHijos();
                Nconyuge = item.getConyuge();
            }
        }
        total = UF*(prima_titular + (Nconyuge*prima_conyuge) + (Nhijo*prima_hijo));
        
        
        return total;
    }
    
        public int ValorHospitalario(String rut){
        List <parametros> Parametros = parametros.getItems();
        List <cargas> Cargas = CargasPensionados(rut);
        int total = 0;
        int UF = 0;
        int prima_titular = 0;
        int prima_titular1 = 0;
        int prima_titular2 = 0;
        int Nhijo = 0;
        int Nconyuge = 0;
        int Notros = 0;
        for(parametros par : Parametros){
            if (par.getId() == 1) {
                UF = par.getValor_uf();
                prima_titular = par.getPrima_hospitalario_titular();
                prima_titular1 = par.getPrima_hospitalario_titularmas1();
                prima_titular2 = par.getPrima_hospitalario_titular2omas();
            }
        }
        for (cargas item : Cargas) {
            if (item.getSeguro().getNombre_seguro().equals("HOSPITALARIO")){
                Nhijo = item.getHijos();
                Nconyuge = item.getConyuge();
                Notros = item.getOtros();
            }
        }
        int n = Nhijo + Nconyuge + Notros;
        if (n == 0){
            total = prima_titular*UF;
        }if(n == 1){
            total = prima_titular1*UF;
        }if(n>=2){
            total = prima_titular2*UF;
        }
        return total;
    }
    
    

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public cargas getcargas(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<cargas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<cargas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public void validaTitularNumerico(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        try{
        int numero = (int) value;}
        catch (ClassCastException e){
            String texto = (String) value.toString();
            boolean alpha = texto.matches("[0-9]");

            if (!alpha) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Titular debe ser un valor numérico sin puntos ni comas.") );
            }
        }
    }
    
    public void validaHijosNumerico(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        try{
            int numero = (int) value;
            if (numero < 0) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Hijos debe ser un valor mayor o igual a 0.") );
            }
        }
        catch (ClassCastException e){
            String texto = (String) value.toString();
            boolean alpha = texto.matches("[0-9]");

            if (!alpha) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Hijos debe ser un valor numérico sin puntos ni comas.") );
            }
        }
    }
    
    public void validaConyugeNumerico(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        try{
            int numero = (int) value;
            if (numero < 0 || numero > 1) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Conyuge debe ser un valor mayor o igual a 0.") );
            }
        }
        catch (ClassCastException e){
            String texto = (String) value.toString();
            boolean alpha = texto.matches("[0-9]");

            if (!alpha) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Conyuge debe ser un valor numérico sin puntos ni comas.") );
            }
        }
    }
    
    public void validaOtrosNumerico(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        try{
            int numero = (int) value;
            if (numero < 0) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Otros debe ser un valor mayor o igual a 0.") );
            }
        }
        catch (ClassCastException e){
            String texto = (String) value.toString();
            boolean alpha = texto.matches("[0-9]");

            if (!alpha) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Otros debe ser un valor numérico sin puntos ni comas.") );
            }
        }
    }
    
    public void validaExistenciaPensionadoSeguro(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String) value.toString();
        System.out.println(texto);
        getItems();
        for (cargas item : items) {
            System.out.println(item.getPensionado());
            if (item.getSeguro().toString().equals(texto) ) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Este pensionado ya posee este seguro.") );
            }
        }
    }
    
    @FacesConverter(forClass = cargas.class)
    public static class cargasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            cargasController controller = (cargasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cargasController");
            return controller.getcargas(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof cargas) {
                cargas o = (cargas) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), cargas.class.getName()});
                return null;
            }
        }

    }

}
