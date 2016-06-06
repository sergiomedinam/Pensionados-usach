package managebeans;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.pago;
import entities.pagodetalle;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.apache.commons.io.IOUtils;

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
        String Ano = selected.getAno();
        String Mes = selected.getMes();
        List<pago> Pagos = PagosPensionados(rut);
        boolean existeMes = false;
        for(pago item : Pagos){
            if(item.getAno().equals(Ano)){
                if(item.getMes().equals(Mes)){
                    destroyMes();
                    existeMes = true;
                }
            }
        }
        if(!existeMes){
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("pagoCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
            
            Date ahora = Date.from(Instant.now());
            getItems();
            Long ultimo = null;
            try{
                ultimo = items.get(items.size()-1).getId(); 
            }catch(ArrayIndexOutOfBoundsException e){
                ultimo =  Long.valueOf("1");
            } 
            auditoria.prepareCreate();
            auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
            auditoria.getSelected().setNombre_tabla("PAGO");
            auditoria.getSelected().setNombre_columna("RUT");
            auditoria.getSelected().setValor_antiguo("NULL");
            auditoria.getSelected().setValor_nuevo(selected.getPensionado().getRut_pensionado());
            auditoria.getSelected().setFechayhora(ahora);
            auditoria.getSelected().setId_registro(ultimo);
            auditoria.create();        
            auditoria.prepareCreate();
            auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
            auditoria.getSelected().setNombre_tabla("PAGO");
            auditoria.getSelected().setNombre_columna("NOMBRE");
            auditoria.getSelected().setValor_antiguo("NULL");
            auditoria.getSelected().setValor_nuevo(selected.getPensionado().getNombre_pensionado()+" "+selected.getPensionado().getApellido_p_pensionado()+" "+selected.getPensionado().getApellido_m_pensionado());
            auditoria.getSelected().setFechayhora(ahora);
            auditoria.getSelected().setId_registro(ultimo);
            auditoria.create();
            auditoria.prepareCreate();
            auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
            auditoria.getSelected().setNombre_tabla("PAGO");
            auditoria.getSelected().setNombre_columna("MES");
            auditoria.getSelected().setValor_antiguo("NULL");
            auditoria.getSelected().setValor_nuevo(selected.getMes());
            auditoria.getSelected().setFechayhora(ahora);
            auditoria.getSelected().setId_registro(ultimo);
            auditoria.create(); 
            auditoria.prepareCreate();
            auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
            auditoria.getSelected().setNombre_tabla("PAGO");
            auditoria.getSelected().setNombre_columna("AÑO");
            auditoria.getSelected().setValor_antiguo("NULL");
            auditoria.getSelected().setValor_nuevo(selected.getAno());
            auditoria.getSelected().setFechayhora(ahora);
            auditoria.getSelected().setId_registro(ultimo);
            auditoria.create();          
            auditoria.prepareCreate();
            auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
            auditoria.getSelected().setNombre_tabla("PAGO");
            auditoria.getSelected().setNombre_columna("PAGO (TOTAL)");
            auditoria.getSelected().setValor_antiguo("NULL");
            auditoria.getSelected().setValor_nuevo(selected.getPago().toString());
            auditoria.getSelected().setFechayhora(ahora);
            auditoria.getSelected().setId_registro(ultimo);
            auditoria.create();

        }
    }

    public void createPDF() throws IOException, DocumentException{
        
        Document document = new Document();
        String mes = "";
        if(selected.getMes().equals("1") ){mes = "01";}
        if(selected.getMes().equals("2") ){mes = "02";}
        if(selected.getMes().equals("3") ){mes = "03";}
        if(selected.getMes().equals("4") ){mes = "04";}
        if(selected.getMes().equals("5") ){mes = "05";}
        if(selected.getMes().equals("6") ){mes = "06";}
        if(selected.getMes().equals("7") ){mes = "07";}
        if(selected.getMes().equals("8") ){mes = "08";}
        if(selected.getMes().equals("9") ){mes = "09";}
        if(selected.getMes().equals("10")){mes = "10";}
        if(selected.getMes().equals("11")){mes = "11";}
        if(selected.getMes().equals("12")){mes = "12";}
        String nombre_completo = selected.getPensionado().getNombre_pensionado()+" "+selected.getPensionado().getApellido_p_pensionado()+" "+selected.getPensionado().getApellido_m_pensionado();
        String title = "PAGO "+ mes +" - "+ selected.getAno() +" - "+ nombre_completo +".pdf";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.addTitle(title);
        document.open();
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        float[] columnWidths = {1f, 1f, 1f};
        table.setWidths(columnWidths);
        boolean xcat    = catastrofico;
        boolean xvida   = vida;
        boolean xhosp   = hospitalario;
        boolean xaporte = aportes;
        boolean xotros  = otros;
        boolean xprest  = prestamos;
        int pagado      = TotalPDF(xcat, xvida, xhosp, xaporte, xotros, xprest);
        int restante    = TotalPDF(true, true, true, true, true, true) - pagado;
        int total       = TotalPDF(true, true, true, true, true, true);
        PdfPCell cell_total_pagado   = new PdfPCell(new Paragraph(Integer.toString(pagado)) );
        PdfPCell cell_total_adeudado = new PdfPCell(new Paragraph(Integer.toString(total)) );
        PdfPCell cell_total_label    = new PdfPCell(new Paragraph("Total"));
        PdfPCell cell_cargo          = new PdfPCell(new Paragraph("Nombre cargo"));
        PdfPCell cell_pagado         = new PdfPCell(new Paragraph("Monto a cancelar $"));
        PdfPCell cell_total          = new PdfPCell(new Paragraph("Valor $"));   
        PdfPCell cell_1    = new PdfPCell(new Paragraph("Seguro catastrófico"));
        PdfPCell cell_1_5  = (xcat) ?
                new PdfPCell(new Paragraph( Integer.toString(monto_seguro_catastrofico) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_2    = new PdfPCell(new Paragraph( Integer.toString(monto_seguro_catastrofico) ));
        PdfPCell cell_3    = new PdfPCell(new Paragraph("Seguro vida"));
        PdfPCell cell_3_5  = (xvida) ?
                new PdfPCell(new Paragraph(Integer.toString(monto_seguro_vida) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_4    = new PdfPCell(new Paragraph(Integer.toString(monto_seguro_vida) ));
        PdfPCell cell_5    = new PdfPCell(new Paragraph("Seguro hospitalario"));
        PdfPCell cell_5_5  =  (xhosp) ?
                new PdfPCell(new Paragraph(Integer.toString(monto_seguro_hospitalario) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_6    = new PdfPCell(new Paragraph(Integer.toString(monto_seguro_hospitalario) ));
        PdfPCell cell_7    = new PdfPCell(new Paragraph("Aportes"));
        PdfPCell cell_7_5  =  (xaporte) ?
                new PdfPCell(new Paragraph(Integer.toString(monto_aportes) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_8    = new PdfPCell(new Paragraph(Integer.toString(monto_aportes) ));
        PdfPCell cell_9    = new PdfPCell(new Paragraph("Prestamos"));
        PdfPCell cell_9_5  =  (xprest) ?
                new PdfPCell(new Paragraph(Integer.toString(monto_prestamos) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_10   = new PdfPCell(new Paragraph(Integer.toString(monto_prestamos) ));
        PdfPCell cell_11   = new PdfPCell(new Paragraph("Otros"));
        PdfPCell cell_11_5 = (xotros ) ? 
                new PdfPCell(new Paragraph(Integer.toString(monto_otros) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_12   = new PdfPCell(new Paragraph(Integer.toString(monto_otros) ));
        PdfPCell cell_13   = new PdfPCell(new Paragraph("Observaciones"));
        PdfPCell cell_14   = new PdfPCell(new Paragraph(selected.getObservaciones()));
        cell_total_pagado   = formatCell2(cell_total_pagado);
        cell_total_adeudado = formatCell2(cell_total_adeudado);
        cell_total_label    = formatCell(cell_total_label);
        cell_total          = formatCell2(cell_total);
        cell_cargo          = formatCell(cell_cargo);
        cell_pagado         = formatCell2(cell_pagado);
        cell_1    = formatCell(cell_1);
        cell_1_5  = formatCell2(cell_1_5);
        cell_2    = formatCell2(cell_2);
        cell_3    = formatCell(cell_3);
        cell_3_5  = formatCell2(cell_3_5);
        cell_4    = formatCell2(cell_4);
        cell_5    = formatCell(cell_5);
        cell_5_5  = formatCell2(cell_5_5);
        cell_6    = formatCell2(cell_6);
        cell_7    = formatCell(cell_7);
        cell_7_5  = formatCell2(cell_7_5);
        cell_8    = formatCell2(cell_8);
        cell_9    = formatCell(cell_9);
        cell_9_5  = formatCell2(cell_9_5);
        cell_10   = formatCell2(cell_10);
        cell_11   = formatCell(cell_11);
        cell_11_5 = formatCell2(cell_11_5);
        cell_12   = formatCell2(cell_12);
        cell_13   = formatCell(cell_13);
        cell_13   = formatCell(cell_14);
        table.addCell(cell_cargo);
        table.addCell(cell_total);
        table.addCell(cell_pagado);
        table.addCell(cell_1);
        table.addCell(cell_2);
        table.addCell(cell_1_5);
        table.addCell(cell_3);
        table.addCell(cell_4);
        table.addCell(cell_3_5);
        table.addCell(cell_5);
        table.addCell(cell_6);
        table.addCell(cell_5_5);
        table.addCell(cell_7);
        table.addCell(cell_8);
        table.addCell(cell_7_5);
        table.addCell(cell_9);
        table.addCell(cell_10);
        table.addCell(cell_9_5);
        table.addCell(cell_11);
        table.addCell(cell_12);
        table.addCell(cell_11_5);
        table.addCell(cell_total_label);
        table.addCell(cell_total_adeudado);
        table.addCell(cell_total_pagado);
        document.add(new Paragraph("Universidad de Santiago de Chile | Bienestar"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Detalle de pago -  cuota "+ mes + " de " + selected.getAno()));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Pensionado: "+nombre_completo));
        document.add(new Paragraph("Rut: "+ selected.getPensionado().getRut_pensionado() ));
        document.add(new Paragraph(" "));
        document.add(table);
        if (restante != 0) {
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Quedan por cancelar $" + Integer.toString(restante) +" pesos." ));
        }
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Observaciones:"));
        document.add(new Paragraph(selected.getObservaciones()));
        document.close();
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.responseReset();
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + title + "\"");
        InputStream input = new ByteArrayInputStream(baos.toByteArray());
        OutputStream output = ec.getResponseOutputStream();
        IOUtils.copy(input, output);
        fc.responseComplete();
        
    }
    
    public void createPDFdeuda() throws IOException, DocumentException{
        
        Document document = new Document();
        String mes = "";
        if(selected.getMes().equals("1") ){mes = "01";}
        if(selected.getMes().equals("2") ){mes = "02";}
        if(selected.getMes().equals("3") ){mes = "03";}
        if(selected.getMes().equals("4") ){mes = "04";}
        if(selected.getMes().equals("5") ){mes = "05";}
        if(selected.getMes().equals("6") ){mes = "06";}
        if(selected.getMes().equals("7") ){mes = "07";}
        if(selected.getMes().equals("8") ){mes = "08";}
        if(selected.getMes().equals("9") ){mes = "09";}
        if(selected.getMes().equals("10")){mes = "10";}
        if(selected.getMes().equals("11")){mes = "11";}
        if(selected.getMes().equals("12")){mes = "12";}
        String nombre_completo = selected.getPensionado().getNombre_pensionado()+" "+selected.getPensionado().getApellido_p_pensionado()+" "+selected.getPensionado().getApellido_m_pensionado();
        String title = "PAGO "+ mes +" - "+ selected.getAno() +" - "+ nombre_completo +".pdf";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.addTitle(title);
        document.open();
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        float[] columnWidths = {1f, 1f};
        table.setWidths(columnWidths);
        boolean xcat    = selected.getPagodetalles().getSeguro_catastrofico();
        boolean xvida   = selected.getPagodetalles().getSeguro_vida();
        boolean xhosp   = selected.getPagodetalles().getSeguro_hospitalario();
        boolean xaporte = selected.getPagodetalles().getAportes();
        boolean xotros  = selected.getPagodetalles().getOtros();
        boolean xprest  = selected.getPagodetalles().getPrestamos();
        int pagado      = TotalPDFdeuda(xcat, xvida, xhosp, xaporte, xotros, xprest);
        int restante    = TotalPDFdeuda(true, true, true, true, true, true) - pagado;
        int total       = TotalPDFdeuda(true, true, true, true, true, true);
        PdfPCell cell_total_pagado   = new PdfPCell(new Paragraph(Integer.toString(pagado)) );
        PdfPCell cell_total_adeudado = new PdfPCell(new Paragraph(Integer.toString(total)) );
        PdfPCell cell_total_restante = new PdfPCell(new Paragraph(Integer.toString(restante)) );
        PdfPCell cell_total_label    = new PdfPCell(new Paragraph("Total"));
        PdfPCell cell_cargo          = new PdfPCell(new Paragraph("Cargos pendientes"));
        PdfPCell cell_pagado         = new PdfPCell(new Paragraph("Monto a cancelar ($)"));
        PdfPCell cell_total          = new PdfPCell(new Paragraph("Valor ($)"));   
        PdfPCell cell_1    = new PdfPCell(new Paragraph("Seguro catastrófico"));
        PdfPCell cell_1_5  = (xcat) ?
                new PdfPCell(new Paragraph( Integer.toString(selected.getPagodetalles().getMonto_seguro_catastrofico() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_2    = new PdfPCell(new Paragraph( Integer.toString(selected.getPagodetalles().getMonto_seguro_catastrofico() ) ));
        PdfPCell cell_3    = new PdfPCell(new Paragraph("Seguro vida"));
        PdfPCell cell_3_5  = (xvida) ?
                new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_seguro_vida() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_4    = new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_seguro_vida() ) ));
        PdfPCell cell_5    = new PdfPCell(new Paragraph("Seguro hospitalario"));
        PdfPCell cell_5_5  =  (xhosp) ?
                new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_seguro_hospitalario() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_6    = new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_seguro_hospitalario() ) ));
        PdfPCell cell_7    = new PdfPCell(new Paragraph("Aportes"));
        PdfPCell cell_7_5  =  (xaporte) ?
                new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_aportes() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_8    = new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_aportes() ) ));
        PdfPCell cell_9    = new PdfPCell(new Paragraph("Prestamos"));
        PdfPCell cell_9_5  =  (xprest) ?
                new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_prestamos() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_10   = new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_prestamos() ) ));
        PdfPCell cell_11   = new PdfPCell(new Paragraph("Otros"));
        PdfPCell cell_11_5 = (xotros ) ? 
                new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_otros() ) )) :
                new PdfPCell(new Paragraph("0"));
        PdfPCell cell_12   = new PdfPCell(new Paragraph(Integer.toString(selected.getPagodetalles().getMonto_otros() ) ));
        PdfPCell cell_13   = new PdfPCell(new Paragraph("Observaciones"));
        PdfPCell cell_14   = new PdfPCell(new Paragraph(selected.getObservaciones()));
        cell_total_pagado   = formatCell2(cell_total_pagado);
        cell_total_adeudado = formatCell2(cell_total_adeudado);
        cell_total_adeudado = formatCell2(cell_total_restante);
        cell_total_label    = formatCell(cell_total_label);
        cell_total          = formatCell2(cell_total);
        cell_cargo          = formatCell(cell_cargo);
        cell_pagado         = formatCell2(cell_pagado);
        cell_1    = formatCell(cell_1);
        cell_1_5  = formatCell2(cell_1_5);
        cell_2    = formatCell2(cell_2);
        cell_3    = formatCell(cell_3);
        cell_3_5  = formatCell2(cell_3_5);
        cell_4    = formatCell2(cell_4);
        cell_5    = formatCell(cell_5);
        cell_5_5  = formatCell2(cell_5_5);
        cell_6    = formatCell2(cell_6);
        cell_7    = formatCell(cell_7);
        cell_7_5  = formatCell2(cell_7_5);
        cell_8    = formatCell2(cell_8);
        cell_9    = formatCell(cell_9);
        cell_9_5  = formatCell2(cell_9_5);
        cell_10   = formatCell2(cell_10);
        cell_11   = formatCell(cell_11);
        cell_11_5 = formatCell2(cell_11_5);
        cell_12   = formatCell2(cell_12);
        cell_13   = formatCell(cell_13);
        cell_13   = formatCell(cell_14);
        table.addCell(cell_cargo);
        table.addCell(cell_total);
