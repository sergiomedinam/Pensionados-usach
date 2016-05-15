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
        String expResult = "test";
        instance.setEmail_usuario(expResult);
        String result = instance.getEmail_usuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEmail_usuario method, of class usuario.
     */
    @Test
    public void testSetEmail_usuario() {
        System.out.println("setEmail_usuario");
        String email_usuario = "test";
        usuario instance = new usuario();
        instance.setEmail_usuario(email_usuario);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getTipo_usuario method, of class usuario.
     */
    @Test
    public void testGetTipo_usuario() {
        System.out.println("getTipo_usuario");
        usuario instance = new usuario();
        rol expResult = new rol();
        instance.setTipo_usuario(expResult);
        rol result = instance.getTipo_usuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setTipo_usuario method, of class usuario.
     */
    @Test
    public void testSetTipo_usuario() {
        System.out.println("setTipo_usuario");
        rol tipo_usuario = new rol();
        usuario instance = new usuario();
        instance.setTipo_usuario(tipo_usuario);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombre method, of class usuario.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        usuario instance = new usuario();
        String expResult = "test";
        instance.setNombre(expResult);
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNombre method, of class usuario.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "test";
        usuario instance = new usuario();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getApellido method, of class usuario.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        usuario instance = new usuario();
        String expResult = "test";
        instance.setApellido(expResult);
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setApellido method, of class usuario.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "test";
        usuario instance = new usuario();
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRut method, of class usuario.
     */
    @Test
    public void testGetRut() {
        System.out.println("getRut");
        usuario instance = new usuario();
        String expResult = "123456789";
        instance.setRut(expResult);
        String result = instance.getRut();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setRut method, of class usuario.
     */
    @Test
    public void testSetRut() {
        System.out.println("setRut");
        String rut = "123456789";
        usuario instance = new usuario();
        instance.setRut(rut);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getContrasena method, of class usuario.
     */
    @Test
    public void testGetContrasena() {
        System.out.println("getContrasena");
        usuario instance = new usuario();
        String expResult = "test";
        instance.setContrasena(expResult);
        String result = instance.getContrasena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setContrasena method, of class usuario.
     */
    @Test
    public void testSetContrasena() {
        System.out.println("setContrasena");
        String contrasena = "test";
        usuario instance = new usuario();
        instance.setContrasena(contrasena);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getId method, of class usuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        usuario instance = new usuario();
        Long expResult = new Long("1");
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setId method, of class usuario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = new Long("1");
        usuario instance = new usuario();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
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
    }

    /**
     * Test of toString method, of class usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        usuario instance = new usuario();
        instance.setId(new Long("1"));
        String expResult = "entities.usuario[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
