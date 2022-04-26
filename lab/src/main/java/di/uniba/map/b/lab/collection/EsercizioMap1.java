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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author pierpaolo
 */
public class EsercizioMap1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }
        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        
        Set<String> ks=m.keySet();
        for (String k:ks) {
            System.out.println(k);
        }
        
        Iterator<String> it = ks.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
        Collection<Integer> values = m.values();
        for (Integer i:values) {
            System.out.println(i);
        }
        
        Set<Map.Entry<String, Integer>> entrySet = m.entrySet();
        for (Map.Entry<String,Integer> e:entrySet) {
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
    }
}
