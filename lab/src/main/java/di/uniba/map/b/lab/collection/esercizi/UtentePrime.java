/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection.esercizi;

/**
 *
 * @author pierpaolo
 */
public class UtentePrime extends Utente {

    /**
     *
     * @param id
     * @param username
     */
    public UtentePrime(int id, String username) {
        super(id, username);
    }
    
    /**
     *
     * @param ordine
     */
    public void calcolaOrdine(Ordine ordine) {
        ordine.calcolaCostoMerce();
        ordine.setCostoSpedizione(1);
    }
    
}
