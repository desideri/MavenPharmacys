/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;
import com.software2.examples.pharmacysapp.Producto;
//import com.software2.examples.pharmacysapp.Calculator;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Stephany
 */
public class PedidoTest {
    
    private static ArrayList<Producto> catalogo;
    
    public static void initCatalogo() {
        
        catalogo = new ArrayList<Producto>();
        
//        Producto producto1 = new Producto("Dicloflenaco","Medicina",4,1);
//        Producto producto2 = new Producto("Buscapina","Medicina",20,5);
//        Producto producto3 = new Producto("Analgan","Medicina",10,2);
//        Producto producto4 = new Producto("Redoxon","Medicina",30,5);
//        
//        catalogo.add(producto1);
//        catalogo.add(producto2);
//        catalogo.add(producto3);
//        catalogo.add(producto4);
    }
    @Before
    public void beforeEachTest() {
//        System.out.println("El catalogo de la farmacia es:");
//        System.out.println(catalogo.toString());  
    }

    @After
    public void afterEachTest() {
//        System.out.println("El catalogo de la farmacia es:");
//        System.out.println(catalogo.toString()); 
    }

    //Caso de prueba Valido
    @Test
    public void testIntegracion_producto_catalogo() {
        
        Producto producto4 = new Producto("Redoxon","Medicina",30,5);
        
        String resultado = producto4.crear_producto();
        
        assertEquals("Se creo el producto exitosamente!", resultado); //experado,obtenido
    }
    //Caso de prueba Invalido
    @Test
    public void testIntegracion2_producto_catalogo() {
        
        Producto producto5 = new Producto("Mertiolate","Medicina",0,1);
       
        String resultado = producto5.crear_producto();

        assertEquals("No se pudo crear el producto.Verifique el stock ingresado.", resultado); //experado,obtenido
    }

}
