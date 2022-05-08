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
public class Dispari implements Runnable {

    /**
     *
     */
    public void run() {
        int i = 1;
        for (int k = 0; k < 100; k++) {
            try {
                System.out.println(i);
                i += 2;
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
