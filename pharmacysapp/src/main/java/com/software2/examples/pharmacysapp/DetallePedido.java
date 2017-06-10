/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software2.examples.pharmacysapp;


/**
 *
 * @author Stephany
 */
public class DetallePedido {
   Producto p;
   int cantidad;
   double subtotal;

    public DetallePedido(Producto p, int cantidad) {
        this.p = p;
        this.cantidad = cantidad;
        this.subtotal=0;
    }
    
    
    public double SubtotalProductsos(DetallePedido D){
            return (D.p.precio)*(D.cantidad);
    }

    @Override
    public String toString() {
        subtotal= this.SubtotalProductsos(this);
        return "DetallePedido{" + "p=" + p + ", cantidad=" + cantidad +", subtotal= "+ subtotal + "}";
    }
    
    
      
}
