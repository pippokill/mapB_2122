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
package di.uniba.map.b.lab.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class TestSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonEq p1 = new PersonEq("jkjlk3242", "Bianchi", "Giovanni", 45);
        PersonEq p2 = new PersonEq("jkljk32543", "Verdi", "Maria", 23);
        List<PersonEq> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        Collections.sort(l);
        for (PersonEq p : l) {
            System.out.println(p);
        }
        Collections.sort(l, new PersonSurnameComp());
        for (PersonEq p : l) {
            System.out.println(p);
        }
    }

}
