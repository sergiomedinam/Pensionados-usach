package managebeans;

import entities.cuotaspagadas;
import entities.pensionado;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.cuotaspagadasFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

@Named("cuotaspagadasController")
@SessionScoped
public class cuotaspagadasController implements Serializable {

    @EJB
    private cuotaspagadasFacadeLocal ejbFacade;
    private List<cuotaspagadas> items = null;
    private cuotaspagadas selected;

    public cuotaspagadasController() {
    }

    public cuotaspagadas getSelected() {
        return selected;
    }

    public void setSelected(cuotaspagadas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private cuotaspagadasFacadeLocal getFacade() {
        return ejbFacade;
    }

    public cuotaspagadas prepareCreate() {
        selected = new cuotaspagadas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        System.out.println("********************************************************");
        String rut = selected.getPensionado().getRut_pensionado();
        String nuevoAño = selected.getAno();
        List<cuotaspagadas> cuotas = CuotasPensionados(rut);
        System.out.println("RUT: "+selected.getPensionado().getRut_pensionado());
        System.out.println("añoNuevo: "+nuevoAño);
        System.out.println("CUOTAS: "+cuotas.size());
        boolean existeAño = false;
        for(cuotaspagadas item : cuotas){
            System.out.println("años en cuotas: "+item.getAno());
            System.out.println("item.getAno().equals(nuevoAño): "+item.getAno().equals(nuevoAño));
            if(item.getAno().equals(nuevoAño)){
                destroyAño();
            }
        }
        
        System.out.println("********************************************************");
        if (!existeAño) {
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("cuotaspagadasCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
        
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("cuotaspagadasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("cuotaspagadasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void destroyAño() {
        persist(PersistAction.DELETE, "Error: Para este pensionado, ya existe el año");
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<cuotaspagadas> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    
    public List<cuotaspagadas> CuotasPensionados(String rut) {
        List<cuotaspagadas> Cuotas = new ArrayList<cuotaspagadas>();
        getItems();
        for (cuotaspagadas item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                    Cuotas.add(item);          
            }
        }
        return Cuotas;
    }
    
    public boolean alDia(String rut){
        Calendar fecha = new GregorianCalendar();
        int añoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        boolean alDia = false;
        boolean bandera = true;
        List<cuotaspagadas> cuotas = new ArrayList<cuotaspagadas>();
        cuotas = CuotasPensionados(rut);
        for(cuotaspagadas item : cuotas){
            if( Integer.parseInt(item.getAno()) <= añoActual){
                if(bandera){
                    int diferencia = añoActual - Integer.parseInt(item.getAno());
                    if(diferencia == cuotas.size()){
                        alDia = false;
                    }
                    bandera = false;
                }
                if(Integer.parseInt(item.getAno()) != añoActual){
                    if(item.getCuotas() != 12){
                        alDia = false;
                    }
                }else{
                    if(item.getCuotas() == mesActual){
                        alDia = true;
                    }else{
                        alDia = false;
                    }
                }
            }
        }        
        return alDia;
    }
    
    public boolean esMoroso(String rut){
        Calendar fecha = new GregorianCalendar();
        int añoActual = fecha.get(Calendar.YEAR);
        int mesActual = fecha.get(Calendar.MONTH) + 1;
        int mesesEspera = 3;
        boolean Moroso = false;
        boolean bandera = true;
        List<cuotaspagadas> cuotas = new ArrayList<cuotaspagadas>();
        cuotas = CuotasPensionados(rut);
        for(cuotaspagadas item : cuotas){
            if( Integer.parseInt(item.getAno()) <= añoActual){
                if(bandera){
                    int diferencia = añoActual - Integer.parseInt(item.getAno());
                    if(diferencia == cuotas.size()){
                        if(mesesEspera <= mesActual){
                            Moroso = true;
                        }
                    }
                    bandera = false;
                }
                if(Integer.parseInt(item.getAno()) != añoActual){
                    if(item.getCuotas() != 12){
                        Moroso = true;
                    }
                }else{
                    if(item.getCuotas() != mesActual){
                        if(item.getCuotas() <= (mesActual - mesesEspera)){
                            Moroso = true;
                        }
                    }
                }
            }
        }
        return Moroso;
    }
    
    public List<pensionado> Morosos(List<pensionado> pensionados){
        List<pensionado> morosos = new ArrayList<pensionado>();
        for(pensionado item : pensionados){
            if(esMoroso(item.getRut_pensionado())){
                morosos.add(item);
            }
        }
        return morosos;
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

    public cuotaspagadas getcuotaspagadas(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<cuotaspagadas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<cuotaspagadas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = cuotaspagadas.class)
    public static class cuotaspagadasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            cuotaspagadasController controller = (cuotaspagadasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cuotaspagadasController");
            return controller.getcuotaspagadas(getKey(value));
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
            if (object instanceof cuotaspagadas) {
                cuotaspagadas o = (cuotaspagadas) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), cuotaspagadas.class.getName()});
                return null;
            }
        }

    }

}