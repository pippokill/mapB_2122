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
package di.uniba.map.b.lab.concorrente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class SynchronizedCounter {

    private int c = 0;

    private int d = 0;

    private int i = 0;

    /**
     *
     */
    public synchronized void increment() {
        c++;
        i++;
    }

    /**
     *
     */
    public synchronized void decrement() {
        c--;
        d++;
    }

    /**
     *
     * @return
     */
    public synchronized int value() {
        return c;
    }

    public String toString() {
        return d + " " + i;
    }

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter sc = new SynchronizedCounter();
        List<Thread> l = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Thread t = new CounterThread(sc);
            l.add(t);
        }
        for (Thread t : l) {
            t.start();
        }
        for (Thread t : l) {
            t.join();
        }
        System.out.println(sc.value());
        System.out.println(sc);
    }

}
