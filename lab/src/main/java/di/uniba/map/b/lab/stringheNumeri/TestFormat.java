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
package di.uniba.map.b.lab.stringheNumeri;

import java.util.Locale;

/**
 *
 * @author pierpaolo
 */
public class TestFormat {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        long n = 461012;
        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%08d%n", n);    //  -->  "00461012"
        System.out.format("%+8d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    // -->  " 461,012"
        System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
        double pi = Math.PI;
        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", -pi);  // -->  "3.142"
        System.out.format(Locale.US, "%-10.4f%n%n", pi); // -->  "3.1416"
        System.out.format(Locale.ITALIAN, "%-10.4f%n%n", pi); // -->  "3,1416"
    }
}
