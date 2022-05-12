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
package di.uniba.map.b.lab.rtti;

import java.lang.reflect.*;

/**
 *
 * @author pierpaolo
 */
public class ShowMethods {

    static final String USAGE = "usage: \n"
            + "ShowMethods qualified.class.name\n"
            + "To show all methods in class or: \n"
            + "ShowMethods qualified.class.name word\n"
            + "To search for methods involving 'word'";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }
        try {//args[0] è il nome della classe
            Class c = Class.forName(args[0]);
            Method[] m = c.getMethods();
            Constructor[] ctor = c.getConstructors();
            if (args.length == 1) {
                for (int i = 0; i < m.length; i++) {
                    System.out.println(m[i]);
                }
                for (int i = 0; i < ctor.length; i++) {
                    System.out.println(ctor[i]);
                }
            } else { //args[1] specifica il metodo o costruttore che sto cercando
                for (int i = 0; i < m.length; i++) {
                    if (m[i].toString().contains(args[1])) {
                        System.out.println(m[i]);
                    }
                }
                for (int i = 0; i < ctor.length; i++) {
                    if (ctor[i].toString().contains(args[1])) {
                        System.out.println(ctor[i]);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("No such class: " + e);
        }
    }
}
