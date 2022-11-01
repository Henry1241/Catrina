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
 * @author enri0
 */
public class estadoCuenta {

    private String cuenta;
    private String clabe;
    private String moneda;
    private int mes = 11;
    private Cliente cliente;
    private List<Movimiento> movimientos;
    

    public estadoCuenta deserializar(String json) {
        estadoCuenta catrina = new estadoCuenta();
        try {
            catrina = new Gson().fromJson(json, estadoCuenta.class);
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return catrina;
    }

    public double sumaDep(List<Movimiento> listaDepo) {
        double totalDepo = 0;

        for (Movimiento m : listaDepo) {
            if (m.getTipo() == Tipo.DEPOSITO) {
                totalDepo += m.getCantidad();
            }

        }
        return totalDepo;
    }

    public double sumaRet(List<Movimiento> listaRet) {
        double totalRet = 0;

        for (Movimiento m : listaRet) {
            if (m.getTipo() == Tipo.RETIRO) {
                totalRet += m.getCantidad();
            }

        }
        return totalRet;
    }

    public double suma(Movimiento suma) {
        double resultado = sumaDep(movimientos) - sumaRet(movimientos);
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
