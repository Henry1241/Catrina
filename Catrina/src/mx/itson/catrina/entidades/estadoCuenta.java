/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;
import mx.itson.catrina.enumeradores.Tipo;

/**
 *
 * @author Enrique Gonzalez
 */
public class EstadoCuenta {

    private String cuenta;
    private String clabe;
    private String moneda;
    private int mes;
    private Cliente cliente;
    private List<Movimiento> movimientos;
    
/**
 * El metodo se encarga de deserealizar los datos del Json para obtenerlos y usarlos.
 * @param json
 * @return Regresa datos declarados en la clase EstadoCuenta.
 */
    public EstadoCuenta deserializar(String json) {
        EstadoCuenta estadoC = new EstadoCuenta();
        try {
            estadoC = new Gson().fromJson(json, EstadoCuenta.class);
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return estadoC;
    }
/**
 * Este metodo suma todos los valores de tipo Deposito.
 * @param listaDepo
 * @return Regresa la suma de los depositos.
 */
    public double sumaDep(List<Movimiento> listaDepo) {
        double totalDepo = 0;

        for (Movimiento m : listaDepo) {
            if (m.getTipo() == Tipo.DEPOSITO) {
                totalDepo += m.getCantidad();
            }

        }
        return totalDepo;
    }
/**
 * Este metodo se encarfa de sumar todos los valores de tipo Retiro.
 * @param listaRet
 * @return Regresa el total de los retiros.
 */
    public double sumaRet(List<Movimiento> listaRet) {
        double totalRet = 0;

        for (Movimiento m : listaRet) {
            if (m.getTipo() == Tipo.RETIRO) {
                totalRet += m.getCantidad();
            }

        }
        return totalRet;
    }
/**
 * El metodo se encarga de restar el total de los depositos y el total de los retiros para obtener el subTotal.
 * @param resultado
 * @return 
 */
    public double suma(double resultado) {
        double suma = sumaDep(movimientos) - sumaRet(movimientos);
        return resultado;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param boxMes the boxMes to set
     */
    public void setMes(int boxMes) {
        this.mes = boxMes;
    }
    
    public double saldoInicial(int mes) {
         
        double saldoInicial = 0;
        for (Movimiento m : this.movimientos) {
            
            for (int i = 0; i < mes; i++) {
                if (m.getFecha().getMonth() == i && m.getTipo() == Tipo.DEPOSITO) {
                    saldoInicial += m.getCantidad();
                } else if (m.getFecha().getMonth() == i && m.getTipo() == Tipo.RETIRO) {
                    saldoInicial -= m.getCantidad();
                }
            }
        }

        return saldoInicial;
        
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

}
