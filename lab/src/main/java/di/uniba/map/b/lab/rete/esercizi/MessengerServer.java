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
package di.uniba.map.b.lab.rete.esercizi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 *
 * @author pierpaolo
 */
public class MessengerServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        MessengerData md = new MessengerData();
        ServerSocket s = new ServerSocket(6666);
        System.out.println("Started: " + s);
        try {
            while (true) {
                Socket socket = s.accept();
                //UUID è utilizzato per creare un id univoco da utilizzare come nome del Thread
                Thread t = new MessengerThread(socket, md, UUID.randomUUID().toString());
                t.start();
            }
        } finally {
            s.close();
        }
    }

}
