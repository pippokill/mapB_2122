/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.stringheNumeri;

/**
 *
 * @author pierpaolo
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 1) {
            double d1 = Double.parseDouble(args[0]);
            double d2 = Double.parseDouble(args[1]);
            double sum = d1 + d2;
            System.out.println(sum);
            double pow = Math.pow(d1, d2);
            System.out.println(pow);
            if (d1 < 100) {
                boolean c = d1 < Math.random() * 100;
                System.out.println(c);
            }
        }
    }

}
