package managebeans;

import entities.seguro;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.seguroFacadeLocal;

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
import javax.faces.event.ComponentSystemEvent;

@Named("seguroController")
@SessionScoped
public class seguroController implements Serializable {

    @EJB
    private seguroFacadeLocal ejbFacade;
    private List<seguro> items = null;
    private seguro selected;

    public seguroController() {
    }

    public seguro getSelected() {
        return selected;
    }

    public void setSelected(seguro selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private seguroFacadeLocal getFacade() {
        return ejbFacade;
    }

    public seguro prepareCreate() {
        selected = new seguro();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setNombre_seguro(selected.getNombre_seguro().toUpperCase());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("seguroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        selected.setNombre_seguro(selected.getNombre_seguro().toUpperCase());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("seguroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("seguroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<seguro> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
  
    public void validaCreate(ComponentSystemEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent();          
        UIInput uiseguronombre = (UIInput) components.findComponent("nombre_seguro");
        
        String seguro_nombre = uiseguronombre.getSubmittedValue().toString().trim().toUpperCase();

        getItems();
        for (seguro item : items) {
            if (item.getNombre_seguro().equals(seguro_nombre)) {
                uiseguronombre.setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Este Seguro ya existe en el sistema.") );
            }
        }
    }
    
    public void validaEdit(ComponentSystemEvent event){
         
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent();          
        UIInput uiseguronombre = (UIInput) components.findComponent("nombre_seguro");
        UIInput uiidSeguro = (UIInput) components.findComponent("id");
        
        int idseguro = Integer.parseInt(uiidSeguro.getSubmittedValue().toString().trim());
        
        String seguro_nombre = uiseguronombre.getSubmittedValue().toString().trim().toUpperCase();

        getItems();
        for (seguro item : items) {
            if (item.getId() != idseguro && item.getNombre_seguro().equals(seguro_nombre)) {
                uiseguronombre.setValid(false);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Este Seguro ya existe en el sistema.") );
            }
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

    public seguro getseguro(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<seguro> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<seguro> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = seguro.class)
    public static class seguroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            seguroController controller = (seguroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "seguroController");
            return controller.getseguro(getKey(value));
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
            if (object instanceof seguro) {
                seguro o = (seguro) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), seguro.class.getName()});
                return null;
            }
        }

    }

}
