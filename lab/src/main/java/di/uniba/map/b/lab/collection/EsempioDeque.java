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

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author pierpaolo
 */
public class EsempioDeque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deque<String> q = new LinkedList<>();
        q.offerLast("g");
        q.offerLast("h");
        q.offerFirst("z");
        q.offerLast("a");
        System.out.println("Coda: " + q.peekLast());
        System.out.println("Testa: " + q.peekFirst());
    }

}
