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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class EsempioSet1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        //Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("c");
        set.add("b");
        System.out.println(set.size() + ": " + set);
        set.remove("a");
        System.out.println(set.size() + ": " + set);
        Set<String> set1 = new LinkedHashSet<>();
        //Set<String> set1 = new HashSet<>();
        set1.add("b");
        set1.add("c");
        set.removeAll(set1);
        System.out.println(set.size() + ": " + set);
    }
}
