/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection.esercizi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class Magazzino {

    private final Map<Articolo, Integer> map;

    /**
     *
     */
    public Magazzino() {
        map = new HashMap<>();
    }

    /**
     *
     * @param articolo
     * @param quantita
     */
    public void add(Articolo articolo, int quantita) {
        Integer q = map.get(articolo);
        if (q == null) {
            map.put(articolo, quantita);
        } else {
            map.put(articolo, q + quantita);
        }
    }

    /**
     *
     * @param articolo
     * @param quantita
     * @throws NegozioException
     */
    public void remove(Articolo articolo, int quantita) throws NegozioException {
        Integer q = map.get(articolo);
        if (q == null || q < quantita) {
            throw new NegozioException("Quantità non disponibile");
        } else {
            map.put(articolo, q - quantita);
        }
    }

    /**
     *
     * @param articolo
     * @param quantita
     * @return
     */
    public boolean disponibile(Articolo articolo, int quantita) {
        Integer q = map.get(articolo);
        if (q == null || q < quantita) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public Set<Articolo> cerca(String key) {
        Set<Articolo> risultati = new HashSet<>();
        for (Articolo articolo : map.keySet()) {
            if (articolo.getDesc().contains(key)) {
                risultati.add(articolo);
            }
        }
        return risultati;
    }

    /**
     *
     * @param q
     * @return
     */
    public List<Articolo> cercaQuantita(int q) {
        List<Articolo> list = new ArrayList<>();
        for (Map.Entry<Articolo, Integer> e : map.entrySet()) {
            if (e.getValue() < q) {
                list.add(e.getKey());
            }
        }
        return list;
    }

}
