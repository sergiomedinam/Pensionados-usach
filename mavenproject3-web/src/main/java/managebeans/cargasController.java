package managebeans;

import entities.cargas;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.cargasFacadeLocal;

import java.io.Serializable;
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

@Named("cargasController")
@SessionScoped
public class cargasController implements Serializable {

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
