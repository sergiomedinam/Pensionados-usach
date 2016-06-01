package managebeans;

import entities.pago;
import entities.pagodetalle;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.pagoFacadeLocal;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
    @Inject 
    private usuarioController usuario;
    @Inject
    private auditoriaController auditoria;
    
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
    
    private Integer monto_seguro_catastrofico;
    private Integer monto_seguro_vida;
    private Integer monto_seguro_hospitalario;
    private Integer monto_aportes;
    private Integer monto_otros;
    private Integer monto_prestamos;

    public Integer getMonto_seguro_catastrofico() {
        return monto_seguro_catastrofico;
    }

    public void setMonto_seguro_catastrofico(Integer monto_seguro_catastrofico) {
        this.monto_seguro_catastrofico = monto_seguro_catastrofico;
    }

    public Integer getMonto_seguro_vida() {
        return monto_seguro_vida;
    }

    public void setMonto_seguro_vida(Integer monto_seguro_vida) {
        this.monto_seguro_vida = monto_seguro_vida;
    }

    public Integer getMonto_seguro_hospitalario() {
        return monto_seguro_hospitalario;
    }

    public void setMonto_seguro_hospitalario(Integer monto_seguro_hospitalario) {
        this.monto_seguro_hospitalario = monto_seguro_hospitalario;
    }

    public Integer getMonto_aportes() {
        return monto_aportes;
    }

    public void setMonto_aportes(Integer monto_aportes) {
        this.monto_aportes = monto_aportes;
    }

    public Integer getMonto_otros() {
        return monto_otros;
    }

    public void setMonto_otros(Integer monto_otros) {
        this.monto_otros = monto_otros;
    }

    public Integer getMonto_prestamos() {
        return monto_prestamos;
    }

    public void setMonto_prestamos(Integer monto_prestamos) {
        this.monto_prestamos = monto_prestamos;
    }
    
    

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
        monto_seguro_catastrofico = 0;
        monto_seguro_hospitalario = 0;
        monto_seguro_vida = 0;
        monto_aportes = 0;
        monto_prestamos = 0;
        monto_otros = 0;
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
        pagodetalle.getSelected().setMonto_seguro_catastrofico(monto_seguro_catastrofico);
        pagodetalle.getSelected().setMonto_seguro_hospitalario(monto_seguro_hospitalario);
        pagodetalle.getSelected().setMonto_seguro_vida(monto_seguro_vida);
        pagodetalle.getSelected().setMonto_aportes(monto_aportes);
        pagodetalle.getSelected().setMonto_prestamos(monto_prestamos);
        pagodetalle.getSelected().setMonto_otros(monto_otros);
        selected.setPagodetalles(pagodetalle.getSelected());
        pagodetalle.create();
        
        String rut = selected.getPensionado().getRut_pensionado();
        String Año = selected.getAno();
        String Mes = selected.getMes();
        System.out.println("*************************");
        System.out.println(selected.getMes() + selected.getAno());
        List<pago> Pagos = PagosPensionados(rut);
        boolean existeMes = false;
        for(pago item : Pagos){
            if(item.getAno().equals(Año)){
                if(item.getMes().equals(Mes))
                    destroyMes();
            }
        }
        if(!existeMes){
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pagoCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
        Date ahora = Date.from(Instant.now());
        getItems();
        Long ultimo = null;
        try{
            ultimo = items.get(items.size()-1).getId(); 
        }catch(ArrayIndexOutOfBoundsException e){
            ultimo =  Long.valueOf("1");
        } 
        String nombreAux = selected.getPensionado().getRut_pensionado();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("RUT");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPensionado().getRut_pensionado());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("NOMBRE");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPensionado().getNombre_pensionado()+" "+selected.getPensionado().getApellido_p_pensionado()+" "+selected.getPensionado().getApellido_m_pensionado());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("MES");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getMes());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("AÑO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getAno());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO CATASFROFICO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_catastrofico().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO VIDA");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_vida().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO HOSPITALARIO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_hospitalario().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("APORTES");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_aportes().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("PRESTAMOS");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_prestamos().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("OTROS");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_otros().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();         
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("PAGO (TOTAL)");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPago().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
    }

    public void update() {
        pagodetalle.update();
        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pagoUpdated"));
        String nombreAux = selected.getPensionado().getRut_pensionado();
        Date ahora = Date.from(Instant.now());
        getItems();
        Long ultimo = selected.getId();
        auditoria.prepareCreate(); 
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("MES");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getMes());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("AÑO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getAno());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO CATASFROFICO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_catastrofico().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO VIDA");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_vida().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("SEGURO HOSPITALARIO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_seguro_hospitalario().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("APORTES");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_aportes().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("PRESTAMOS");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_prestamos().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("OTROS");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPagodetalles().getMonto_otros().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();         
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto(nombreAux));
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("PAGO (TOTAL)");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPago().toString());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
    }

    public void destroy() {
        pagodetalle.destroy();
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("pagoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void destroyMes() {
        pagodetalle.destroy();
        persist(PersistAction.DELETE, "Error: Pera el pensionado, ya existe un pago con este mes y año");
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
    
        public List<pago> PagosPensionados(String rut) {
        List<pago> Pagos = new ArrayList<pago>();
        getItems();
        for (pago item : items) {
            if (item.getPensionado().getRut_pensionado().equals(rut)){
                    Pagos.add(item);          
            }
        }
        return Pagos;
    }
    
    
    public boolean Complete(boolean cat,boolean vida,boolean hosp,boolean aporte,boolean otros,boolean prest){
        boolean valor = cat && vida && hosp && aporte && otros && prest;
        return valor;
    }
    
    public int Total(boolean cat,boolean vida,boolean hosp,boolean aporte,boolean otros,boolean prest){
        int valor = 0;
        if(cat) valor = valor + selected.getPagodetalles().getMonto_seguro_catastrofico();
        if(vida) valor = valor + selected.getPagodetalles().getMonto_seguro_vida();
        if(hosp) valor = valor + selected.getPagodetalles().getMonto_seguro_hospitalario();
        if(aporte) valor = valor + selected.getPagodetalles().getMonto_aportes();
        if(otros) valor = valor + selected.getPagodetalles().getMonto_otros();
        if(prest) valor = valor + selected.getPagodetalles().getMonto_prestamos();
        return valor;
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

