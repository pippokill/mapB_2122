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
public class TestNumber {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int parseInt = Integer.parseInt("100");
        System.out.println(parseInt + 10);
        String s = String.valueOf(10.00);
        System.out.println("Value: " + s);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        double d = Double.parseDouble("10034.323");
        System.out.println(d);
        Double dd = new Double("5.4");
        double ddd = dd;
        System.out.println(ddd);
        System.out.println(Math.random());
        System.out.println(Math.pow(2, 8));
        System.out.println(Math.sqrt(9));
    }
}
