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
public class otros_datosTest {
    
    public otros_datosTest() {
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
     * Test of getSistema_salud method, of class otros_datos.
     */
    @Test
    public void testGetSistema_salud() {
        System.out.println("getSistema_salud");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setSistema_salud(expResult);
        String result = instance.getSistema_salud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setSistema_salud method, of class otros_datos.
     */
    @Test
    public void testSetSistema_salud() {
        System.out.println("setSistema_salud");
        String sistema_salud = "test";
        otros_datos instance = new otros_datos();
        instance.setSistema_salud(sistema_salud);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTipo_pension method, of class otros_datos.
     */
    @Test
    public void testGetTipo_pension() {
        System.out.println("getTipo_pension");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setTipo_pension(expResult);
        String result = instance.getTipo_pension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTipo_pension method, of class otros_datos.
     */
    @Test
    public void testSetTipo_pension() {
        System.out.println("setTipo_pension");
        String tipo_pension = "";
        otros_datos instance = new otros_datos();
        instance.setTipo_pension(tipo_pension);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSistema_pension method, of class otros_datos.
     */
    @Test
    public void testGetSistema_pension() {
        System.out.println("getSistema_pension");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setSistema_pension(expResult);
        String result = instance.getSistema_pension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.;
    }

    /**
     * Test of setSistema_pension method, of class otros_datos.
     */
    @Test
    public void testSetSistema_pension() {
        System.out.println("setSistema_pension");
        String sistema_pension = "";
        otros_datos instance = new otros_datos();
        instance.setSistema_pension(sistema_pension);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre_banco method, of class otros_datos.
     */
    @Test
    public void testGetNombre_banco() {
        System.out.println("getNombre_banco");
        otros_datos instance = new otros_datos();
        String expResult = "";
        instance.setNombre_banco(expResult);
        String result = instance.getNombre_banco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre_banco method, of class otros_datos.
     */
    @Test
    public void testSetNombre_banco() {
        System.out.println("setNombre_banco");
        String nombre_banco = "";
        otros_datos instance = new otros_datos();
        instance.setNombre_banco(nombre_banco);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCuenta_banco method, of class otros_datos.
     */
    @Test
    public void testGetCuenta_banco() {
        System.out.println("getCuenta_banco");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setCuenta_banco(expResult);
        String result = instance.getCuenta_banco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCuenta_banco method, of class otros_datos.
     */
    @Test
    public void testSetCuenta_banco() {
        System.out.println("setCuenta_banco");
        String cuenta_banco = "";
        otros_datos instance = new otros_datos();
        instance.setCuenta_banco(cuenta_banco);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEstamento method, of class otros_datos.
     */
    @Test
    public void testGetEstamento() {
        System.out.println("getEstamento");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setEstamento(expResult);
        String result = instance.getEstamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEstamento method, of class otros_datos.
     */
    @Test
    public void testSetEstamento() {
        System.out.println("setEstamento");
        String estamento = "";
        otros_datos instance = new otros_datos();
        instance.setEstamento(estamento);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getMonto_pension method, of class otros_datos.
     */
    @Test
    public void testGetMonto_pension() {
        System.out.println("getMonto_pension");
        otros_datos instance = new otros_datos();
        Integer expResult = 1;
        instance.setMonto_pension(expResult);
        Integer result = instance.getMonto_pension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setMonto_pension method, of class otros_datos.
     */
    @Test
    public void testSetMonto_pension() {
        System.out.println("setMonto_pension");
        Integer monto_pension = 1;
        otros_datos instance = new otros_datos();
        instance.setMonto_pension(monto_pension);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getValor_cuota method, of class otros_datos.
     */
    @Test
    public void testGetValor_cuota() {
        System.out.println("getValor_cuota");
        otros_datos instance = new otros_datos();
        Integer expResult = 1;
        instance.setValor_cuota(expResult);
        Integer result = instance.getValor_cuota();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setValor_cuota method, of class otros_datos.
     */
    @Test
    public void testSetValor_cuota() {
        System.out.println("setValor_cuota");
        Integer valor_cuota = 1;
        otros_datos instance = new otros_datos();
        instance.setValor_cuota(valor_cuota);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getUltimo_aporte method, of class otros_datos.
     */
    @Test
    public void testGetUltimo_aporte() {
        System.out.println("getUltimo_aporte");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setUltimo_aporte(expResult);
        String result = instance.getUltimo_aporte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setUltimo_aporte method, of class otros_datos.
     */
    @Test
    public void testSetUltimo_aporte() {
        System.out.println("setUltimo_aporte");
        String ultimo_aporte = "";
        otros_datos instance = new otros_datos();
        instance.setUltimo_aporte(ultimo_aporte);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCaja_compensacion method, of class otros_datos.
     */
    @Test
    public void testGetCaja_compensacion() {
        System.out.println("getCaja_compensacion");
        otros_datos instance = new otros_datos();
        String expResult = "test";
        instance.setCaja_compensacion(expResult);
        String result = instance.getCaja_compensacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCaja_compensacion method, of class otros_datos.
     */
    @Test
    public void testSetCaja_compensacion() {
        System.out.println("setCaja_compensacion");
        String caja_compensacion = "";
        otros_datos instance = new otros_datos();
        instance.setCaja_compensacion(caja_compensacion);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class otros_datos.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        otros_datos instance = new otros_datos();
        Long expResult = new Long("1234567890");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class otros_datos.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        otros_datos instance = new otros_datos();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hashCode method, of class otros_datos.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        otros_datos instance = new otros_datos();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of equals method, of class otros_datos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        otros_datos instance = new otros_datos();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class otros_datos.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        otros_datos instance = new otros_datos();
        instance.setId(new Long("1"));
        String expResult = "entities.otros_datos[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
