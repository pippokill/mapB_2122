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

/**
 *
 * @author pierpaolo
 */
public class StringBuilderDemo {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("This");
        sb.append(" ").append("is ");
        sb.append("a string builder");
        System.out.println(sb);
        System.out.println(sb.reverse().toString());
        sb.insert(0, "New insert. ");
        System.out.println(sb.toString());
        sb.delete(11, sb.length());
        System.out.println(sb.toString());
        String palindrome = "Dot saw I was Tod";
        StringBuilder sb1 = new StringBuilder(palindrome);
        sb1.reverse(); // reverse it
        System.out.println(sb1);
    }
}
