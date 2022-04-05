/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection.esercizi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class Utente {

    private int id;

    private String username;

    private final List<Ordine> storicoOrdini;

    /**
     *
     * @param id
     * @param username
     */
    public Utente(int id, String username) {
        this.id = id;
        this.username = username;
        this.storicoOrdini = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public List<Ordine> getStoricoOrdini() {
        return storicoOrdini;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utente other = (Utente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param ordine
     */
    public void calcolaOrdine(Ordine ordine) {
        ordine.calcolaCostoMerce();
        double peso = ordine.getPeso();
        int kg = (int) Math.round(peso / 1000);
        if (kg < 1) {
            ordine.setCostoSpedizione(2);
        } else {
            ordine.setCostoSpedizione(2 * kg);
        }
    }

}
