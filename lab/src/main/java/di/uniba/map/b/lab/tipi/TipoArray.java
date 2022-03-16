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
package di.uniba.map.b.lab.tipi;

import java.util.Arrays;

/**
 *
 * @author pierpaolo
 */
public class TipoArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a1 = new int[3];
        a1[0] = 32;
        a1[1] = 12;
        a1[2] = 2;
        System.out.println("Terzo elemento di a1: " + a1[2]);
        int[] a2 = new int[]{3, 32, 12, 54, 23, 43, 23, 21, 32, 43, 32};
        System.out.println("Quarto elemento di a2: " + a2[3]);
        int[][] a3 = new int[2][2];
        a3[1][0] = 42;
        System.out.println("Array a due dimenzioni, a3[1][0]=" + a3[1][0]);
        int[] a4 = new int[3];
        System.arraycopy(a2, 3, a4, 0, 3);
        System.out.println("Copia di array: " + a4[2]);
        Arrays.sort(a2);
        System.out.println("Ordinamento di array: " + a2[a2.length - 1]);
        int idx = Arrays.binarySearch(a2, 21);
        System.out.println("Ricerca binaria: indice " + idx + ", valore " + a2[idx]);
        String[] s = new String[]{"Topolino", "Pluto", "Pippo", "Paperino"};
        System.out.println("Array di stringhe: " + s[0]);
        Arrays.sort(s);
        System.out.println("Array ordinato di stringhe: " + s[0]);
    }

}
