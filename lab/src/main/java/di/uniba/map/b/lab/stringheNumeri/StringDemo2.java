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
package di.uniba.map.b.lab.stringheNumeri;

import java.util.Arrays;

/**
 *
 * @author pierpaolo
 */
public class StringDemo2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "This is a string object";
        System.out.println(s.length());
        System.out.println(s.substring(0, 5));
        System.out.println(s.replace('i', 'X'));
        System.out.println(s.replace("string", ""));
        System.out.println(s.indexOf("object"));
        System.out.println(s.contains("string"));
        System.out.println(s.startsWith("Th"));
        System.out.println(s.endsWith("ect"));
        System.out.println(Arrays.toString(s.split(" ")));
    }
}
