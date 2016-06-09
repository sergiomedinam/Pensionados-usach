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
public class beneficioTest {
    
    public beneficioTest() {
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
     * Test of getTipo_beneficio method, of class beneficio.
     */
   
    /**
     * Test of getNombre_beneficio method, of class beneficio.
     */
    @org.junit.Test
    public void testGetNombre_beneficio() {
        System.out.println("getNombre_beneficio");
        beneficio instance = new beneficio();
        String expResult = "test";
        instance.setNombre_beneficio(expResult);
        String result = instance.getNombre_beneficio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_beneficio method, of class beneficio.
     */
    @org.junit.Test
    public void testSetNombre_beneficio() {
        System.out.println("setNombre_beneficio");
        String nombre_beneficio = "test";
        beneficio instance = new beneficio();
        instance.setNombre_beneficio(nombre_beneficio);
        assertEquals(nombre_beneficio, instance.getNombre_beneficio());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class beneficio.
     */
    @org.junit.Test
    public void testGetId() {
        System.out.println("getId");
        beneficio instance = new beneficio();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class beneficio.
     */
    @org.junit.Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("123123");
        beneficio instance = new beneficio();
        instance.setId(id);
        assertEquals(id, instance.getId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class beneficio.
     */
    @org.junit.Test
    public void testHashCode() {
        System.out.println("hashCode");
        beneficio instance = new beneficio();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class beneficio.
     */
    @org.junit.Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        beneficio instance = new beneficio();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class beneficio.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        beneficio instance = new beneficio();
        instance.setId(new Long("1"));
        String expResult = "entities.beneficio[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
