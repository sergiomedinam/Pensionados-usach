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
public class usuarioTest {
    
    public usuarioTest() {
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
     * Test of getEmail_usuario method, of class usuario.
     */
    @Test
    public void testGetEmail_usuario() {
        System.out.println("getEmail_usuario");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getEmail_usuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail_usuario method, of class usuario.
     */
    @Test
    public void testSetEmail_usuario() {
        System.out.println("setEmail_usuario");
        String email_usuario = "";
        usuario instance = new usuario();
        instance.setEmail_usuario(email_usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo_usuario method, of class usuario.
     */
    @Test
    public void testGetTipo_usuario() {
        System.out.println("getTipo_usuario");
        usuario instance = new usuario();
        rol expResult = null;
        rol result = instance.getTipo_usuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo_usuario method, of class usuario.
     */
    @Test
    public void testSetTipo_usuario() {
        System.out.println("setTipo_usuario");
        rol tipo_usuario = null;
        usuario instance = new usuario();
        instance.setTipo_usuario(tipo_usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        usuario instance = new usuario();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class usuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class usuario.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        usuario instance = new usuario();
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRut method, of class usuario.
     */
    @Test
    public void testGetRut() {
        System.out.println("getRut");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getRut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRut method, of class usuario.
     */
    @Test
    public void testSetRut() {
        System.out.println("setRut");
        String rut = "";
        usuario instance = new usuario();
        instance.setRut(rut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrasena method, of class usuario.
     */
    @Test
    public void testGetContrasena() {
        System.out.println("getContrasena");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.getContrasena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrasena method, of class usuario.
     */
    @Test
    public void testSetContrasena() {
        System.out.println("setContrasena");
        String contrasena = "";
        usuario instance = new usuario();
        instance.setContrasena(contrasena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        usuario instance = new usuario();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        usuario instance = new usuario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        usuario instance = new usuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        usuario instance = new usuario();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        usuario instance = new usuario();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
