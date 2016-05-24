/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nelson
 */
public class pensionadoTest {
    
    public pensionadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmail_alternativo method, of class pensionado.
     */
    @Test
    public void testGetEmail_alternativo() {
        System.out.println("getEmail_alternativo");
        pensionado instance = new pensionado();
        String expResult = "test".toUpperCase();
        instance.setEmail_alternativo(expResult);
        String result = instance.getEmail_alternativo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail_alternativo method, of class pensionado.
     */
    @Test
    public void testSetEmail_alternativo() {
        System.out.println("setEmail_alternativo");
        String email_alternativo = "";
        pensionado instance = new pensionado();
        instance.setEmail_alternativo(email_alternativo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEmail_pensionado method, of class pensionado.
     */
    @Test
    public void testGetEmail_pensionado() {
        System.out.println("getEmail_pensionado");
        pensionado instance = new pensionado();
        String expResult = "test".toUpperCase();
        instance.setEmail_pensionado(expResult);
        String result = instance.getEmail_pensionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail_pensionado method, of class pensionado.
     */
    @Test
    public void testSetEmail_pensionado() {
        System.out.println("setEmail_pensionado");
        String email_pensionado = "";
        pensionado instance = new pensionado();
        instance.setEmail_pensionado(email_pensionado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMedicamentos method, of class pensionado.
     */
    @Test
    public void testGetMedicamentos() {
        System.out.println("getMedicamentos");
        pensionado instance = new pensionado();
        medicamento instance2 = new medicamento();
        instance2.setId(new Long("1"));
        medicamento expResult = instance2;
        instance.setMedicamentos(expResult);
        medicamento result = instance.getMedicamentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMedicamentos method, of class pensionado.
     */
    @Test
    public void testSetMedicamentos() {
        System.out.println("setMedicamentos");
        medicamento medicamentos = new medicamento();
        medicamentos.setId(Long.MIN_VALUE);
        pensionado instance = new pensionado();
        instance.setMedicamentos(medicamentos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPrestamos method, of class pensionado.
     */
    @Test
    public void testGetPrestamos() {
        System.out.println("getPrestamos");
        pensionado instance = new pensionado();
        prestamo expResult = new prestamo();
        expResult.setId(Long.MIN_VALUE);
        instance.setPrestamos(expResult);
        prestamo result = instance.getPrestamos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPrestamos method, of class pensionado.
     */
    @Test
    public void testSetPrestamos() {
        System.out.println("setPrestamos");
        prestamo prestamos = new prestamo();
        pensionado instance = new pensionado();
        instance.setPrestamos(prestamos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBeneficios method, of class pensionado.
     */
    @Test
    public void testGetBeneficios() {
        System.out.println("getBeneficios");
        pensionado instance = new pensionado();
        beneficio expResult = new beneficio();
        expResult.setId(Long.MIN_VALUE);
        instance.setBeneficios(expResult);
        beneficio result = instance.getBeneficios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setBeneficios method, of class pensionado.
     */
    @Test
    public void testSetBeneficios() {
        System.out.println("setBeneficios");
        beneficio beneficios = null;
        pensionado instance = new pensionado();
        instance.setBeneficios(beneficios);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSeguros method, of class pensionado.
     */

    /**
     * Test of getContactos method, of class pensionado.
     */
    @Test
    public void testGetContactos() {
        System.out.println("getContactos");
        pensionado instance = new pensionado();
        contacto expResult = new contacto();
        expResult.setId(Long.MIN_VALUE);
        instance.setContactos(expResult);
        contacto result = instance.getContactos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setContactos method, of class pensionado.
     */
    @Test
    public void testSetContactos() {
        System.out.println("setContactos");
        contacto contactos = new contacto();
        pensionado instance = new pensionado();
        instance.setContactos(contactos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getOtros_datos method, of class pensionado.
     */
    @Test
    public void testGetOtros_datos() {
        System.out.println("getOtros_datos");
        pensionado instance = new pensionado();
        otros_datos expResult = new otros_datos();
        instance.setOtros_datos(expResult);
        otros_datos result = instance.getOtros_datos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setOtros_datos method, of class pensionado.
     */
    @Test
    public void testSetOtros_datos() {
        System.out.println("setOtros_datos");
        otros_datos otros_datos = new otros_datos();
        pensionado instance = new pensionado();
        instance.setOtros_datos(otros_datos);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPatologias method, of class pensionado.
     */
    @Test
    public void testGetPatologias() {
        System.out.println("getPatologias");
        pensionado instance = new pensionado();
        patologia expResult = new patologia();
        instance.setPatologias(expResult);
        patologia result = instance.getPatologias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPatologias method, of class pensionado.
     */
    @Test
    public void testSetPatologias() {
        System.out.println("setPatologias");
        patologia patologias = new patologia();
        pensionado instance = new pensionado();
        instance.setPatologias(patologias);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRut_pensionado method, of class pensionado.
     */
    @Test
    public void testGetRut_pensionado() {
        System.out.println("getRut_pensionado");
        pensionado instance = new pensionado();
        String expResult = "test";
        instance.setRut_pensionado(expResult);
        String result = instance.getRut_pensionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRut_pensionado method, of class pensionado.
     */
    @Test
    public void testSetRut_pensionado() {
        System.out.println("setRut_pensionado");
        String rut_pensionado = "test";
        pensionado instance = new pensionado();
        instance.setRut_pensionado(rut_pensionado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre_pensionado method, of class pensionado.
     */
    @Test
    public void testGetNombre_pensionado() {
        System.out.println("getNombre_pensionado");
        pensionado instance = new pensionado();
        String expResult = "test".toUpperCase();
        instance.setNombre_pensionado(expResult);
        String result = instance.getNombre_pensionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_pensionado method, of class pensionado.
     */
    @Test
    public void testSetNombre_pensionado() {
        System.out.println("setNombre_pensionado");
        String nombre_pensionado = "sad";
        pensionado instance = new pensionado();
        instance.setNombre_pensionado(nombre_pensionado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getApellido_p_pensionado method, of class pensionado.
     */
    @Test
    public void testGetApellido_p_pensionado() {
        System.out.println("getApellido_p_pensionado");
        pensionado instance = new pensionado();
        String expResult = "test".toUpperCase();
        instance.setApellido_p_pensionado(expResult);
        String result = instance.getApellido_p_pensionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setApellido_p_pensionado method, of class pensionado.
     */
    @Test
    public void testSetApellido_p_pensionado() {
        System.out.println("setApellido_p_pensionado");
        String apellido_p_pensionado = "asd";
        pensionado instance = new pensionado();
        instance.setApellido_p_pensionado(apellido_p_pensionado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getApellido_m_pensionado method, of class pensionado.
     */
    @Test
    public void testGetApellido_m_pensionado() {
        System.out.println("getApellido_m_pensionado");
        pensionado instance = new pensionado();
        String expResult = "asd".toUpperCase();
        instance.setApellido_m_pensionado(expResult);
        String result = instance.getApellido_m_pensionado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setApellido_m_pensionado method, of class pensionado.
     */
    @Test
    public void testSetApellido_m_pensionado() {
        System.out.println("setApellido_m_pensionado");
        String apellido_m_pensionado = "asd";
        pensionado instance = new pensionado();
        instance.setApellido_m_pensionado(apellido_m_pensionado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFecha_nacimiento method, of class pensionado.
     */
    @Test
    public void testGetFecha_nacimiento() {
        System.out.println("getFecha_nacimiento");
        pensionado instance = new pensionado();
        String expResult = "asd";
        instance.setFecha_nacimiento(expResult);
        String result = instance.getFecha_nacimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFecha_nacimiento method, of class pensionado.
     */
    @Test
    public void testSetFecha_nacimiento() {
        System.out.println("setFecha_nacimiento");
        String fecha_nacimiento = "asd";
        pensionado instance = new pensionado();
        instance.setFecha_nacimiento(fecha_nacimiento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEstado_civil method, of class pensionado.
     */
    @Test
    public void testGetEstado_civil() {
        System.out.println("getEstado_civil");
        pensionado instance = new pensionado();
        String expResult = "asd".toUpperCase();
        instance.setEstado_civil(expResult);
        String result = instance.getEstado_civil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEstado_civil method, of class pensionado.
     */
    @Test
    public void testSetEstado_civil() {
        System.out.println("setEstado_civil");
        String estado_civil = "asd";
        pensionado instance = new pensionado();
        instance.setEstado_civil(estado_civil);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDireccion method, of class pensionado.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        pensionado instance = new pensionado();
        String expResult = "asdsad".toUpperCase();
        instance.setDireccion(expResult);
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setDireccion method, of class pensionado.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "asd";
        pensionado instance = new pensionado();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getComuna method, of class pensionado.
     */
    @Test
    public void testGetComuna() {
        System.out.println("getComuna");
        pensionado instance = new pensionado();
        String expResult = "asdsd".toUpperCase();
        instance.setComuna(expResult);
        String result = instance.getComuna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setComuna method, of class pensionado.
     */
    @Test
    public void testSetComuna() {
        System.out.println("setComuna");
        String comuna = "asdsd";
        pensionado instance = new pensionado();
        instance.setComuna(comuna);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRegion method, of class pensionado.
     */
    @Test
    public void testGetRegion() {
        System.out.println("getRegion");
        pensionado instance = new pensionado();
        String expResult = "asdsd".toUpperCase();
        instance.setRegion(expResult);
        String result = instance.getRegion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRegion method, of class pensionado.
     */
    @Test
    public void testSetRegion() {
        System.out.println("setRegion");
        String region = "asdsd";
        pensionado instance = new pensionado();
        instance.setRegion(region);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTelefono_fijo method, of class pensionado.
     */
    @Test
    public void testGetTelefono_fijo() {
        System.out.println("getTelefono_fijo");
        pensionado instance = new pensionado();
        Long expResult = new Long("1234789");
        instance.setTelefono_fijo(expResult);
        Long result = instance.getTelefono_fijo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTelefono_fijo method, of class pensionado.
     */
    @Test
    public void testSetTelefono_fijo() {
        System.out.println("setTelefono_fijo");
        Long telefono_fijo = new Long("1234567890");
        pensionado instance = new pensionado();
        instance.setTelefono_fijo(telefono_fijo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCelular method, of class pensionado.
     */
    @Test
    public void testGetCelular() {
        System.out.println("getCelular");
        pensionado instance = new pensionado();
        Long expResult = new Long("1234567890");
        instance.setCelular(expResult);
        Long result = instance.getCelular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCelular method, of class pensionado.
     */
    @Test
    public void testSetCelular() {
        System.out.println("setCelular");
        Long celular = new Long("1234567890");
        pensionado instance = new pensionado();
        instance.setCelular(celular);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class pensionado.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        pensionado instance = new pensionado();
        Long expResult = new Long("1234567890");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class pensionado.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("12347890");
        pensionado instance = new pensionado();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class pensionado.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        pensionado instance = new pensionado();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class pensionado.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        pensionado instance = new pensionado();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class pensionado.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        pensionado instance = new pensionado();
        instance.setId(new Long("1"));
        String expResult = "entities.pensionado[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
