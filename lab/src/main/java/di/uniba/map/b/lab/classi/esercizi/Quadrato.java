/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.classi.esercizi;

/**
 *
 * @author pierpaolo
 */
public class Quadrato extends Rettangolo {

    /**
     *
     * @param lato
     */
    public Quadrato(double lato) {
        super(lato, lato);
    }

    /**
     *
     * @return
     */
    public String toString() {
        return "Quadrato di lato " + dim1;
    }

}
