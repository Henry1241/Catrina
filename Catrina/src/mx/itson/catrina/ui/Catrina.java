/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import mx.itson.catrina.entidades.Movimiento;

/**
 *
 * @author enri0
 */
public class Catrina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Movimiento> movimientos = new ArrayList<>();
        
        Movimiento movimiento1 = new Movimiento();
        movimiento1.setMonto(1500);
        movimiento1.setFecha(new GregorianCalendar(2022, Calendar.AUGUST, 2).getTime());
        movimientos.add(movimiento1);
        
        Movimiento movimiento2 = new Movimiento();
        movimiento2.setMonto(800);
        movimiento2.setFecha(new GregorianCalendar(2022, Calendar.JULY, 18).getTime());
        movimientos.add(movimiento2);
        
        Movimiento movimiento3 = new Movimiento();
        movimiento3.setMonto(1500);
        movimiento3.setFecha(new GregorianCalendar(2025, Calendar.APRIL, 4).getTime());
        movimientos.add(movimiento3);
        
        Movimiento movimiento4 = new Movimiento();
        movimiento4.setMonto(1500);
        movimiento4.setFecha(new GregorianCalendar(2022, Calendar.JANUARY, 21).getTime());
        movimientos.add(movimiento4);
        
        Movimiento movimiento5 = new Movimiento();
        movimiento5.setMonto(1500);
        movimiento5.setFecha(new GregorianCalendar(2022, Calendar.OCTOBER, 27).getTime());
        movimientos.add(movimiento5);
        
        DateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
        
        System.out.println("Lista desordenada");
        for(Movimiento m : movimientos){
            System.out.println(formatoFecha.format(m.getFecha()));
        }
        movimientos.sort((mov1, mov2) -> mov1.getFecha().compareTo(mov2.getFecha()));
        System.out.println("----------------------");
        System.out.println("Lista ordenada");
         for(Movimiento m : movimientos){
            System.out.println(formatoFecha.format(m.getFecha()));
         }
    }
    
}
