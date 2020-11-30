/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProclass;

import Events.Evento;

/**
 *
 * @author FERNAN
 */
public class Boda extends Evento {

    @Override
    public void mostrarPromociones() {
        System.out.println("Recuerde que los novios tendran un 25% de descuento si compran sus tickets de luna de miel en la arelinea LATAM.");
    }
}
