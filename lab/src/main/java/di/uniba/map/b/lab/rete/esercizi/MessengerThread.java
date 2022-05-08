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
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pierpaolo
 */
public class MessengerThread extends Thread {

    private final Socket socket;

    private boolean run = true;

    private String username;

    private final MessengerData md;

    private PrintWriter out = null;

    /**
     *
     * @param socket
     * @param md
     */
    public MessengerThread(Socket socket, MessengerData md) {
        this.socket = socket;
        this.md = md;
    }

    /**
     *
     * @param socket
     * @param md
     * @param name
     */
    public MessengerThread(Socket socket, MessengerData md, String name) {
        this(socket, md);
        this.setName(name);
    }

    /**
     *
     * @param message
     */
    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            System.out.println("Connessione accettata: " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (run) {
                String str = in.readLine();
                if (str != null) {
                    str = str.trim();
                    Pattern pattern = Pattern.compile("\\S+");
                    Matcher matcher = pattern.matcher(str);
                    boolean findcmd = matcher.find();
                    if (findcmd && matcher.group().equalsIgnoreCase("#name")) {
                        if (matcher.find()) {
                            String name = matcher.group();
                            try {
                                md.addUser(name, this);
                                out.println("#ok");
                                username = name;
                            } catch (Exception ex) {
                                out.println("#error " + ex.getMessage());
                            }
                        }
                    } else if (findcmd && matcher.group().equalsIgnoreCase("#send")) {
                        String name = null;
                        String msg = null;
                        if (matcher.find()) {
                            name = matcher.group();
                            if (matcher.end() < str.length()) {
                                msg = str.substring(matcher.end()).trim();
                            }
                        }
                        if (name != null && msg != null) {
                            try {
                                if (username != null) {
                                    md.sendMessage(username, name, msg);
                                } else {
                                    md.sendMessage(name, msg);
                                }
                                out.println("#ok");
                            } catch (Exception ex) {
                                out.println("#error " + ex.getMessage());
                            }
                        }
                    } else if (findcmd && matcher.group().equalsIgnoreCase("#remove")) {
                        String name = null;
                        if (matcher.find()) {
                            name = matcher.group();
                        }
                        try {
                            if (name != null) {
                                md.removeUser(name);
                                out.println("#ok");
                            } else if (username != null) {
                                md.removeUser(username);
                                out.println("#ok");
                            }
                        } catch (Exception ex) {
                            out.println("#error " + ex.getMessage());
                        }
                    } else if (findcmd && matcher.group().equalsIgnoreCase("#exit")) {
                        run = false;
                    } else {
                        out.println("#error Comando sconosciuto");
                    }
                }
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
