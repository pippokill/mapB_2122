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

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author pierpaolo
 */
public class Consumatore extends Thread {

    private final BlockingQueue<String> queue;

    private final Writer writer;

    private boolean run = true;

    /**
     *
     * @param queue
     * @param writer
     */
    public Consumatore(BlockingQueue<String> queue, Writer writer) {
        setName("Consumatore");
        this.queue = queue;
        this.writer = writer;
    }

    /**
     *
     */
    @Override
    public void run() {
        int c=0;
        while (run) {
            try {
                String element = queue.poll(1, TimeUnit.SECONDS);
                if (element == null) {
                    System.err.println("[" + getName() + "] Tempo scaduto.");
                    run = false;
                } else {
                    try {
                        writer.append(element).append("\n");
                    } catch (IOException ex) {
                        System.err.println("[" + getName() + "] Errore di I/O: " + ex.getMessage());
                        run = false;
                    }
                }
                c++;
                if (c % 100 == 0) {
                    System.out.println("[" + getName() + "] Consumati: " + c);
                }
            } catch (InterruptedException ex) {
                System.err.println("[" + getName() + "] Interrotto durante attesa.");
                run = false;
            }
        }
    }

}
