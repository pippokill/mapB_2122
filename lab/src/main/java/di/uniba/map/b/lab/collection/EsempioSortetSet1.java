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

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author pierpaolo
 */
public class EsempioSortetSet1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SortedSet<String> s = new TreeSet<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("l");
        s.add("m");
        s.add("y");
        System.out.println(s.subSet("d", "z"));
        System.out.println(s.headSet("l"));
        System.out.println(s.tailSet("h"));
        System.out.println(s.first());
        System.out.println(s.last());
    }
}
