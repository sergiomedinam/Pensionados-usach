package managebeans;

import entities.pago;
import entities.pagodetalle;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.pagoFacadeLocal;

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
import javax.inject.Inject;

@Named("pagoController")
@SessionScoped
public class pagoController implements Serializable {

    @EJB
    private pagoFacadeLocal ejbFacade;
    private List<pago> items = null;
    private pago selected;
   
    @Inject
    private pagodetalleController pagodetalle;
    
    private Boolean vida;
    private Boolean hospitalario;
    private Boolean catastrofico;
    private Boolean ucm;
    private Boolean paux;
    private Boolean pmed;
    private Boolean jardin;
    private Boolean aportes;
    private Boolean otros;
    private Boolean prestamos;

    public Boolean getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Boolean prestamos) {
        this.prestamos = prestamos;
    }
    
    

    public pagoFacadeLocal getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(pagoFacadeLocal ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public pagodetalleController getPagodetalle() {
        return pagodetalle;
    }

    public void setPagodetalle(pagodetalleController pagodetalle) {
        this.pagodetalle = pagodetalle;
    }

    public Boolean getVida() {
        return vida;
    }

    public void setVida(Boolean vida) {
        this.vida = vida;
    }

    public Boolean getHospitalario() {
        return hospitalario;
    }

    public void setHospitalario(Boolean hospitalario) {
        this.hospitalario = hospitalario;
    }

    public Boolean getCatastrofico() {
        return catastrofico;
    }

    public Boolean getPmed() {
        return pmed;
    }

    public void setPmed(Boolean pmed) {
        this.pmed = pmed;
    }

    
    public void setCatastrofico(Boolean catastrofico) {
        this.catastrofico = catastrofico;
    }

    public Boolean getUcm() {
        return ucm;
    }

    public void setUcm(Boolean ucm) {
        this.ucm = ucm;
    }

    public Boolean getPaux() {
        return paux;
    }

    public void setPaux(Boolean paux) {
        this.paux = paux;
    }

    public Boolean getJardin() {
        return jardin;
    }

    public void setJardin(Boolean jardin) {
        this.jardin = jardin;
    }

    public Boolean getAportes() {
        return aportes;
    }

    public void setAportes(Boolean aportes) {
        this.aportes = aportes;
    }

    public Boolean getOtros() {
        return otros;
    }

    public void setOtros(Boolean otros) {
        this.otros = otros;
    }
    
    
    
    public pagoController() {
    }

    public pago getSelected() {
        return selected;
    }

    public void setSelected(pago selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private pagoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public pago prepareCreate() {
        vida = null;
        hospitalario = null;
        catastrofico = null;
        jardin = null;
        otros = null;
        paux = null;
        pmed = null;
        ucm = null;
        aportes = null;
        prestamos = null;
        
        selected = new pago();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        pagodetalle.prepareCreate();
        pagodetalle.getSelected().setSeguro_catastrofico(catastrofico);
        pagodetalle.getSelected().setSeguro_hospitalario(hospitalario);
        pagodetalle.getSelected().setSeguro_vida(vida);
        pagodetalle.getSelected().setAportes(aportes);
        pagodetalle.getSelected().setOtros(otros);
        pagodetalle.getSelected().setPrestamos(prestamos);
        selected.setPagodetalles(pagodetalle.getSelected());
        pagodetalle.create();
        
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pagoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pagoUpdated"));
    }

    public void destroy() {
        pagodetalle.destroy();
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("pagoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<pago> getItems() {
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

    public pago getpago(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<pago> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<pago> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = pago.class)
    public static class pagoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            pagoController controller = (pagoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagoController");
            return controller.getpago(getKey(value));
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
            if (object instanceof pago) {
                pago o = (pago) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), pago.class.getName()});
                return null;
            }
        }

    }

}

