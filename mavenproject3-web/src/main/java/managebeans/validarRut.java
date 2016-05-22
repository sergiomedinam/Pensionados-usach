/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nelson
 */
public class validarRut {
    public void validarRut(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.equals("")) {

            String mensaje = "fail my bro";
            if (!mensaje.equals("Exito")) {
                ((UIInput) toValidate).setValid(false);
                context.addMessage(toValidate.getClientId(context), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", mensaje));
            }
        }
    }
}
