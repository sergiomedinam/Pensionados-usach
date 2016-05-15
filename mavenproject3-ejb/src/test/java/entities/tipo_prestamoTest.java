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
public class tipo_prestamoTest {
    
    public tipo_prestamoTest() {
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
     * Test of getId method, of class tipo_prestamo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        tipo_prestamo instance = new tipo_prestamo();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre_t_prestamo method, of class tipo_prestamo.
     */
    @Test
    public void testGetNombre_t_prestamo() {
        System.out.println("getNombre_t_prestamo");
        tipo_prestamo instance = new tipo_prestamo();
        String expResult = "";
        String result = instance.getNombre_t_prestamo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre_t_prestamo method, of class tipo_prestamo.
     */
    @Test
    public void testSetNombre_t_prestamo() {
        System.out.println("setNombre_t_prestamo");
        String nombre_t_prestamo = "";
        tipo_prestamo instance = new tipo_prestamo();
        instance.setNombre_t_prestamo(nombre_t_prestamo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class tipo_prestamo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        tipo_prestamo instance = new tipo_prestamo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class tipo_prestamo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        tipo_prestamo instance = new tipo_prestamo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class tipo_prestamo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        tipo_prestamo instance = new tipo_prestamo();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class tipo_prestamo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        tipo_prestamo instance = new tipo_prestamo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
