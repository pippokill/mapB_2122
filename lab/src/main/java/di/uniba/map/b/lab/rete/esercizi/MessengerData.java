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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pierpaolo
 */
public class MessengerData {

    private final Map<String, MessengerThread> clients = new HashMap<>();

    /**
     *
     * @param username
     * @param thread
     * @throws Exception
     */
    public synchronized void addUser(String username, MessengerThread thread) throws Exception {
        if (clients.containsKey(username)) {
            throw new Exception("Utente già esistente");
        } else {
            clients.put(username, thread);
        }
    }

    /**
     *
     * @param username
     * @param message
     * @throws Exception
     */
    public synchronized void sendMessage(String username, String message) throws Exception {
        MessengerThread t = clients.get(username);
        if (t != null) {
            t.sendMessage(message);
        } else {
            throw new Exception("L'utente non esiste");
        }
    }

    /**
     *
     * @param sender
     * @param username
     * @param message
     * @throws Exception
     */
    public synchronized void sendMessage(String sender, String username, String message) throws Exception {
        MessengerThread t = clients.get(username);
        if (t != null) {
            t.sendMessage(sender + ": " + message);
        } else {
            throw new Exception("L'utente non esiste");
        }
    }

    /**
     *
     * @param username
     * @throws Exception
     */
    public synchronized void removeUser(String username) throws Exception {
        if (clients.containsKey(username)) {
            clients.remove(username);
        } else {
            throw new Exception("Utente inesistente");
        }
    }

}
