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

/**
 *
 * @author pierpaolo
 * @param <T>
 */
public class LinkedStack<T> {

    private class Node<U> {

        U item;
        Node<U> next;

        Node() {
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    /**
     *
     * @param item
     */
    public void push(T item) {
        top = new Node<T>(item, top);
    }

    /**
     *
     * @return
     */
    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }
    
    public static void main(String[] args) {
        LinkedStack<String> s=new LinkedStack<>();
        s.push("pippo");
        System.out.println(s.pop());
    }
}
