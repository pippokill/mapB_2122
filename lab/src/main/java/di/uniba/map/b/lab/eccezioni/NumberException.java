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
package di.uniba.map.b.lab.eccezioni;

/**
 *
 * @author pierpaolo
 */
public class NumberException {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            double x = Double.parseDouble(args[0]);
            System.out.println("Il quadrato di " + args[0] + " è " + Math.pow(x, 2));
        } catch (NumberFormatException ex) {
            System.err.println("Il parametro " + args[0] + " non è un numero.");
        } finally {
            System.out.println("Arrivederci!");
        }
    }
}
