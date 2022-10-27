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
public class Catrina {

    private Cliente cliente;
    private List<Producto> productos;
    private Catrina datos;
   
    
    public Catrina deserializar(String json){
        Catrina catrina = new Catrina();
        try{
            catrina = new Gson().fromJson(json, Catrina.class);
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
     * @return the productos
     */
    public List<Producto> getProductos() {
       return productos;
        
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
        this.productos = producto;
    }
    
    /**
     * @return the datos
     */
    public Catrina getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Catrina datos) {
        this.datos = datos;
    }
    
}
