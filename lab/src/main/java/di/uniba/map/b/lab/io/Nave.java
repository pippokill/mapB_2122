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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierpaolo
 */
class Nave implements Serializable {

    private static int nroNavi = 0;
    private int nroNave;
    private String nomeNave;

    public Nave(String nomeNave) {
        nroNave = nroNavi++;
        this.nomeNave = nomeNave;
    }

    @Override
    public String toString() {
        return nomeNave + ": " + nroNave;
    }

    public void salva() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("resources/nave.dat"));
        out.writeObject(this);
        out.writeObject(nroNavi);
        out.close();
    }

    public static Nave carica() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources/nave.dat"));
        Nave n = (Nave) in.readObject();
        Nave.nroNavi = (int) in.readObject();
        in.close();
        return n;
    }

    public static void main(String[] args) {
        try {
            new Nave("nave 1");
            new Nave("nave 2");
            Nave n3 = new Nave("nave 3");
            n3.salva();
            Nave n3s = Nave.carica();
            System.out.println(n3s);
            System.out.println(Nave.nroNavi);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