//        table.addCell(cell_pagado);
        if (!xcat && selected.getPagodetalles().getMonto_seguro_catastrofico() != 0) {
            table.addCell(cell_1);
            table.addCell(cell_2);
//            table.addCell(cell_1_5);            
        }
        if (!xvida && selected.getPagodetalles().getMonto_seguro_vida() != 0) {
            table.addCell(cell_3);
            table.addCell(cell_4);
//            table.addCell(cell_3_5);
        }
        if (!xhosp && selected.getPagodetalles().getMonto_seguro_hospitalario() != 0) {
            table.addCell(cell_5);
            table.addCell(cell_6);
//            table.addCell(cell_5_5);
        }
        if (!xaporte && selected.getPagodetalles().getMonto_aportes() != 0) {
            table.addCell(cell_7);
            table.addCell(cell_8);
//            table.addCell(cell_7_5);
        }
        if (!xprest && selected.getPagodetalles().getMonto_prestamos() != 0) {
            table.addCell(cell_9);
            table.addCell(cell_10);
//            table.addCell(cell_9_5);
        }
        if (!xotros && selected.getPagodetalles().getMonto_otros() != 0) {
            table.addCell(cell_11);
            table.addCell(cell_12);
//            table.addCell(cell_11_5);
        }
        table.addCell(cell_total_label);
        table.addCell(cell_total_restante);
