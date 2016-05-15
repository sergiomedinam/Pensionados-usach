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
public class contactoTest {
    
    public contactoTest() {
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
     * Test of getNombre_contacto method, of class contacto.
     */
    @Test
    public void testGetNombre_contacto() {
        System.out.println("getNombre_contacto");
        contacto instance = new contacto();
        instance.setNombre_contacto("alfredo");
        String expResult = "alfredo";
        String result = instance.getNombre_contacto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre_contacto method, of class contacto.
     */
    @Test
    public void testSetNombre_contacto() {
        System.out.println("setNombre_contacto");
        String nombre_contacto = "";
        contacto instance = new contacto();
        instance.setNombre_contacto(nombre_contacto);        
        assertEquals(nombre_contacto, instance.getNombre_contacto());
    }

    /**
     * Test of getApellido_contacto method, of class contacto.
     */
    @Test
    public void testGetApellido_contacto() {
        System.out.println("getApellido_contacto");
        contacto instance = new contacto();
        instance.setApellido_contacto("test");
        String expResult = "test";
        String result = instance.getApellido_contacto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setApellido_contacto method, of class contacto.
     */
    @Test
    public void testSetApellido_contacto() {
        System.out.println("setApellido_contacto");
        String apellido_contacto = "test";
        contacto instance = new contacto();
        instance.setApellido_contacto(apellido_contacto);
        assertEquals(apellido_contacto, instance.getApellido_contacto());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getParentesco method, of class contacto.
     */
    @Test
    public void testGetParentesco() {
        System.out.println("getParentesco");
        contacto instance = new contacto();
        instance.setParentesco("test");
        String expResult = "test";
        String result = instance.getParentesco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setParentesco method, of class contacto.
     */
    @Test
    public void testSetParentesco() {
        System.out.println("setParentesco");
        String parentesco = "test";
        contacto instance = new contacto();
        instance.setParentesco(parentesco);
        assertEquals(parentesco, instance.getParentesco());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTelefono_contacto method, of class contacto.
     */
    @Test
    public void testGetTelefono_contacto() {
        System.out.println("getTelefono_contacto");
        contacto instance = new contacto();
        Long expResult = new Long("1234567890");
        instance.setTelefono_contacto(expResult);
        Long result = instance.getTelefono_contacto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTelefono_contacto method, of class contacto.
     */
    @Test
    public void testSetTelefono_contacto() {
        System.out.println("setTelefono_contacto");
        Long telefono_contacto = new Long("1234567890");
        contacto instance = new contacto();
        instance.setTelefono_contacto(telefono_contacto);
        assertEquals(telefono_contacto, instance.getTelefono_contacto());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class contacto.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        contacto instance = new contacto();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class contacto.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("123");
        contacto instance = new contacto();
        instance.setId(id);
        assertEquals(id, instance.getId());        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class contacto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        contacto instance = new contacto();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class contacto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        contacto instance = new contacto();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class contacto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        contacto instance = new contacto();
        instance.setId(new Long("1"));
        String expResult = "entities.contacto[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
