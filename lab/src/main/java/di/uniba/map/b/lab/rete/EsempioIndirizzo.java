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

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author pierpaolo
 */
public class EsempioIndirizzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress add = InetAddress.getByName(null);
            System.out.println(add);
            add = InetAddress.getByName("localhost");
            System.out.println(add);
            add = InetAddress.getByName("127.0.0.1");
            System.out.println(add);
            add = InetAddress.getByName("www.google.it");
            System.out.println(add);
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        }
    }
    
}
