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
package di.uniba.map.b.lab.generics;

/**
 *
 * @author pierpaolo
 */
public class Holder2 {

    private Object a;

    /**
     *
     * @param a
     */
    public Holder2(Object a) {
        this.a = a;
    }

    /**
     *
     * @param a
     */
    public void set(Object a) {
        this.a = a;
    }

    /**
     *
     * @return
     */
    public Object get() {
        return a;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a =(Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1); // Autoboxes to Integer
        Integer x = (Integer) h2.get();
    }
}
