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
public class Dropdown implements Serializable {
     
    private Map<String,String> parentesco;
     
    @PostConstruct
    public void init() {
        parentesco  = new HashMap<String, String>();
        parentesco.put("PADRE", "PADRE");
        parentesco.put("MADRE", "MADRE");
        parentesco.put("PADRASTRO", "PADRASTRO");
        parentesco.put("MADRASTRA", "MADRASTRA");
        parentesco.put("HIJO/A", "HIJO/A");
        parentesco.put("CÓNYUGE", "CÓNYUGE");
        parentesco.put("SUEGRO/A", "SUEGRO/A");
        parentesco.put("YERNO", "YERNO");
        parentesco.put("NUERA", "NUERA");
        parentesco.put("ABUELO/A", "ABUELO/A");
        parentesco.put("NIETO/A", "NIETO/A");
        parentesco.put("HERMANO/A", "HERMANO/A");
        parentesco.put("HERMANASTRO/A", "HERMANASTRO/A");
        parentesco.put("CUÑADO/A", "CUÑADO/A");
        parentesco.put("BISABUELO/A", "BISABUELO/A");
        parentesco.put("BISNIETO/A", "BISNIETO/A");
        parentesco.put("TÍO/A", "TÍO/A");
        parentesco.put("SOBRINO/A", "SOBRINO/A");
        parentesco.put("PRIMO/A", "PRIMO/A");
        
        
        parentesco = Ordenar(parentesco);
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
    
    public Map<String, String> getParentesco() {
        return parentesco;
    }     
}