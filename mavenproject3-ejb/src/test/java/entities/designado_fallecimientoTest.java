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
public class designado_fallecimientoTest {
    
    public designado_fallecimientoTest() {
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
     * Test of getPensionados method, of class designado_fallecimiento.
     */
    @Test
    public void testGetPensionados() {
        System.out.println("getPensionados");
        designado_fallecimiento instance = new designado_fallecimiento();
        pensionado instance2 = new pensionado();
        instance2.setId(new Long("1"));
        pensionado expResult = instance2;
        instance.setPensionados(instance2);
        pensionado result = instance.getPensionados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setPensionados method, of class designado_fallecimiento.
     */
    @Test
    public void testSetPensionados() {
        System.out.println("setPensionados");
        pensionado pensionados = new pensionado();
        pensionados.setId(new Long("1"));
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setPensionados(pensionados);
        assertEquals(pensionados, instance.getPensionados());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testGetNombre_designado() {
        System.out.println("getNombre_designado");
        designado_fallecimiento instance = new designado_fallecimiento();
        String expResult = "test";
        instance.setNombre_designado(expResult);
        String result = instance.getNombre_designado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testSetNombre_designado() {
        System.out.println("setNombre_designado");
        String nombre_designado = "test";
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setNombre_designado(nombre_designado);
        assertEquals(nombre_designado, instance.getNombre_designado());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getApellido_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testGetApellido_designado() {
        System.out.println("getApellido_designado");
        designado_fallecimiento instance = new designado_fallecimiento();
        String expResult = "test";
        instance.setApellido_designado(expResult);
        String result = instance.getApellido_designado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setApellido_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testSetApellido_designado() {
        System.out.println("setApellido_designado");
        String apellido_designado = "test";
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setApellido_designado(apellido_designado);
        assertEquals(apellido_designado, instance.getApellido_designado());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRut_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testGetRut_designado() {
        System.out.println("getRut_designado");
        designado_fallecimiento instance = new designado_fallecimiento();
        Long expResult = new Long("1234567890");
        instance.setRut_designado(expResult);
        Long result = instance.getRut_designado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRut_designado method, of class designado_fallecimiento.
     */
    @Test
    public void testSetRut_designado() {
        System.out.println("setRut_designado");
        Long rut_designado = new Long("1234567890");
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setRut_designado(rut_designado);
        assertEquals(rut_designado, instance.getRut_designado());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getParentesco method, of class designado_fallecimiento.
     */
    @Test
    public void testGetParentesco() {
        System.out.println("getParentesco");
        designado_fallecimiento instance = new designado_fallecimiento();
        String expResult = "test";
        instance.setParentesco(expResult);
        String result = instance.getParentesco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setParentesco method, of class designado_fallecimiento.
     */
    @Test
    public void testSetParentesco() {
        System.out.println("setParentesco");
        String parentesco = "test";
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setParentesco(parentesco);
        assertEquals(parentesco, instance.getParentesco());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTelefono method, of class designado_fallecimiento.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        designado_fallecimiento instance = new designado_fallecimiento();
        Long expResult = new Long("1234567890");
        instance.setTelefono(expResult);
        Long result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTelefono method, of class designado_fallecimiento.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        Long telefono = new Long("1234567890");
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setTelefono(telefono);
        assertEquals(instance.getTelefono(), telefono);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class designado_fallecimiento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        designado_fallecimiento instance = new designado_fallecimiento();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class designado_fallecimiento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1");
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setId(id);
        assertEquals(instance.getId(), id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class designado_fallecimiento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        designado_fallecimiento instance = new designado_fallecimiento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class designado_fallecimiento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        designado_fallecimiento instance = new designado_fallecimiento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class designado_fallecimiento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        designado_fallecimiento instance = new designado_fallecimiento();
        instance.setId(new Long("1"));
        String expResult = "entities.designado_fallecimiento[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
