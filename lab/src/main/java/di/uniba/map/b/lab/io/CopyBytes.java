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
package di.uniba.map.b.lab.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author pierpaolo
 */
public class CopyBytes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("resources/sorgente.txt");
            out = new FileOutputStream("resources/destinazione.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException ex) {
            System.err.println("IO exception: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.err.println("IO chiusura file: " + ex.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.err.println("IO chiusura file: " + ex.getMessage());
                }
            }
        }
    }

}
