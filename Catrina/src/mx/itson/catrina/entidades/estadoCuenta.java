/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author enri0
 */
public class estadoCuenta {

    private Cliente cliente;
    private List<Producto> movimientos;
   
    
    public estadoCuenta deserializar(String json){
        estadoCuenta catrina = new estadoCuenta();
        try{
            catrina = new Gson().fromJson(json, estadoCuenta.class);
        }catch(Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return catrina;
}
   
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @return the movimientos
     */
    public List<Producto> getMovimientos() {
       return movimientos;
        
    }

    /**
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @param producto
     */
    public void setEstado(List<Producto> producto) {
        this.movimientos = producto;
    }
    
}
