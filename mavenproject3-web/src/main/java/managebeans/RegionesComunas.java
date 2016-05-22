/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RegionesComunas implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private Map<String,String> countries;
    private Map<String,String> cities;
     
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("ARICA Y PARINACOTA", "ARICA Y PARINACOTA");
        countries.put("TARAPACA", "TARAPACA");
        countries.put("ANTOFAGASTA", "ANTOFAGASTA");
        countries.put("ATACAMA", "ATACAMA");
        countries.put("COQUIMBO", "COQUIMBO");
        countries.put("VALPARAISO", "VALPARAISO");
        countries.put("LIBERTADOR BERNARDO OHIGGINS", "LIBERTADOR BERNARDO OHIGGINS");
        countries.put("MAULE", "MAULE");
        countries.put("BIO BIO", "BIO BIO");
        countries.put("ARAUCANIA", "ARAUCANIA");
        countries.put("LOS RIOS", "LOS RIOS");
        countries.put("LOS LAGOS", "LOS LAGOS");
        countries.put("AISEN DEL GENERAL CARLOS IBAÑEZ DEL CAMPO", "AISEN DEL GENERAL CARLOS IBAÑEZ DEL CAMPO");
        countries.put("MAGALLANES Y LA ANTARTICA CHILENA", "MAGALLANES Y LA ANTARTICA CHILENA");
        countries.put("METROPOLITANA", "METROPOLITANA");
        
        countries = Ordenar(countries);

         
        Map<String,String> map = new HashMap<String, String>();
        map.put("ARICA", "ARICA");
        map.put("CAMARONES", "CAMARONES");
        map.put("PUTRE", "PUTRE");
        map.put("GENERAL LAGOS", "GENERAL LAGOS");
        map = Ordenar(map);
        data.put("ARICA Y PARINACOTA", map);
         
        map = new HashMap<String, String>();
        map.put("IQUIQUE", "IQUIQUE");
        map.put("ALTO HOSPICIO", "ALTO HOSPICIO");
        map.put("POZO ALMONTE", "POZO ALMONTE");
        map.put("CAMIÑA", "CAMIÑA");
        map.put("COLCHANE", "COLCHANE");
        map.put("HUARA", "HUARA");
        map.put("PICA", "PICA");
        map = Ordenar(map);
        data.put("TARAPACA", map);
        
        map = new HashMap<String, String>();
        map.put("ANTOFAGASTA", "ANTOFAGASTA");
        map.put("MEJILLONES", "MEJILLONES");
        map.put("SIERRA GORDA", "SIERRA GORDA");
        map.put("TALTAL", "TALTAL");
        map.put("CALAMA", "CALAMA");
        map.put("OLLAGUE", "OLLAGUE");
        map.put("SAN PEDRO DE ATACAMA", "SAN PEDRO DE ATACAMA");
        map.put("TOCOPILLA", "TOCOPILLA");
        map.put("MARIA ELENA", "MARIA ELENA");
        map = Ordenar(map);
        data.put("ANTOFAGASTA", map);
      
        map = new HashMap<String, String>();
        map.put("COPIAPO", "COPIAPO");
        map.put("CALDERA", "CALDERA");
        map.put("TIERRA AMARILLA", "TIERRA AMARILLA");
        map.put("CHAÑARAL", "CHAÑARAL");
        map.put("DIEGO DE ALMAGRO", "DIEGO DE ALMAGRO");
        map.put("VALLENAR", "VALLENAR");
        map.put("ALTO DEL CARMEN", "ALTO DEL CARMEN");
        map.put("FREIRINA", "FREIRINA");
        map.put("HUASCO", "HUASCO");
        map = Ordenar(map);
        data.put("ATACAMA", map);

        map = new HashMap<String, String>();
        map.put("LA SERENA", "LA SERENA");
        map.put("COQUIMBO", "COQUIMBO");
        map.put("ANDACOLLO", "ANDACOLLO");
        map.put("LA HIGUERA", "LA HIGUERA");
        map.put("PAIGUANO", "PAIGUANO");
        map.put("VICUÑA", "VICUÑA");
        map.put("ILLAPEL", "ILLAPEL");
        map.put("CANELA", "CANELA");
        map.put("LOS VILOS", "LOS VILOS");
        map.put("SALAMANCA", "SALAMANCA");
        map.put("OVALLE", "OVALLE");
        map.put("COMBARBALA", "COMBARBALA");
        map.put("MONTE PATRIA", "MONTE PATRIAO");
        map.put("PUNITAQUI", "PUNITAQUISCO");
        map.put("RIO HURTADO", "RIO HURTADO");
        map = Ordenar(map);
        data.put("COQUIMBO", map);

        map = new HashMap<String, String>();
        map.put("VALPARAISO", "VALPARAISO");
        map.put("CASABLANCA", "CASABLANCAA");
        map.put("CONCON", "CONCONA");
        map.put("JUAN FERNANDEZ", "JUAN FERNANDEZ");
        map.put("PUCHUNCAVI", "PUCHUNCAVI");
        map.put("QUINTERO", "QUINTERO");
        map.put("VIÑA DEL MAR", "VIÑA DEL MAR");
        map.put("ISLA DE PASCUA", "ISLA DE PASCUA");
        map.put("LOS ANDES", "LOS ANDES");
        map.put("CALLE LARGA", "CALLE LARGA");
        map.put("RINCONADA", "RINCONADA");
        map.put("SAN ESTEBAN", "SAN ESTEBAN");
        map.put("LA LIGUA", "LA LIGUA");
        map.put("CABILDO", "CABILDO");
        map.put("PAPUDO", "PAPUDO");
        map.put("PETORCA", "PETORCA");
        map.put("ZAPALLAR", "ZAPALLAR");
        map.put("QUILLOTA", "QUILLOTA");
        map.put("CALERA", "CALERA");
        map.put("HIJUELAS", "HIJUELAS");
        map.put("LA CRUZ", "LA CRUZ");
        map.put("NOGALES", "NOGALES");
        map.put("SAN ANTONIO", "SAN ANTONIO");
        map.put("ALGARROBO", "ALGARROBO");
        map.put("CARTAGENA", "CARTAGENA");
        map.put("EL QUISCO", "EL QUISCO");
        map.put("EL TABO", "EL TABO");
        map.put("SANTO DOMINGO", "SANTO DOMINGO");
        map.put("SAN FELIPE", "SAN FELIPE");
        map.put("LLAILLAY", "LLAILLAY");
        map.put("PANQUEHUE", "PANQUEHUE");
        map.put("PUTAENDO", "PUTAENDO");
        map.put("SANTA MARIA", "SANTA MARIA");
        map.put("QUILPUE", "QUILPUE");
        map.put("LIMACHE", "LIMACHE");
        map.put("OLMUE", "OLMUE");
        map.put("VILLA ALEMANA", "VILLA ALEMANA");
        map = Ordenar(map);
        data.put("VALPARAISO", map);

        map = new HashMap<String, String>();
        map.put("RANCAGUA", "RANCAGUA");
        map.put("CODEGUA", "CODEGUA");
        map.put("COINCO", "COINCO");
        map.put("COLTAUCO", "COLTAUCO");
        map.put("DOÑIHUE", "DOÑIHUE");
        map.put("GRANEROS", "GRANEROS");
        map.put("LAS CABRAS", "LAS CABRAS");
        map.put("MACHALI", "MACHALI");
        map.put("MALLOA", "MALLOA");
        map.put("MOSTAZAL", "MOSTAZAL");
        map.put("OLIVAR", "OLIVAR");
        map.put("PEUMO", "PEUMO");
        map.put("PICHIDEGUA", "PICHIDEGUA");
        map.put("QUINTA DE TILCOCO", "QUINTA DE TILCOCO");
        map.put("RENGO", "RENGO");
        map.put("REQUINOA", "REQUINOA");
        map.put("SAN VICENTE", "SAN VICENTE");
        map.put("PICHILEMU", "PICHILEMU");
        map.put("LA ESTRELLA", "LA ESTRELLA");
        map.put("LITUECHE", "LITUECHE");
        map.put("MARCHIHUE", "MARCHIHUE");
        map.put("NAVIDAD", "NAVIDAD");
        map.put("PAREDONES", "PAREDONES");
        map.put("SAN FERNANDO", "SAN FERNANDO");
        map.put("CHEPICA", "CHEPICA");
        map.put("CHIMBARONGO", "CHIMBARONGO");
        map.put("LOLOL", "LOLOL");
        map.put("NANCAGUA", "NANCAGUA");
        map.put("PALMILLA", "PALMILLA");
        map.put("PERAILILLO", "PERAILILLO");
        map.put("PLACILLA", "PLACILLA");
        map.put("PUMANQUE", "PUMANQUE");
        map.put("SANTA CRUZ", "SANTA CRUZ");
        map = Ordenar(map);
        data.put("LIBERTADOR BERNARDO OHIGGINS", map);
      
        map = new HashMap<String, String>();
        map.put("TALCA", "TALCA");
        map.put("CONSTITUCION", "CONSTITUCION");
        map.put("CUREPTO", "CUREPTO");
        map.put("EMPEDRADO", "EMPEDRADO");
        map.put("MAULE", "MAULE");
        map.put("PELARCO", "PELARCO");
        map.put("PENCAHUE", "PENCAHUE");
        map.put("RIO CLARO", "RIO CLARO");
        map.put("SAN CLEMENTE", "SAN CLEMENTE");
        map.put("SAN RAFAEL", "SAN RAFAEL");
        map.put("CAHUQUENES", "CAHUQUENES");
        map.put("CHANCO", "CHANCO");
        map.put("PELLUHUE", "PELLUHUE");
        map.put("CURICO", "CURICO");
        map.put("HUALAÑE", "HUALAÑE");
        map.put("LICANTEN", "LICANTEN");
        map.put("MOLINA", "MOLINA");
        map.put("RAUCO", "RAUCO");
        map.put("ROMERAL", "ROMERAL");
        map.put("SAGRADA FAMILIA", "SAGRADA FAMILIA");
        map.put("TENO", "TENO");
        map.put("VICHUQUEN", "VICHUQUEN");
        map.put("LINARES", "LINARES");
        map.put("COLBUN", "COLBUN");
        map.put("LONGAVI", "LONGAVI");
        map.put("PARRAL", "PARRAL");
        map.put("RERO", "RERO");
        map.put("SAN JAVIER", "SAN JAVIER");
        map.put("VILLA ALEGRE", "VILLA ALEGRE");
        map.put("YERBAS BUENAS", "YERBAS BUENAS");
        map = Ordenar(map);
        data.put("MAULE", map);

        map = new HashMap<String, String>();
        map.put("CONCEPCION", "CONCEPCION");
        map.put("CORONEL", "CORONEL");
        map.put("CHIGUAYANTE", "CHIGUAYANTE");
        map.put("FLORIDA", "FLORIDA");
        map.put("HUALQUI", "HUALQUI");
        map.put("LOTA", "LOTA");
        map.put("PENCO", "PENCO");
        map.put("SAN PEDRO DE LA PAZ", "SAN PEDRO DE LA PAZ");
        map.put("SANTA JUANA", "SANTA JUANA");
        map.put("TALCAHUANO", "TALCAHUANO");
        map.put("TOME", "TOME");
        map.put("HUALPEN", "HUALPEN");
        map.put("LEBU", "LEBU");
        map.put("ARAUCO", "ARAUCO");
        map.put("CAÑETE", "CAÑETE");
        map.put("CONTULMO", "CONTULMO");
        map.put("CURANILAHUE", "CURANILAHUE");
        map.put("LOS ALAMOS", "LOS ALAMOS");
        map.put("TIRUA", "TIRUA");
        map.put("LOS ANGELES", "LOS ANGELES");
        map.put("ANTAUCO", "ANTAUCO");
        map.put("CABRERO", "CABRERO");
        map.put("LAJA", "LAJA");
        map.put("MULCHEN", "MULCHEN");
        map.put("NACIMIENTO", "NACIMIENTO");
        map.put("NEGRETE", "NEGRETE");
        map.put("QUILACO", "QUILACO");
        map.put("QUILLECO", "QUILLECO");
        map.put("SAN ROSENDO", "SAN ROSENDO");
        map.put("SANTA BARBARA", "SANTA BARBARA");
        map.put("TUCAPEL", "TUCAPEL");
        map.put("YUMBEL", "YUMBEL");
        map.put("ALTO BIOBIO", "ALTO BIOBIO");
        map.put("CHILLAN", "CHILLAN");
        map.put("BULNES", "BULNES");
        map.put("COBQUECURA", "COBQUECURA");
        map.put("COELEMU", "COELEMU");
        map.put("COIHUECO", "COIHUECO");
        map.put("CHILLAN VIEJO", "CHILLAN VIEJO");
        map.put("EL CARMEN", "EL CARMEN");
        map.put("PEMUCO", "PEMUCO");
        map.put("PORTEZUELO", "PORTEZUELO");
        map.put("QUILLON", "QUILLON");
        map.put("QUIRIHUE", "QUIRIHUE");
        map.put("QUIRIHUE", "QUIRIHUE");
        map.put("RANQUIL", "RANQUIL");
        map.put("SAN CARLOS", "SAN CARLOS");
        map.put("SAN FABIAN", "SAN FABIAN");
        map.put("SAN IGNACIO", "SAN IGNACIO");
        map.put("SAN NICOLAS", "SAN NICOLAS");
        map.put("TREGUACO", "TREGUACO");
        map.put("YUNGAI", "YUNGAI");
        map = Ordenar(map);
        data.put("BIO BIO", map);

        map = new HashMap<String, String>();
        map.put("CERRILLOS", "CERRILLOS");
        map.put("CERRO NAVIA", "CERRO NAVIA");
        map.put("CONCHALI", "CONCHALI");
        map.put("EL BOSQUE", "EL BOSQUE");
        map.put("ESTACION CENTRAL", "ESTACION CENTRAL");
        map.put("HUECHURABA", "HUECHURABA");
        map.put("INDEPENDENCIA", "INDEPENDENCIA");
        map.put("LA CISTERNA", "LA CISTERNA");
        map.put("LA FLORIDA", "LA FLORIDA");
        map.put("LA GRANJA", "LA GRANJA");
        map.put("LA PINTANA", "LA PINTANA");
        map.put("LA REINA", "LA REINA");
        map.put("LAS CONDES", "LAS CONDES");
        map.put("LO BARNECHEA", "LO BARNECHEA");
        map.put("LO ESPEJO", "LO ESPEJO");
        map.put("LO PRADO", "LO PRADO");
        map.put("MACUL", "MACUL");
        map.put("MAIPU", "MAIPU");
        map.put("ÑUÑOA", "ÑUÑOA");
        map.put("PEDRO AGUIRRE CERDA", "PEDRO AGUIRRE CERDA");
        map.put("PEÑALOLEN", "PEÑALOLEN");
        map.put("PROVIDENCIA", "PROVIDENCIA");
        map.put("PUDAHUEL", "PUDAHUEL");
        map.put("QUILICURA", "QUILICURA");
        map.put("QUINTA NORMAL", "QUINTA NORMAL");
        map.put("RECOLETA", "RECOLETA");
        map.put("RENCA", "RENCA");
        map.put("SAN JOAQUIN", "SAN JOAQUIN");
        map.put("SAN MIGUEL", "SAN MIGUEL");
        map.put("SAN RAMON", "SAN RAMON");
        map.put("VITACURA", "VITACURA");
        map.put("PUENTE ALTO", "PUENTE ALTO");
        map.put("PIRQUE", "PIRQUE");
        map.put("SAN JOSE DE MAIPO", "SAN JOSE DE MAIPO");
        map.put("COLINA", "COLINA");
        map.put("LAMPA", "LAMPA");
        map.put("TILTIL", "TILTIL");
        map.put("SAN BERNARDO", "SAN BERNARDO");
        map.put("BUIN", "BUIN");
        map.put("CALERA DE TANGO", "CALERA DE TANGO");
        map.put("PAINE", "PAINE");
        map.put("MELIPILLA", "MELIPILLA");
        map.put("ALHUE", "ALHUE");
        map.put("CURACAVI", "CURACAVI");
        map.put("MARIA PINTO", "MARIA PINTO");
        map.put("SAN PEDRO", "SAN PEDRO");
        map.put("TALAGANTE", "TALAGANTE");
        map.put("EL MONTE", "EL MONTE");
        map.put("ISLA DE MAIPO", "ISLA DE MAIPO");
        map.put("PADRE HURTADO", "PADRE HURTADO");
        map.put("PEÑAFLOR", "PEÑAFLOR");
        map.put("SANTIAGO","SANTIAGO");
        map = Ordenar(map);
         data.put("METROPOLITANA", map);

        map = new HashMap<String, String>();
        map.put("TEMUCO", "TEMUCO");
        map.put("CARAHUE", "CARAHUE");
        map.put("CUNCO", "CUNCO");
        map.put("CARARREHUE", "CARARREHUE");
        map.put("FREIRE", "FREIRE");
        map.put("GALVARINO", "GALVARINO");
        map.put("GORBEA", "GORBEA");
        map.put("LAUTARO", "LAUTARO");
        map.put("LONCOCHE", "LONCOCHE");
        map.put("MELIPEUCO", "MELIPEUCO");
        map.put("NUEVA IMPERIAL", "NUEVA IMPERIAL");
        map.put("PADRE DE LAS CASAS", "PADRE DE LAS CASAS");
        map.put("PERQUENCO", "PERQUENCO");
        map.put("PITRUFQUEN", "PITRUFQUEN");
        map.put("PUCON", "PUCON");
        map.put("SAAVEDRA", "SAAVEDRA");
        map.put("TEODORO SCHMIDT", "TEODORO SCHMIDT");
        map.put("TOLTEN", "TOLTEN");
        map.put("VILCUN", "VILCUN");
        map.put("VILLARRICA", "VILLARRICA");
        map.put("CHOLCHOL", "CHOLCHOL");
        map.put("ANGOL", "ANGOL");
        map.put("COLLIPULLI", "COLLIPULLI");
        map.put("CURACAUTIN", "CURACAUTIN");
        map.put("ERCILLA", "ERCILLA");
        map.put("LONQUIMAY", "LONQUIMAY");
        map.put("LOS SAUCES", "LOS SAUCES");
        map.put("LUMACO", "LUMACO");
        map.put("PUREN", "PUREN");
        map.put("REINACO", "REINACO");
        map.put("TRAIGUEN", "TRAIGUEN");
        map.put("VICTORIA", "VICTORIA");
        map = Ordenar(map);
        data.put("ARAUCANIA", map);

        map = new HashMap<String, String>();
        map.put("VALDIVIA", "VALDIVIA");
        map.put("CORRAL", "CORRAL");
        map.put("LANCO", "LANCO");
        map.put("LOS LAGOS", "LOS LAGOS");
        map.put("MAFIL", "MAFIL");
        map.put("MARIQUINA", "MARIQUINA");
        map.put("PAILLACO", "PAILLACO");
        map.put("PANGUIPULLI", "PANGUIPULLI");
        map.put("LA UNION", "LA UNION");
        map.put("FUTRONO", "FUTRONO");
        map.put("LAGO RANCO", "LAGO RANCO");
        map.put("RIO BUENO", "RIO BUENO");
        map = Ordenar(map);
        data.put("LOS RIOS", map);


        map = new HashMap<String, String>();
        map.put("PUERTO MONTT", "PUERTO MONTT");
        map.put("CALBUCO", "CALBUCO");
        map.put("COCHAMO", "COCHAMO");
        map.put("FRESIA", "FRESIA");
        map.put("FRUTILLAR", "FRUTILLAR");
        map.put("LOS MUERMOS", "LOS MUERMOS");
        map.put("LLANGUIHUE", "LLANGUIHUE");
        map.put("MAULLIN", "MAULLIN");
        map.put("PUERTO VARAS", "PUERTO VARAS");
        map.put("CASTRO", "CASTRO");
        map.put("ANCUD", "ANCUD");
        map.put("CHONCHI", "CHONCHI");
        map.put("CURACO DE VELEZ", "CURACO DE VELEZ");
        map.put("DALCAHUE", "DALCAHUE");
        map.put("PUQUELDON", "PUQUELDON");
        map.put("QUEILEN", "QUEILEN");
        map.put("QUELLON", "QUELLON");
        map.put("QUEMCHI", "QUEMCHI");
        map.put("QUINCHAO", "QUINCHAO");
        map.put("OSORNO", "OSORNO");
        map.put("PUERTO OCTAY", "PUERTO OCTAY");
        map.put("PURRANQUE", "PURRANQUE");
        map.put("PUYEHUE", "PUYEHUE");
        map.put("RIO NEGRO", "RIO NEGRO");
        map.put("SAN JUAN DE LA COSTA", "SAN JUAN DE LA COSTA");
        map.put("SAN PABLO", "SAN PABLO");
        map.put("CHAITEN", "CHAITEN");
        map.put("FUTALEUFU", "FUTALEUFU");
        map.put("HUALAIHUE", "HUALAIHUE");
        map.put("PALENA", "PALENA");
        map = Ordenar(map);
        data.put("LOS LAGOS", map);

        map = new HashMap<String, String>();
        map.put("COIHAIQUE", "COIHAIQUE");
        map.put("LAGO VERDE", "LAGO VERDE");
        map.put("AISEN", "AISEN");
        map.put("CISNES", "CISNES");
        map.put("GUAITECAS", "GUAITECAS");
        map.put("COCHRANE", "COCHRANE");
        map.put("OHIGGINS", "OHIGGINS");
        map.put("TORTEL", "TORTEL");
        map.put("CHILE CHICO", "CHILE CHICO");
        map.put("RIO IBAÑEZ", "RIO IBAÑEZ");
        map = Ordenar(map);
        data.put("AISEN DEL GENERAL CARLOS IBAÑEZ DEL CAMPO", map);

        map = new HashMap<String, String>();
        map.put("PUNTA ARENAS", "PUNTA ARENAS");
        map.put("LAGUNA BLANCA", "LAGUNA BLANCA");
        map.put("RIO VERDE", "RIO VERDE");
        map.put("SAN GREGORIO", "SAN GREGORIO");
        map.put("CABO DE HORNOS", "CABO DE HORNOS");
        map.put("ANTARTICA", "ANTARTICA");
        map.put("PORVENIR", "PORVENIR");
        map.put("PRIMAVERA", "PRIMAVERA");
        map.put("TIMAUKEL", "TIMAUKEL");
        map.put("NATALES", "NATALES");
        map.put("TORRES DEL PAINE", "TORRES DEL PAINE");
        map = Ordenar(map);
        data.put("MAGALLANES Y LA ANTARTICA CHILENA", map);
    }
 
    
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    private Map<String,String> Ordenar(Map mapa){
        System.out.println("ESTOY dentro del ordenaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar");
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
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        System.out.println("SE EJECUTA ONCOUNTRYCHANGE");
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
            
            
}