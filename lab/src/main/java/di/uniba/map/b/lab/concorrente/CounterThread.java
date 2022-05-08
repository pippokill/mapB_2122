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

/**
 *
 * @author pierpaolo
 */
public class CounterThread extends Thread {

    private final SynchronizedCounter sc;

    /**
     *
     * @param sc
     */
    public CounterThread(SynchronizedCounter sc) {
        this.sc = sc;
    }

    /**
     *
     */
    @Override
    public void run() {
        double c = Math.random();
        if (c > 0.5) {
            System.out.println("Increment");
            sc.increment();
        } else {
            System.out.println("Decrement");
            sc.decrement();
        }
    }

}
