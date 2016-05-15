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
public class medicamentoTest {
    
    public medicamentoTest() {
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
     * Test of getNombre_medicamento method, of class medicamento.
     */
    @Test
    public void testGetNombre_medicamento() {
        System.out.println("getNombre_medicamento");
        medicamento instance = new medicamento();
        String expResult = "test";
        instance.setNombre_medicamento(expResult);
        String result = instance.getNombre_medicamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_medicamento method, of class medicamento.
     */
    @Test
    public void testSetNombre_medicamento() {
        System.out.println("setNombre_medicamento");
        String nombre_medicamento = "test";
        medicamento instance = new medicamento();
        instance.setNombre_medicamento(nombre_medicamento);
        assertEquals(instance.getNombre_medicamento(), nombre_medicamento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class medicamento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        medicamento instance = new medicamento();
        Long expResult = new Long("2345");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class medicamento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1234567890");
        medicamento instance = new medicamento();
        instance.setId(id);
        assertEquals(id, instance.getId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class medicamento.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        medicamento instance = new medicamento();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class medicamento.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        medicamento instance = new medicamento();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class medicamento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        medicamento instance = new medicamento();
        instance.setId(new Long("1"));
        String expResult = "entities.medicamento[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
