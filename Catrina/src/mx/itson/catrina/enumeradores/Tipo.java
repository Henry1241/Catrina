/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.enumeradores;

import com.google.gson.annotations.SerializedName;

/**
 * El enmumerador se encarga de especificar si se trata de un deposito o un 
 * retiro usando un numero como identificador.
 * @author Enrique Gonzalez
 */
public enum Tipo {
    
    @SerializedName("1")
    DEPOSITO,
    @SerializedName("2")
    RETIRO
}
