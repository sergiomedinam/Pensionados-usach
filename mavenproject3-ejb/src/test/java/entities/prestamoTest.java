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
public class prestamoTest {
    
    public prestamoTest() {
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
     * Test of getTipo_prestamo method, of class prestamo.
     */
    

    /**
     * Test of setTipo_prestamo method, of class prestamo.
  

    /**
     * Test of getNombre_prestamo method, of class prestamo.
     */
    @Test
    public void testGetNombre_prestamo() {
        System.out.println("getNombre_prestamo");
        prestamo instance = new prestamo();
        String expResult = "asdasd";
        instance.setNombre_prestamo(expResult);
        String result = instance.getNombre_prestamo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_prestamo method, of class prestamo.
     */
    @Test
    public void testSetNombre_prestamo() {
        System.out.println("setNombre_prestamo");
        String nombre_prestamo = "asdasd";
        prestamo instance = new prestamo();
        instance.setNombre_prestamo(nombre_prestamo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTotal_prestamo method, of class prestamo.
     */
    @Test
    public void testGetTotal_prestamo() {
        System.out.println("getTotal_prestamo");
        prestamo instance = new prestamo();
        String expResult = "asdas";
        instance.setTotal_prestamo(expResult);
        String result = instance.getTotal_prestamo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTotal_prestamo method, of class prestamo.
     */
    @Test
    public void testSetTotal_prestamo() {
        System.out.println("setTotal_prestamo");
        String total_prestamo = "asdsad";
        prestamo instance = new prestamo();
        instance.setTotal_prestamo(total_prestamo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCuotas_prestamo method, of class prestamo.
     */
    @Test
    public void testGetCuotas_prestamo() {
        System.out.println("getCuotas_prestamo");
        prestamo instance = new prestamo();
        int expResult = 1;
        instance.setCuotas_prestamo(expResult);
        int result = instance.getCuotas_prestamo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCuotas_prestamo method, of class prestamo.
     */
    @Test
    public void testSetCuotas_prestamo() {
        System.out.println("setCuotas_prestamo");
        int cuotas_prestamo = 1;
        prestamo instance = new prestamo();
        instance.setCuotas_prestamo(cuotas_prestamo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getInteres_prestamo method, of class prestamo.
     */
    @Test
    public void testGetInteres_prestamo() {
        System.out.println("getInteres_prestamo");
        prestamo instance = new prestamo();
        String expResult = "test";
        instance.setInteres_prestamo(expResult);
        String result = instance.getInteres_prestamo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setInteres_prestamo method, of class prestamo.
     */
    @Test
    public void testSetInteres_prestamo() {
        System.out.println("setInteres_prestamo");
        String interes_prestamo = "asdsad";
        prestamo instance = new prestamo();
        instance.setInteres_prestamo(interes_prestamo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class prestamo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        prestamo instance = new prestamo();
        Long expResult = new Long("123");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class prestamo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1");
        prestamo instance = new prestamo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class prestamo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        prestamo instance = new prestamo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class prestamo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        prestamo instance = new prestamo();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class prestamo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        prestamo instance = new prestamo();
        instance.setId(new Long("1"));
        String expResult = "entities.prestamo[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
