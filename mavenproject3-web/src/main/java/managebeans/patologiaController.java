package managebeans;

import entities.patologia;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.patologiaFacadeLocal;

import java.io.Serializable;
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

@Named("patologiaController")
@SessionScoped
public class patologiaController implements Serializable {

    @EJB
    private patologiaFacadeLocal ejbFacade;
    private List<patologia> items = null;
    private patologia selected;

    public patologiaController() {
    }

    public patologia getSelected() {
        return selected;
    }

    public void setSelected(patologia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private patologiaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public patologia prepareCreate() {
        selected = new patologia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        
        
        String nombre_patologia = selected.getNombre_patologia();
        getItems();
        boolean existePatologia = false;
        for(patologia item : items){
            if(item.getNombre_patologia().equals(nombre_patologia)){
                destroyNombre();
                existePatologia = true;
            }
        }
        
        if (!existePatologia) {
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("patologiaCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
        
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("patologiaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("patologiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void destroyNombre() {
        persist(PersistAction.DELETE, "Error: La patología ya existe.");
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public List<patologia> getItems() {
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

    public patologia getpatologia(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<patologia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<patologia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = patologia.class)
    public static class patologiaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            patologiaController controller = (patologiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "patologiaController");
            return controller.getpatologia(getKey(value));
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
            if (object instanceof patologia) {
                patologia o = (patologia) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), patologia.class.getName()});
                return null;
            }
        }

    }

}
