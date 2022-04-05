/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class EsercizioMap1File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources/sorgente.txt"));
            Map<String, Integer> map = new HashMap<>();
            while (in.ready()) {
                String line = in.readLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    Integer c = map.get(word);
                    if (c == null) {
                        map.put(word, 1);
                    } else {
                        map.put(word, c + 1);
                    }
                }
            }
            in.close();
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                System.out.println(e.getKey() + " --> " + e.getValue());
            }
        } catch (IOException ex) {
            System.err.println("Errore di I/O: " + ex.getMessage());
        }
    }

}
