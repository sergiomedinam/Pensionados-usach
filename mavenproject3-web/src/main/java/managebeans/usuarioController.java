package managebeans;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entities.usuario;
import managebeans.util.JsfUtil;
import managebeans.util.JsfUtil.PersistAction;
import sessionsbeans.usuarioFacadeLocal;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@Named("usuarioController")
@SessionScoped
public class usuarioController implements Serializable {
    
    @Inject
    private auditoriaController auditoria;
    @Inject
    private parametrosController parametros;
    @EJB
    private usuarioFacadeLocal ejbFacade;
    private List<usuario> items = null;
    private usuario selected;   
    private String passTemp;
    private Object fma;
    private boolean accepted = false;

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
    
    

    public usuario getSelected() {
        return selected;
    }

    public void setSelected(usuario selected) {
        this.selected = selected;
    }
   
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private usuarioFacadeLocal getFacade() {
        return ejbFacade;
    }
    
    public String getUsername(String rut){
        String nombre = "";
        getItems();
        for (usuario item : items) {
            if (item.getRut().equals(rut)) {
                nombre = item.getNombre();
            }
        }
        return nombre;
    }
    
    public String getApellido(String rut){
        String nombre = "";
        getItems();
        for (usuario item : items) {
            if (item.getRut().equals(rut)) {
                nombre = item.getApellido();
            }
        }
        return nombre;
    }
    
    public String getTipo(String rut){
        String tipo = "";
        getItems();
        for (usuario item : items) {
            if (item.getRut().equals(rut)) {
                tipo = item.getTipo_usuario().getNombre_rol();
            }
        }
        return tipo;
    }

