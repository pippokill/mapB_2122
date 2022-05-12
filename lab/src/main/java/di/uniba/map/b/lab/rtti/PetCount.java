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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
class Pet {
}

class Dog extends Pet {
}

class Pug extends Dog {
}

class Cat extends Pet {
}

class Rodent extends Pet {
}

class Gerbil extends Rodent {
}

class Hamster extends Rodent {
}

class Counter {

    int i;
}

/**
 *
 * @author pierpaolo
 */
public class PetCount {

    static String[] TYPE_NAMES = {"Pet", "Dog", "Pug", "Cat", "Rodent", "Gerbil", "Hamster"};

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List pets = new ArrayList();
        Class[] petTypes = {Class.forName("di.uniba.map.b.lab.rtti.Dog"),
            Class.forName("di.uniba.map.b.lab.rtti.Pug"),
            Class.forName("di.uniba.map.b.lab.rtti.Cat"),
            Class.forName("di.uniba.map.b.lab.rtti.Rodent"),
            Class.forName("di.uniba.map.b.lab.rtti.Gerbil"),
            Class.forName("di.uniba.map.b.lab.rtti.Hamster")};
        for (int i = 0; i < 15; i++) {
            pets.add(petTypes[(int) (Math.random() * petTypes.length)].newInstance());
        }
        Map h = new HashMap();
        for (int i = 0; i < TYPE_NAMES.length; i++) {
            h.put(TYPE_NAMES[i], new Counter());
        }
        for (int i = 0; i < pets.size(); i++) {
            Object o = pets.get(i);
            if (o instanceof Pet) {
                ((Counter) h.get("Pet")).i++;
            }
            if (o instanceof Dog) {
                ((Counter) h.get("Dog")).i++;
            }
            if (o instanceof Pug) {
                ((Counter) h.get("Pug")).i++;
            }
            if (o instanceof Cat) {
                ((Counter) h.get("Cat")).i++;
            }
            if (o instanceof Rodent) {
                ((Counter) h.get("Rodent")).i++;
            }
            if (o instanceof Gerbil) {
                ((Counter) h.get("Gerbil")).i++;
            }
            if (o instanceof Hamster) {
                ((Counter) h.get("Hamster")).i++;
            }
        }
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).getClass());
        }
        for (int i = 0; i < TYPE_NAMES.length; i++) {
            System.out.println(TYPE_NAMES[i] + " quantity: "
                    + ((Counter) h.get(TYPE_NAMES[i])).i);
        }
    }
}
