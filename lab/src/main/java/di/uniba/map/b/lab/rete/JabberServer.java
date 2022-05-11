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
package di.uniba.map.b.lab.rete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pierpaolo
 */
public class JabberServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(6666);
        System.out.println("Started: " + s);
        try {
            // si blocca fino a quando non c’è una connessione
            Socket socket = s.accept();
            // connessione accettata
            try {
                System.out.println(
                        "Connessione accettata: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Flush automatico con PrintWriter:
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END")) {
                        break;
                    }
                    System.out.println("Echoing: " + str);
                    out.println("Server: "+str);
                }
                // chiude sempre i due socket...
            } finally {
                System.out.println("closing...");
                socket.close();
            }
        } finally {
            s.close();//ServerSocket
        }
    }

}