//        table.addCell(cell_total_pagado);
        document.add(new Paragraph("Universidad de Santiago de Chile | Bienestar"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Detalle de deuda -  cuota "+ mes + " de " + selected.getAno()));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Pensionado: "+nombre_completo));
        document.add(new Paragraph("Rut: "+ selected.getPensionado().getRut_pensionado() ));
        document.add(new Paragraph(" "));
        document.add(table);
        if (restante != 0) {
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Quedan por cancelar $" + Integer.toString(restante) +" pesos." ));
        }
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Observaciones:"));
        document.add(new Paragraph(selected.getObservaciones()));
        document.close();
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.responseReset();
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + title + "\"");
        InputStream input = new ByteArrayInputStream(baos.toByteArray());
        OutputStream output = ec.getResponseOutputStream();
        IOUtils.copy(input, output);
        fc.responseComplete();
        
    }

    private PdfPCell formatCell(PdfPCell cell) {
            cell.setBorderColor(BaseColor.BLACK);
            cell.setPaddingLeft(10);
            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);            
            return cell;
    }

    private PdfPCell formatCell2(PdfPCell cell) {
            cell.setBorderColor(BaseColor.BLACK);
            cell.setPaddingLeft(10);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
            return cell;
    }
    
    public int TotalPDF(boolean cat,boolean vida,boolean hosp,boolean aporte,boolean otros,boolean prest){
        int valor = 0;
        if(cat) valor = valor + monto_seguro_catastrofico;
        if(vida) valor = valor + monto_seguro_vida;
        if(hosp) valor = valor + monto_seguro_hospitalario;
        if(aporte) valor = valor + monto_aportes;
        if(otros) valor = valor + monto_otros;
        if(prest) valor = valor + monto_prestamos;
        return valor;
    }
    
    public int TotalPDFdeuda(boolean cat,boolean vida,boolean hosp,boolean aporte,boolean otros,boolean prest){
        int valor = 0;
        if(cat) valor = valor + selected.getPagodetalles().getMonto_seguro_catastrofico();
        if(vida) valor = valor + selected.getPagodetalles().getMonto_seguro_vida();
        if(hosp) valor = valor + selected.getPagodetalles().getMonto_seguro_hospitalario();
        if(aporte) valor = valor + selected.getPagodetalles().getMonto_aportes();
        if(otros) valor = valor + selected.getPagodetalles().getMonto_otros();
        if(prest) valor = valor + selected.getPagodetalles().getMonto_prestamos();
        return valor;
    }
    
    public void update() {
        pagodetalle.update();
        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("pagoUpdated"));
        
        Date ahora = Date.from(Instant.now());
        getItems();
        Long ultimo = selected.getId();
         
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("RUT");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPensionado().getRut_pensionado());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("NOMBRE");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getPensionado().getNombre_pensionado()+" "+selected.getPensionado().getApellido_p_pensionado()+" "+selected.getPensionado().getApellido_m_pensionado());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();
        auditoria.prepareCreate(); 
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("MES");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getMes());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create(); 
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("AÑO");
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(selected.getAno());
        auditoria.getSelected().setFechayhora(ahora);
        auditoria.getSelected().setId_registro(ultimo);
        auditoria.create();        
        auditoria.prepareCreate();
        auditoria.getSelected().setNombre_usuario(usuario.getNombreCompleto());
        auditoria.getSelected().setNombre_tabla("PAGO");
        auditoria.getSelected().setNombre_columna("PAGO (TOTAL)");
        boolean xcat  = selected.getPagodetalles().getSeguro_catastrofico();
        boolean xvida = selected.getPagodetalles().getSeguro_vida();
        boolean xhosp = selected.getPagodetalles().getSeguro_hospitalario();
        boolean xaporte = selected.getPagodetalles().getAportes();
        boolean xotros = selected.getPagodetalles().getOtros();
        boolean xprest = selected.getPagodetalles().getPrestamos();
        auditoria.getSelected().setValor_antiguo("NULL");
        auditoria.getSelected().setValor_nuevo(Integer.toString(Total(xcat, xvida, xhosp, xaporte, xotros, xprest)));
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
        persist(PersistAction.DELETE, "Error: Para el pensionado, ya existe un pago con este mes y año");
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

