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

/**
 *
 * @author pierpaolo
 */
class Candy {

    static {  // questa è una clausola statica
        System.out.println("Loading Candy");
    }
}

class Cookie {

    static {  // questa è una clausola statica
        System.out.println("Loading Cookie");
    }
}

/**
 *
 * @author pierpaolo
 */
public class SweetShop {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("inside main");
        try {
            new Candy();
            //Class.forName("di.uniba.map.b.lab.rtti.Candy");
            //Candy.class.newInstance();
            System.out.println("After creating Candy");
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        //} catch (InstantiationException | IllegalAccessException ex) {
            //System.err.println(e);
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