    public usuario prepareCreate() {
        selected = new usuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setEstado("HABILITADO");
        
        passTemp = encryptSHA256(selected.getContrasena());
        selected.setContrasena(passTemp);
        System.out.println(selected.getContrasena());
        String texto = selected.getRut();
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
        selected.setRut(texto);      
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("usuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        
        Date ahora = Date.from(Instant.now());
        getItems();
        Long ultimo = items.get(items.size()-1).getId();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("ROL");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getTipo_usuario().getNombre_rol());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("RUT");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getRut());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("NOMBRE");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getNombre());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("APELLIDO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getApellido());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("EMAIL");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getEmail_usuario());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();   
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("CONTRASEÑA");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getContrasena());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();   
    }

    public void update() {
        passTemp = encryptSHA256(selected.getContrasena());
        selected.setContrasena(passTemp);
        String texto = selected.getRut();
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
        selected.setRut(texto);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("usuarioUpdated"));
        
        Date ahora = Date.from(Instant.now());
        getItems();
        Long ultimo = selected.getId();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("ROL");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getTipo_usuario().getNombre_rol());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("RUT");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getRut());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("NOMBRE");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getNombre());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("APELLIDO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getApellido());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("EMAIL");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getEmail_usuario());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();   
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("USUARIO");
        auditoria.getSelected().setNombre_columna("CONTRASEÑA");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getContrasena());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();   
    }
    
    public String getNombreCompleto() {
        String name = getUsername(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
        String apellido = getApellido(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
        String respuesta = name +" "+apellido;
        return respuesta;
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado ya existe para usuario.") );
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
    
    public boolean validarRut2(FacesContext context, UIComponent toValidate, Object value) {
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
                return false;
            }                
            
        }
        else{
            ((UIInput) toValidate).setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "El rut ingresado no es válido.") );
            return false;
        }
        return true;
    }
    
    private String encryptSHA256(String password){
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = password;
            md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            password = bigInt.toString(16);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(usuarioController.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return password;
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("usuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<usuario> getHabilitados() {
        getItems();
        List<usuario> habilitados = new ArrayList<usuario>();
        for (usuario item : items) {
            if (item.getEstado().equals("HABILITADO")) {
                habilitados.add(item);
            }
        }
        return habilitados;
    }
    public List<usuario> getItems() {
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

    public usuario getusuario(java.lang.Long id) {
        return getFacade().find(id);
    }

    private void existeSolicitante(String nombre, String rut, String correo, UIInput uirut, UIInput uicorreo){
        FacesContext context = FacesContext.getCurrentInstance();
        getItems();  
        
        boolean flagEnviado = false;
        
        for (usuario item : items) {
            // si existe usuario con ese correo -> flagCorreo
            if (  item.getEmail_usuario().equals(correo) && item.getRut().equals(rut)  ) {
                enviaCorreo(item.getNombre() +" "+ item.getApellido(), rut, correo);
                flagEnviado = true;
            }
        }
        if (!flagEnviado) {
            uirut.setValid(false);
            uicorreo.setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "No se encuentran usuarios con este rut y correo.") );
        }
    }
    
    public void submitSolicitud(){
        System.out.println("soy submit");
        accepted = true;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito",  "Se envio el correo a la dirección indicada") );
    }
    
    public void resetForm(){
        accepted = false;
        System.out.println("reset");
    }
    
    public void vaciaFormContr(ComponentSystemEvent event){
        UIComponent components = event.getComponent(); 
        
        UIInput uinombre = (UIInput) components.findComponent("Nombre");
        UIInput uirut = (UIInput) components.findComponent("Rut");
        UIInput uicorreo = (UIInput) components.findComponent("Correo");
        
        uinombre.setValue("");
        uirut.setValue("");
        uicorreo.setValue("");
    }
    
    public void validaFormContr(ComponentSystemEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent(); 
        
        UIInput uinombre = (UIInput) components.findComponent("Nombre");
        UIInput uirut = (UIInput) components.findComponent("Rut");
        UIInput uicorreo = (UIInput) components.findComponent("Correo");
        
        boolean pasaValidacion = true;
        
        if(uinombre == null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Nombre no se encuentra") );
            pasaValidacion = false;
        }else if(uinombre.getSubmittedValue().toString().trim().equals("")){
            uinombre.setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Nombre no puede ser nulo") );
            pasaValidacion = false;
        }
        
        if(uirut    == null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Rut no se encuentra") );
            pasaValidacion = false;
        }else if(uirut.getSubmittedValue().toString().trim().equals("")   ){
            uirut.setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Rut no puede ser nulo") );
            pasaValidacion = false;
        }
        
        if(uicorreo == null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Correo no se encuentra") );
            pasaValidacion = false;
        }else if(uicorreo.getSubmittedValue().toString().trim().equals("")){
            uicorreo.setValid(false);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Correo no puede ser nulo") );
            pasaValidacion = false;
        }
        
        if (pasaValidacion) {
            if (validarRut2(context, uirut, uirut.getSubmittedValue().toString().trim().toUpperCase())) {
                String nombre = uinombre.getSubmittedValue().toString().trim();
                String rut = uirut.getSubmittedValue().toString().trim().toUpperCase();
                String correo = uicorreo.getSubmittedValue().toString().trim().toUpperCase();
                existeSolicitante(nombre, rut, correo, uirut, uicorreo);
                uinombre.setValue("");
                uirut.setValue("");
                uicorreo.setValue("");
            }            
        }
    }
    
    public List<usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    private void enviaCorreo(String name, String rut, String correo) {        
        String to = parametros.getCorreoAdmin();        
        final String username = parametros.getCorreoApp();
        final String password = parametros.getContrasenaApp();
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");      
        
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("Solicitud contraseña nueva");
            message.setText("Administrador:\n"
                            + "El usuario "+ name +" ha solicitado se cambie su contraseña.\n"
                            + "Sus datos:\n"
                            + "- RUT= "+ rut +"\n"
                            + "- CORREO= "+ correo +".\n");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @FacesConverter(forClass = usuario.class)
    public static class usuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            usuarioController controller = (usuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getusuario(getKey(value));
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
            if (object instanceof usuario) {
                usuario o = (usuario) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), usuario.class.getName()});
                return null;
            }
        }

    }

}
