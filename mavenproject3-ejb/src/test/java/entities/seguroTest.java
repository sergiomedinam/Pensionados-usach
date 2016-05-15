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
public class seguroTest {
    
    public seguroTest() {
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
     * Test of getNombre_seguro method, of class seguro.
     */
    @Test
    public void testGetNombre_seguro() {
        System.out.println("getNombre_seguro");
        seguro instance = new seguro();
        String expResult = "";
        String result = instance.getNombre_seguro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre_seguro method, of class seguro.
     */
    @Test
    public void testSetNombre_seguro() {
        System.out.println("setNombre_seguro");
        String nombre_seguro = "";
        seguro instance = new seguro();
        instance.setNombre_seguro(nombre_seguro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class seguro.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        seguro instance = new seguro();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class seguro.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        seguro instance = new seguro();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class seguro.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        seguro instance = new seguro();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class seguro.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        seguro instance = new seguro();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class seguro.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        seguro instance = new seguro();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
