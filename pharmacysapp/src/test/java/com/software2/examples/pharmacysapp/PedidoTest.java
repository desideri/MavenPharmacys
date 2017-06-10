/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;
import com.software2.examples.pharmacysapp.Producto;
import com.software2.examples.pharmacysapp.DetallePedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private static ArrayList<DetallePedido> carrito;
    
    public static void initCatalogo() {
        
       
        catalogo = new ArrayList<Producto>();
        carrito = new ArrayList<DetallePedido>();
        
        Producto producto1 = new Producto("Dicloflenaco","Medicina",4,1,10.5);
        Producto producto2 = new Producto("Buscapina","Medicina",20,5,5.6);
        Producto producto3 = new Producto("Analgan","Medicina",10,2,2.50);
        Producto producto4 = new Producto("Redoxon","Medicina",30,5,7.80);
        
        catalogo.add(producto1);
        catalogo.add(producto2);
        catalogo.add(producto3);
        catalogo.add(producto4);
    }
    
    
    public Producto obtener_producto_catalogo(ArrayList<Producto> productos, String clave){
        Producto encontrado = null;
        
        for (Producto producto : productos) {
             if(producto.getNombre().equals(clave))
                 encontrado = producto;
            }
        return encontrado;
    
    }
    
    @Before
    public void beforeEachTest() {
        initCatalogo();
    }

    @After
    public void afterEachTest() {
      
    }

   

    @Test  
    public void testIntegracion_catalogo_carrito() {
        //Calendar calendario = Calendar.getInstance();
        //int HoradeHoy;
        //HoradeHoy = calendario.get(Calendar.HOUR_OF_DAY);
        System.out.println("\n \n");        
        //simulo que selecciono un producto del catalogo (Producto = Redoxon) y lo agrego al carrito 
        Producto p = obtener_producto_catalogo(catalogo,"Redoxon");
        DetallePedido detalle1 = new DetallePedido(p,5);
        carrito.add(detalle1);
        //visualizar el pedido con los productos seleccionados.
        System.out.println("*******Carrito*****");
        System.out.println(carrito.toString());
            
        assertEquals(1, carrito.size()); //experado,obtenido
    }
    
    
    @Test  
    public void testIntegracion_PedidoTotal() {
        Date Hora = new Date();
        Producto p1 = obtener_producto_catalogo(catalogo,"Analgan");
        Producto p2 = obtener_producto_catalogo(catalogo,"Buscapina");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
          
        Pago pago=new Pago();
        pago.crear_pago(Boolean.TRUE,"");
        Pedido pe = new Pedido(carrito,Hora,1,pago);
        System.out.println("*******Total del pedido*****");
        System.out.println((pe.pedido).toString());
        System.out.println("Usted debe pagar un total de: " + pe.TotalPedido());
        assertEquals("Se completo su pedido", pe.ToStringTotal());
      
    }
    @Test  
    public void testIntegracion_PedidoInHour() {
        Date Hora = new Date();
        Producto p1 = obtener_producto_catalogo(catalogo,"Analgan");
        Producto p2 = obtener_producto_catalogo(catalogo,"Buscapina");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
          
        Pago pago=new Pago();
        pago.crear_pago(Boolean.TRUE,"");
        Pedido pe = new Pedido(carrito,Hora,1,pago);
        
        System.out.println("*******Dentro de Horario Disponible*****");
        System.out.println((pe.pedido).toString());
        System.out.println(pe.ValidHora());
        System.out.println("Usted debe pagar un total de: " + pe.TotalPedido());
        System.out.println("Su pedido será enviado al sector " +pe.GetSector());
        assertEquals("Se completo su pedido", pe.ToStringTotal());
      
    }
    
    
     //Caso de prueba Valido
    @Test
    public void testIntegracion_producto_catalogo() {
        System.out.println("\n \n"); 
        System.out.println("(INICIAL) El catálogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString());
        Producto producto5 = new Producto("Ciprofloxacina","Medicina",50,15,11.42);
        String resultado = producto5.crear_producto();
        catalogo.add(producto5);
        System.out.println("(FIN) El catálogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString()); 
        
        assertEquals("Se creo el producto exitosamente!", resultado); //experado,obtenido
    }

}
