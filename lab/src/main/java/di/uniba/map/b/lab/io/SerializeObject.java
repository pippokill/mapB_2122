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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author pierpaolo
 */
public class SerializeObject {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Car myCar = new Car("panda", 750, 3);
        FileOutputStream outFile = new FileOutputStream("resources/car.dat");
        ObjectOutputStream outStream = new ObjectOutputStream(outFile);
        outStream.writeObject(myCar);

        FileInputStream inFile = new FileInputStream("resources/car.dat");
        ObjectInputStream inStream = new ObjectInputStream(inFile);
        Car loadCar = (Car) inStream.readObject();
        System.out.println(loadCar);

    }

}
