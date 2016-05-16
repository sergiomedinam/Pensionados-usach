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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("pensionadoController")
@SessionScoped
public class pensionadoController implements Serializable {

    @EJB
    private pensionadoFacadeLocal ejbFacade;
    private List<pensionado> items = null;
    private pensionado selected;

    public pensionadoController() {
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
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pensionadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
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
    
    /********************************************************/
    public List<pensionado> PensionadosComuna(String Comuna) {
        List<pensionado> pertenece = new ArrayList<pensionado>();
        getItems();
        for (pensionado item : items) {
            if (item.getComuna().equals(Comuna)){
                    pertenece.add(item);          
            }
        }
        return pertenece;
    }
    
    public List<pensionado> PensionadosRegion(String Region) {
        List<pensionado> pertenece = new ArrayList<pensionado>();
        getItems();
        for (pensionado item : items) {
            if (item.getRegion().equals(Region)){
                    pertenece.add(item);          
            }
        }
        return pertenece;
    }
    /********************************************************/
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
