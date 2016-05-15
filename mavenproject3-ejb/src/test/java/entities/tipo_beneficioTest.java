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
public class tipo_beneficioTest {
    
    public tipo_beneficioTest() {
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
     * Test of getNombre_t_beneficio method, of class tipo_beneficio.
     */
    @Test
    public void testGetNombre_t_beneficio() {
        System.out.println("getNombre_t_beneficio");
        tipo_beneficio instance = new tipo_beneficio();
        String expResult = "assad";
        instance.setNombre_t_beneficio(expResult);
        String result = instance.getNombre_t_beneficio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_t_beneficio method, of class tipo_beneficio.
     */
    @Test
    public void testSetNombre_t_beneficio() {
        System.out.println("setNombre_t_beneficio");
        String nombre_t_beneficio = "asdsad";
        tipo_beneficio instance = new tipo_beneficio();
        instance.setNombre_t_beneficio(nombre_t_beneficio);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class tipo_beneficio.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        tipo_beneficio instance = new tipo_beneficio();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class tipo_beneficio.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1");
        tipo_beneficio instance = new tipo_beneficio();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class tipo_beneficio.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        tipo_beneficio instance = new tipo_beneficio();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class tipo_beneficio.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        tipo_beneficio instance = new tipo_beneficio();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class tipo_beneficio.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        tipo_beneficio instance = new tipo_beneficio();
        instance.setId(new Long("1"));
        String expResult = "entities.tipo_beneficio[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
