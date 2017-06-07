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
public class Pago {
    

    Boolean tipo ; // tipo = 1(efectivo) tipo=0(tarjeta de credito)
    String numeroTarjeta;
    
    public Pago(){}
    
    public void crear_pago(Boolean tipo, String tarjeta){
     this.tipo = tipo;
     this.numeroTarjeta = tarjeta;
    }
    
    public int validar_pago(Pago p){
        if (p.getTipo().equals(1)){
            System.out.println("Pago en efectivo");
            return 1;
        }
        else{
            if(p.validar_tarjeta()==1){
                System.out.println("Pago con tarjeta");
                return 1;
            }
            else
            {
             return 0;   
            }
        }   
    }
 
    public int validar_tarjeta(){  
      if (this.numeroTarjeta.matches("[0-9]*"))
          return 1;
      return 0;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    
}
