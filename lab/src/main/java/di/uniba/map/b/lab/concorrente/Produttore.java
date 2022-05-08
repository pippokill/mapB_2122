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

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pierpaolo
 */
public class Produttore extends Thread {

    private static final String CHARS = "qwertyuiopasdfghjklzxcvbnm";

    private final int np;

    private final Random random = new Random();

    private final BlockingQueue<String> queue;

    /**
     *
     * @param queue
     * @param name
     * @param np
     */
    public Produttore(BlockingQueue<String> queue, String name, int np) {
        setName(name);
        this.queue = queue;
        this.np = np;
    }

    /**
     *
     */
    @Override
    public void run() {
        for (int i = 0; i < np; i++) {
            try {
                if (!queue.offer(getName() + ": " + generateRandomString(), 2, TimeUnit.SECONDS)) {
                    System.err.println("[" + getName() + "] Tempo scaduto.");
                    break;
                }
                if ((i + 1) % 100 == 0) {
                    System.out.println("[" + getName() + "] Prodotti: " + i);
                }
            } catch (InterruptedException ex) {
                System.err.println("[" + getName() + "] Interrotto durante attesa.");
                break;
            }
        }
    }

    private String generateRandomString() {
        int length = random.nextInt(10) + 2; //lunghezza da 2 a 11
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            int k = random.nextInt(CHARS.length()); //scegli un carattere random da CHARS
            chars[i] = CHARS.charAt(k);
        }
        return new String(chars);
    }

}
