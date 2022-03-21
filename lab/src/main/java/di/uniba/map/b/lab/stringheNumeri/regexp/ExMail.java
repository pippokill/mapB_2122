/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.stringheNumeri.regexp;

/**
 *
 * @author pierpaolo
 */
public class ExMail {
    
    /**
     *
     */
    public static String EXP_MAIL="[a-zA-Z][\\w]*[\\.]?[\\w]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length>0) {
            System.out.println(EXP_MAIL);
            System.out.println(args[0].matches(EXP_MAIL));
        }
    }
    
}
