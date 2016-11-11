package javaapplication7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumne
 */
public class JUnitTest {
    
    public JUnitTest() {
    }
    
    @Test
    public void firstTest() {
        char[] esperado = {'_','_','_','_'};
        String palabra = "hola";
        char[] resultado = GameControlls.palabraOculta(palabra);
        Assert.assertArrayEquals(esperado, resultado);
    }
}
