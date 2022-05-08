/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.rete;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierpaolo
 */
public class TestSMT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            try {
                JabberClient.main(new String[0]);
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
