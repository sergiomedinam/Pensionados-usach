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
public class patologiaTest {
    
    public patologiaTest() {
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
     * Test of getNombre_patologia method, of class patologia.
     */
    @Test
    public void testGetNombre_patologia() {
        System.out.println("getNombre_patologia");
        patologia instance = new patologia();
        String expResult = "";
        String result = instance.getNombre_patologia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre_patologia method, of class patologia.
     */
    @Test
    public void testSetNombre_patologia() {
        System.out.println("setNombre_patologia");
        String nombre_patologia = "";
        patologia instance = new patologia();
        instance.setNombre_patologia(nombre_patologia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class patologia.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        patologia instance = new patologia();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class patologia.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        patologia instance = new patologia();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class patologia.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        patologia instance = new patologia();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class patologia.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        patologia instance = new patologia();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class patologia.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        patologia instance = new patologia();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
