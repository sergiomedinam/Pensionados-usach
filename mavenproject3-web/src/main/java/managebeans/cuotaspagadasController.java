package managebeans;

import entities.cuotaspagadas;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.cuotaspagadasFacadeLocal;

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
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("cuotaspagadasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
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

    public List<cuotaspagadas> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    
    public List<cuotaspagadas> CuotasPensionadosList(String rut) {
        List<cuotaspagadas> pertenece = new ArrayList<cuotaspagadas>();
        getItems();
        for (cuotaspagadas item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                    pertenece.add(item);          
            }
        }
        return pertenece;
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
