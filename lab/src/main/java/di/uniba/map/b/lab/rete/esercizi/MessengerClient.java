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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author pierpaolo
 */
public class MessengerClient {

    /*
    * Questo Thread è utilizzato per leggere dall'input stream connesso al socket
    * e stampare la stringa ricevuta sul terminale.
     */
    private static class ClientThread extends Thread {

        private final BufferedReader in;

        private boolean run = true;

        public ClientThread(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            while (run) {
                try {
                    System.out.println(in.readLine());
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }

        public boolean isRun() {
            return run;
        }

        public void setRun(boolean run) {
            this.run = run;
        }

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // indirizzo riservato al localhost 127.0.0.1
        InetAddress addr = InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, 6666);
        // Pone tutto in un blocco try-finally per assicurarsi che
        // il socket sia chiuso:
        System.out.println("socket = " + socket);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Flush automatico con PrintWriter:
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            Scanner scanner = new Scanner(System.in);
            String user = null;
            do {
                System.out.println("Inserisci il tuo nome utente");
                user = scanner.nextLine();
                out.println("#name " + user);
                String ans = in.readLine();
                System.out.println(ans);
                if (!ans.equals("#ok")) {
                    user = null;
                }
            } while (user == null);
            ClientThread ct = new ClientThread(in);
            ct.start();
            while (true) {
                String cmd = scanner.nextLine();
                if (cmd.equals("#exit")) {
                    out.println("#remove " + user);
                    out.println(cmd);
                    break;
                } else {
                    out.println(cmd);
                }
            }
            //Termino il Thread che si occupa di stampare i messaggi sul terminale
            ct.setRun(false);
            try {
                ct.join();
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }

}
