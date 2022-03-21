/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.stringheNumeri.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pierpaolo
 */
public class MacherExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        System.out.println("=== Es. MATCHES ===");
        Matcher matcher1 = pattern.matcher("dlkflsASDaslsdSD");
        //deve corrispondere l'intera stringaMatcher matcher1 = pattern.matcher("dlkflsASDaslsdSD")
        System.out.println(matcher1.matches());
        System.out.println("=== Es. LOOKINGAT ===");
        Matcher matcher2 = pattern.matcher("dlkflsASDaslsdSD 8798767");
        //la corrispondenza deve partire dall'inizio ma non è necessario che corrisponda l'intera stringa
        System.out.println(matcher2.lookingAt());
        System.out.println("=== Es. FIND ===");
        Matcher matcher3 = pattern.matcher("34543 345   dlkflsASDaslsdSD ksdjfkdsEEGRT lfkgsDdsfds 4654654");
        while (matcher3.find()) {
            System.out.println(matcher3.group() + ": " + matcher3.start() + "-" + matcher3.end());
        }
        System.out.println("=== Es. FIND/GROUP ===");
        //una sequenza di numeri seguita da 1 o massimo 3 lettere minuscole
        String regexp = "([0-9]+)([a-z]{1,3})";
        Pattern pattern2 = Pattern.compile(regexp);
        String str = "9843989jf 39203920jie 32122i";
        Matcher matcher4 = pattern2.matcher(str);
        while (matcher4.find()) { //cicla sui match
            int gc = matcher4.groupCount(); //restituisce il numero di gruppi
            //il gruppo 0 corrisponde all'intero matching
            for (int i = 0; i <= gc; i++) {
                System.out.println(matcher4.group(i) + ": " + matcher4.start(i) + "-" + matcher4.end(i));
            }
            System.out.println();
        }
    }
    
}
