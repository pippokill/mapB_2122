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
 * @param <T>
 */
public class Holder<T> {

    private T value;

    /**
     *
     */
    public Holder() {
    }

    /**
     *
     * @param val
     */
    public Holder(T val) {
        value = val;
    }

    /**
     *
     * @param val
     */
    public void set(T val) {
        value = val;
    }

    /**
     *
     * @return
     */
    public T get() {
        return value;
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        //Holder<Fruit> fruit = apple; // Cannot upcast
        Holder<Orange> orange = new Holder<>(new Orange());
        Holder<? extends Fruit> fruit = apple; // OK Apple è sottoclasse di Fruit
        Fruit p = fruit.get();
        d = (Apple) fruit.get(); // Returns 'Fruit'
        try {
            Orange c = (Orange) fruit.get(); // No warning
        } catch (Exception e) {
            System.out.println(e);
        }
        //fruit.set(new Apple()); // Cannot call set()
        //fruit.set(new Fruit()); // Cannot call set()
        System.out.println(fruit.equals(d)); // OK
    }
}
