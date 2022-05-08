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
public class HelloThread extends Thread {

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        Thread t1 = new HelloThread();
        t1.start();
        Thread t2 = new HelloThread();
        t2.start();
    }

}
