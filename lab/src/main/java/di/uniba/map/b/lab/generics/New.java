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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class New {

    /**
     *
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Il metodo map() non conosce i tipi passati
        // per argomento
        //Questa cosa non è più vera dalla JDK 8 ed è possibile fare inferenza
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
    }
}
