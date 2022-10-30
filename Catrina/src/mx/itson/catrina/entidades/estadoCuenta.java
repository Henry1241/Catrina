/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;
import mx.itson.catrina.enumeradores.Tipo;
import static mx.itson.catrina.enumeradores.Tipo.DEPOSITO;

/**
 *
 * @author enri0
 */
public class estadoCuenta {

    private String cuenta;
    private String clabe;
    private String moneda;
    private String mes;
    private Cliente cliente;
    private List<Movimiento> movimientos;
   
    
    public estadoCuenta deserializar(String json){
        estadoCuenta catrina = new estadoCuenta();
        try{
            catrina = new Gson().fromJson(json, estadoCuenta.class);
        }catch(Exception ex){
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return catrina;
    }
        public double suma(List<Movimiento> listaMovimientos){
            double resultado = 0;
            
            for(Movimiento m : listaMovimientos){
                    switch(m.getTipo()){
                        case DEPOSITO -> resultado += m.getCantidad();
                        case RETIRO -> resultado -= m.getCantidad();
                        default -> throw new AssertionError();
                    }
                }
        return resultado;
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
    public List<Movimiento> getMovimientos() {
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
    public void setEstado(List<Movimiento> producto) {
        this.movimientos = producto;
    }
    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the clabe
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * @param clabe the clabe to set
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    /**
     * @return the Mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param combMes the combMes to set
     */
    public void setMes(String combMes) {
        this.mes = combMes;
    }
            
    public void Mes(){
        
        switch  (mes) {
            
            case "Enero":
                setMes("1");
                break;          
                
                case "Febrero":
                setMes("2");
                break;
                
                case "Marzo":
                setMes("3");
                break;
                
                case "Abril":
                setMes("4");
                break;
                
                case "Mayo":
                setMes("5");
                break;
                
                case "Junio":
                setMes("6");
                break;
                
                case "Julio":
                setMes("7");
                break;
                
                case "Agosto":
                setMes("8");
                break;
                
                case "Septiembre":
                setMes("9");
                break;
                
                case "Octubre":
                setMes("10");
                break;
                
                case "Noviembre":
                setMes("11");
                break;
                
                case "Diciembre":
                setMes("12");
                break;
        }
    }
}
