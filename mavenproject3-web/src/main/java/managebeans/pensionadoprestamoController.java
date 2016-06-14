package managebeans;

import entities.pensionadoprestamo;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.pensionadoprestamoFacadeLocal;

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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("pensionadoprestamoController")
@SessionScoped
public class pensionadoprestamoController implements Serializable {

    @EJB
    private pensionadoprestamoFacadeLocal ejbFacade;
    private List<pensionadoprestamo> items = null;
    private pensionadoprestamo selected;

    public pensionadoprestamoController() {
    }

    public pensionadoprestamo getSelected() {
        return selected;
    }

    public void setSelected(pensionadoprestamo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private pensionadoprestamoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public pensionadoprestamo prepareCreate() {
        selected = new pensionadoprestamo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoprestamoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoprestamoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("pensionadoprestamoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<pensionadoprestamo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<pensionadoprestamo> PrestamosPensionados(String rut) {
        List<pensionadoprestamo> Prestamos = new ArrayList<pensionadoprestamo>();
        getItems();
        for (pensionadoprestamo item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                    Prestamos.add(item);          
            }
        }
        return Prestamos;
    }
    
    public int valorPrestamos(String rut, String mes, String año){
        System.out.println("******************************************");
        System.out.println("rut_rec: "+rut);
        int mesPagoprestamo;
        int añoPagoprestamo;
        if(!año.equals("")){
            añoPagoprestamo = Integer.parseInt(año);
        }else{
            añoPagoprestamo = 0;
        }
        if(!mes.equals("")){
            mesPagoprestamo = Integer.parseInt(mes);
        }else{
            mesPagoprestamo = 0;
        }
        System.out.println("mes_rec: "+mesPagoprestamo);
        System.out.println("año_rec: "+añoPagoprestamo);
        System.out.println("******************************************");
        int total = 0;
        getItems();
        for (pensionadoprestamo item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                System.out.println("******************************************");
                System.out.println("prestamo: "+item.getPrestamo().getNombre_prestamo());
                System.out.println("va_Cuota: "+item.getValor_cuota());
                System.out.println("f_inicio: "+item.getFecha_pedido());
                System.out.println("fTermino: "+item.getFecha_termino());
                int mesInicio = Integer.parseInt(item.getFecha_pedido().split("/")[0]);
                int añoInicio = Integer.parseInt(item.getFecha_pedido().split("/")[1]);
                int añoTermino = Integer.parseInt(item.getFecha_termino().split("/")[1]);
                int nCuotas = item.getCuotas();
                if((añoPagoprestamo>=añoInicio) &&(añoPagoprestamo<=añoTermino)){
                    int diferencia = añoPagoprestamo - añoInicio;
                    int valorAyuda = nCuotas + mesInicio - 1;
                    int valorComparar = diferencia*12 + mesPagoprestamo;
                    if(valorAyuda>=valorComparar && valorComparar>=mesInicio){
                        total = total + item.getValor_cuota();
                        System.out.println("> SE DEBE PAGAR<");
                    }
                    else{System.out.println("> NO SE DEBE PAGAR <");}
                }else{System.out.println("> NO SE DEBE PAGAR <");}
                System.out.println("******************************************");
            }
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

    public pensionadoprestamo getpensionadoprestamo(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<pensionadoprestamo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<pensionadoprestamo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = pensionadoprestamo.class)
    public static class pensionadoprestamoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            pensionadoprestamoController controller = (pensionadoprestamoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pensionadoprestamoController");
            return controller.getpensionadoprestamo(getKey(value));
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
            if (object instanceof pensionadoprestamo) {
                pensionadoprestamo o = (pensionadoprestamo) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), pensionadoprestamo.class.getName()});
                return null;
            }
        }

    }

}
