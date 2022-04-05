/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection.esercizi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class TestNegozio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creazione utenti
        Utente u1 = new Utente(1, "pippo");
        Utente u2 = new UtentePrime(2, "topolino");
        Set<Utente> utenti = new HashSet<>();
        utenti.add(u1);
        utenti.add(u2);
        // creazione magazzino
        Magazzino magazzino = new Magazzino();
        // creazione articoli e aggiunta al magazzino
        Articolo a1 = new Articolo(1, "computer", 900, 2500);
        Articolo a2 = new Articolo(2, "mouse", 20, 400);
        Articolo a3 = new Articolo(3, "tastiera", 30, 500);
        magazzino.add(a1, 10);
        magazzino.add(a2, 20);
        magazzino.add(a3, 15);
        //crea negozio
        Negozio negozio = new Negozio(magazzino, utenti);
        Map<Articolo, Integer> carrello1 = new HashMap<>();
        carrello1.put(a1, 1);
        carrello1.put(a2, 1);
        carrello1.put(a3, 1);
        try {
            double c = negozio.acquista(u1, carrello1);
            System.out.println("Grazie utente " + u1.getUsername() + ", " + c);
            c = negozio.acquista(u2, carrello1);
            System.out.println("Grazie utente " + u2.getUsername() + ", " + c);
        } catch (NegozioException ex) {
            System.err.println(ex);
        }
        Map<Articolo, Integer> carrello2 = new HashMap<>();
        carrello2.put(a2, 2);
        try {
            negozio.acquista(u2, carrello2);
        } catch (NegozioException ex) {
            System.err.println(ex);
        }
        //prova ricerca
        Set<Articolo> cerca = negozio.getMagazzino().cerca("comp");
        for (Articolo a : cerca) {
            System.out.println("Trovato articolo: " + a);
        }
        //prova ricerca storico ordini
        List<Ordine> ordini = negozio.cercaStoricoUtente(u2);
        for (Ordine o : ordini) {
            System.out.println("Trovato ordine: " + o);
        }
        //prova ricerca articolo minori di una certa quantità
        List<Articolo> l = negozio.getMagazzino().cercaQuantita(11);
        for (Articolo a : l) {
            System.out.println("Articolo: " + a);
        }
        // prova top vendite
        System.out.println("TOP VENDITE");
        List<HolderQuantity<Articolo>> topVendite = negozio.getTopVendite();
        for (HolderQuantity<Articolo> v:topVendite) {
            System.out.println(v.getItem()+": "+v.getQ());
        }

    }

}
