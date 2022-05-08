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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author pierpaolo
 */
public class TestProduttoreConsumatore {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(1000);
        BufferedWriter writer = new BufferedWriter(new FileWriter("./resources/produttore.txt"));
        Produttore p1 = new Produttore(queue, "P1", 10000);
        Produttore p2 = new Produttore(queue, "P2", 10000);
        Consumatore c = new Consumatore(queue, writer);
        p1.start();
        p2.start();
        c.start();
        p1.join();
        p2.join();
        c.join();
        writer.close();
    }

}
