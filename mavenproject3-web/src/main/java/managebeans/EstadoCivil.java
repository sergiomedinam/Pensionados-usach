package managebeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@ViewScoped
public class EstadoCivil implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String estado; 
    private Map<String,String> estadosCiviles;
     
    @PostConstruct
    public void init() {
        estadosCiviles  = new HashMap<String, String>();
        estadosCiviles.put("SOLTERO/A", "SOLTERO/A");
        estadosCiviles.put("CASADO/A", "CASADO/A");
        estadosCiviles.put("VIUDO/A", "VIUDO/A");
        estadosCiviles.put("DIVORCIADO/A", "DIVORCIADO/A");
        estadosCiviles.put("SEPARADO/A", "SEPARADO/A");
        estadosCiviles.put("CONVIVIENTE", "CONVIVIENTE");
        
        estadosCiviles = Ordenar(estadosCiviles);
    }
 
    
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    private Map<String,String> Ordenar(Map mapa){
        Map mapOrdenado = new TreeMap(mapa);
        Set ref = mapOrdenado.keySet();
        Iterator it = ref.iterator();
        //Ordenar
        HashMap mapResultado = new LinkedHashMap();
        List misMapKeys = new ArrayList(mapa.keySet());
        List misMapValues = new ArrayList(mapa.values());
        TreeSet conjuntoOrdenado = new TreeSet(misMapValues);
        Object[] arrayOrdenado = conjuntoOrdenado.toArray();
        int size = arrayOrdenado.length;
        for (int i=0; i<size; i++) {
            mapResultado.put(misMapKeys.get(misMapValues.indexOf(arrayOrdenado[i])),arrayOrdenado[i]);
        }
        return mapResultado;
    }
 
    public String getEstado() {
        return estado;
    }
 
    public void setEstado(String estado) {
        this.estado = estado;
    }
 
    public Map<String, String> getEstadosCiviles() {
        return estadosCiviles;
    }     
}