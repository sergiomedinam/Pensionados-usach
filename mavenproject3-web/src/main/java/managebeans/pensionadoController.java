package managebeans;

import entities.pensionado;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.pensionadoFacadeLocal;

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
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

@Named("pensionadoController")
@SessionScoped
public class pensionadoController implements Serializable {
    
    @EJB
    private pensionadoFacadeLocal ejbFacade;
    private List<pensionado> items = null;
    private pensionado selected;
    private String estado;

    private String causal;
    @Inject
    private cargasController cargasController;
    @Inject
    private pensionadobeneficioController pensionadobeneficioController;

    public pensionadoController() {
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }
    

    public pensionadoFacadeLocal getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(pensionadoFacadeLocal ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public cargasController getCargasController() {
        return cargasController;
    }

    public void setCargasController(cargasController cargasController) {
        this.cargasController = cargasController;
    }
    
    public void addMessage() {
        //String summary = estado ? "Pensionado ha sido Habilitado" : "Pensionado ha sido desactivado";
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public pensionado getSelected() {
        return selected;
    }

    public void setSelected(pensionado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private pensionadoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public pensionado prepareCreate() {
        selected = new pensionado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setEstado("HABILITADO");
        String texto = selected.getRut_pensionado();
        boolean alphaA = texto.matches("[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9kK]{1}");
        boolean alphaB = texto.matches("[0-9]{2}.[0-9]{3}.[0-9]{3}-[0-9kK]{1}");
        boolean betaA = texto.matches("[0-9]{1}[0-9]{3}[0-9]{3}-[0-9kK]{1}");
        boolean betaB = texto.matches("[0-9]{2}[0-9]{3}[0-9]{3}-[0-9kK]{1}");
        boolean gammaA = texto.matches("[0-9]{1}[0-9]{3}[0-9]{3}[0-9kK]{1}");
        boolean gammaB = texto.matches("[0-9]{2}[0-9]{3}[0-9]{3}[0-9kK]{1}");
        if (alphaA || betaA || betaB || gammaA || gammaB) {
            if (alphaA || betaA || gammaA) {
                texto = "0" + texto;
            }
            if (gammaA || gammaB) {
                texto = texto.substring(0, 8) + "-" + texto.substring(8);
            }
            if (betaA || betaB || gammaA || gammaB) {
                texto = texto.substring(0, 2) + "." + texto.substring(2, 5) + "." + texto.substring(5);            
            }
        }
        selected.setRut_pensionado(texto);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoUpdated"));
    }
    
    public void deshabilitar() {
        getSelected().setCausal(causal);
        getSelected().setEstado(estado);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("pensionadoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public List<pensionado> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    
    public List<pensionado> getHabilitados() {
        getItems();
        List<pensionado> habilitados = new ArrayList<pensionado>();
        for (pensionado item : items) {
            if (item.getEstado().equals("HABILITADO")) {
                habilitados.add(item);
                System.out.println(item.getRut_pensionado());
            }
        }
        return habilitados;
    }
    
    public int porcentajeBeneficios(){
        getItems();
        int porcentaje = 0;
        float numeroBeneficiados = 0;
        float numeroPensionados = getItems().size();
        for (pensionado item : items) {
            if(pensionadobeneficioController.BeneficiosPensionados(item.getRut_pensionado()).size()>0){
                numeroBeneficiados = numeroBeneficiados + 1;
            }
        }
        float cuenta = (numeroBeneficiados/numeroPensionados)*100;
        porcentaje = (int)(Math.round(cuenta));
        return porcentaje;
    }
    
    public List<pensionado> PensionadosComuna(String Comuna) {
        List<pensionado> perteneceComuna = new ArrayList<pensionado>();
        getItems();
        for (pensionado item : items) {
            if (item.getComuna().equals(Comuna)){
                    perteneceComuna.add(item);          
            }
        }
        return perteneceComuna;
    }
    
    public List<pensionado> PensionadosRegion(String Region) {
        List<pensionado> perteneceRegion = new ArrayList<pensionado>();
        getItems();
        for (pensionado item : items) {
            if (item.getRegion().equals(Region)){
                    perteneceRegion.add(item);          
            }
        }
        return perteneceRegion;
    }
    
    public int Aporte(String rut){
        int aporte = 0;
        getItems();
        for(pensionado item : items){
            if (item.getRut_pensionado().equals(rut)) {
                aporte = item.getAporte();
            }
        }
        return aporte;
    }
    
    public float Total(String rut,boolean cat,boolean vida,boolean hosp,boolean aporte,boolean otros,boolean prest,float valor_otros){
        float valor = 0;
        if(cat) valor = valor + cargasController.ValorCatastrofico(rut);
        if(vida) valor = valor + cargasController.ValorVida(rut);
        if(hosp) valor = valor + cargasController.ValorHospitalario(rut);
        if(aporte) valor = valor + Aporte(rut);
        if(prest) valor = valor + 0;
        if(otros) valor = valor + valor_otros;
        return valor;
    }
    
    public String getUsername(String rut){
        String nombre = "";
        getItems();
        for (pensionado item : items) {
            if (item.getRut_pensionado().equals(rut)) {
                nombre = item.getNombre_pensionado();
            }
        }
        return nombre;
    }
        
    public void validarRut(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        String texto = (String) value;
        boolean alpha = texto.matches("[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9kK]{1}");
        boolean beta = texto.matches("[0-9]{1,2}[0-9]{3}[0-9]{3}-[0-9kK]{1}");
        boolean gamma = texto.matches("[0-9]{1,2}[0-9]{3}[0-9]{3}[0-9kK]{1}");
        
        if (alpha || beta || gamma) {
            String partA = "";
            String partB = "";
            boolean raya = false;
            int suma = 0;
            int mult = 5;
            int modulo;
            int resta;
            
            if (alpha || beta) {
                for (int i = 0; i < texto.length(); i++) {
                    if (texto.charAt(i) == '-') {
                        raya = true;
                    }
                    if (texto.charAt(i) != '.' && texto.charAt(i) != '-'){
                        if (!raya) {
                            partA = partA + texto.charAt(i);
                        }else{
                            partB = partB + texto.charAt(i);
                            partB = partB.toUpperCase();
                        }
                    }
                }
            }else{
                for (int i = 0; i < texto.length()-1; i++) {
                    partA = partA + texto.charAt(i);                    
                }
                partB = ""+texto.charAt(texto.length()-1);
                partB = partB.toUpperCase();
            }
            for (int i = partA.length()-1; i >= 0; i--) {
                if (mult < 0) {
                    mult = 5;
                }
                suma = suma + Integer.parseInt(""+partA.charAt(i))*(7-mult);
                mult = mult-1;
            }
            modulo = suma%11;
            resta = 11 - modulo;

            if(!  ( ( resta == 11 && partB.equals("0") )||
                    ( resta == 10 && partB.equals("K") )||
                    ( resta == 9  && partB.equals("9") )||
                    ( resta == 8  && partB.equals("8") )||
                    ( resta == 7  && partB.equals("7") )||
                    ( resta == 6  && partB.equals("6") )||
                    ( resta == 5  && partB.equals("5") )||
                    ( resta == 4  && partB.equals("4") )||
                    ( resta == 3  && partB.equals("3") )||
                    ( resta == 2  && partB.equals("2") )||
                    ( resta == 1  && partB.equals("1") )    ) ){

                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado no es válido.") );
            }                
            
        }
        else{
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado no es válido.") );
        }
    }
    
    public void verificarRutExistencia(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        String texto = (String) value;
        boolean alpha = texto.matches("[0-9]{1,2}.[0-9]{3}.[0-9]{3}-[0-9kK]{1}");
        boolean beta = texto.matches("[0-9]{1,2}[0-9]{3}[0-9]{3}-[0-9kK]{1}");
        boolean gamma = texto.matches("[0-9]{1,2}[0-9]{3}[0-9]{3}[0-9kK]{1}");
        
        if (!getUsername(texto).equals("")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado ya existe para pensionado.") );
        }
        
        if (alpha || beta || gamma) {
            String partA = "";
            String partB = "";
            boolean raya = false;
            int suma = 0;
            int mult = 5;
            int modulo;
            int resta;
            
            if (alpha || beta) {
                for (int i = 0; i < texto.length(); i++) {
                    if (texto.charAt(i) == '-') {
                        raya = true;
                    }
                    if (texto.charAt(i) != '.' && texto.charAt(i) != '-'){
                        if (!raya) {
                            partA = partA + texto.charAt(i);
                        }else{
                            partB = partB + texto.charAt(i);
                            partB = partB.toUpperCase();
                        }
                    }
                }
            }else{
                for (int i = 0; i < texto.length()-1; i++) {
                    partA = partA + texto.charAt(i);                    
                }
                partB = ""+texto.charAt(texto.length()-1);
                partB = partB.toUpperCase();
            }
            for (int i = partA.length()-1; i >= 0; i--) {
                if (mult < 0) {
                    mult = 5;
                }
                suma = suma + Integer.parseInt(""+partA.charAt(i))*(7-mult);
                mult = mult-1;
            }
            modulo = suma%11;
            resta = 11 - modulo;

            if(!  ( ( resta == 11 && partB.equals("0") )||
                    ( resta == 10 && partB.equals("K") )||
                    ( resta == 9  && partB.equals("9") )||
                    ( resta == 8  && partB.equals("8") )||
                    ( resta == 7  && partB.equals("7") )||
                    ( resta == 6  && partB.equals("6") )||
                    ( resta == 5  && partB.equals("5") )||
                    ( resta == 4  && partB.equals("4") )||
                    ( resta == 3  && partB.equals("3") )||
                    ( resta == 2  && partB.equals("2") )||
                    ( resta == 1  && partB.equals("1") )    ) ){

                ((UIInput) toValidate).setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado no es válido.") );
            }           
            
        }
        else{
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado no es válido.") );
        }
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

    public pensionado getpensionado(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<pensionado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<pensionado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = pensionado.class)
    public static class pensionadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            pensionadoController controller = (pensionadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pensionadoController");
            return controller.getpensionado(getKey(value));
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
            if (object instanceof pensionado) {
                pensionado o = (pensionado) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), pensionado.class.getName()});
                return null;
            }
        }

    }

}
