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
public class rolTest {
    
    public rolTest() {
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
     * Test of getNombre_rol method, of class rol.
     */
    @Test
    public void testGetNombre_rol() {
        System.out.println("getNombre_rol");
        rol instance = new rol();
        String expResult = "asdsa";
        instance.setNombre_rol(expResult);
        String result = instance.getNombre_rol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_rol method, of class rol.
     */
    @Test
    public void testSetNombre_rol() {
        System.out.println("setNombre_rol");
        String nombre_rol = "asdsad";
        rol instance = new rol();
        instance.setNombre_rol(nombre_rol);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class rol.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        rol instance = new rol();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class rol.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1");
        rol instance = new rol();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class rol.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        rol instance = new rol();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class rol.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        rol instance = new rol();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class rol.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        rol instance = new rol();
        instance.setId(new Long("1"));
        String expResult = "entities.rol[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
