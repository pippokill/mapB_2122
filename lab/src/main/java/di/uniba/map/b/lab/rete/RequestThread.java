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
import java.net.Socket;

/**
 *
 * @author pierpaolo
 */
public class RequestThread extends Thread {

    private final Socket socket;

    /**
     *
     * @param socket
     */
    public RequestThread(Socket socket) {
        this.socket = socket;
    }

    /**
     *
     * @param socket
     * @param name
     */
    public RequestThread(Socket socket, String name) {
        super(name);
        this.socket = socket;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            System.out.println("Connessione accettata: " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
                String str = in.readLine();
                if (str.equals("END")) {
                    break;
                }
                System.out.println("Echoing (" + this.getName() + "): " + str);
                out.println(str);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            System.out.println("closing...");
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
