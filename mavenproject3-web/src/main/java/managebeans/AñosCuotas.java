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
public class AñosCuotas implements Serializable {
     
    private Map<Integer,Integer> añosCuotas;
    private Map<String,Integer> numeroCuotas;
    private Map<String,Integer> nCuotas;
     
    @PostConstruct
    public void init() {
        añosCuotas  = new HashMap<Integer, Integer>();
        añosCuotas.put(2015, 2015);
        añosCuotas.put(2016, 2016);
        añosCuotas.put(2017, 2017);
        añosCuotas.put(2018, 2018);
        añosCuotas.put(2019, 2019);
        añosCuotas.put(2020, 2020);
        añosCuotas.put(2021, 2021);
        añosCuotas.put(2022, 2022);
        añosCuotas.put(2023, 2023);
        añosCuotas.put(2024, 2024);
        añosCuotas.put(2025, 2025);
        añosCuotas.put(2026, 2026);
        añosCuotas.put(2027, 2027);
        añosCuotas.put(2028, 2028);
        añosCuotas.put(2029, 2029);
        añosCuotas.put(2030, 2030);
        añosCuotas.put(2031, 2031);
        añosCuotas.put(2032, 2032);
        añosCuotas.put(2033, 2033);
        añosCuotas.put(2034, 2034);
        añosCuotas.put(2035, 2035);
        añosCuotas.put(2036, 2036);
        añosCuotas.put(2037, 2037);
        añosCuotas.put(2038, 2038);
        añosCuotas.put(2039, 2039);
        añosCuotas.put(2040, 2040);
        añosCuotas.put(2041, 2041);
        añosCuotas.put(2042, 2042);
        añosCuotas.put(2043, 2043);
        añosCuotas.put(2044, 2044);
        añosCuotas.put(2045, 2045);
        añosCuotas.put(2046, 2046);
        añosCuotas.put(2047, 2047);
        añosCuotas.put(2048, 2048);
        añosCuotas.put(2049, 2049);
        añosCuotas.put(2050, 2050);
        
        añosCuotas = Ordenar(añosCuotas);
        
        
        numeroCuotas  = new HashMap<String, Integer>();
        
        numeroCuotas.put("ENERO", 1);
        numeroCuotas.put("FEBRERO", 2);
        numeroCuotas.put("MARZO", 3);
        numeroCuotas.put("ABRIL", 4);
        numeroCuotas.put("MAYO", 5);
        numeroCuotas.put("JUNIO", 6);
        numeroCuotas.put("JULIO", 7);
        numeroCuotas.put("AGOSTO", 8);
        numeroCuotas.put("SEPTIEMBRE", 9);
        numeroCuotas.put("OCTUBRE", 10);
        numeroCuotas.put("NOVIEMBRE", 11);
        numeroCuotas.put("DICIEMBRE", 12);
        numeroCuotas.put("NINGUNO",0);
        
        numeroCuotas = OrdenarValores(numeroCuotas);

        nCuotas  = new HashMap<String, Integer>();
        
        nCuotas.put("ENERO", 1);
        nCuotas.put("FEBRERO", 2);
        nCuotas.put("MARZO", 3);
        nCuotas.put("ABRIL", 4);
        nCuotas.put("MAYO", 5);
        nCuotas.put("JUNIO", 6);
        nCuotas.put("JULIO", 7);
        nCuotas.put("AGOSTO", 8);
        nCuotas.put("SEPTIEMBRE", 9);
        nCuotas.put("OCTUBRE", 10);
        nCuotas.put("NOVIEMBRE", 11);
        nCuotas.put("DICIEMBRE", 12);
        
        nCuotas = OrdenarValores(nCuotas);
    }
    
    private Map<Integer,Integer> Ordenar(Map mapa){
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
    
    private Map<String,Integer> OrdenarValores(Map mapa){
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
 

 
    public Map<Integer, Integer> getAñosCuotas() {
        return añosCuotas;
    }
    
    public Map<String, Integer> getNumeroCuotas() {
        return numeroCuotas;
    }   
    public Map<String, Integer> getNCuotas() {
        return nCuotas;
    }   
}