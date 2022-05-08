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
package di.uniba.map.b.lab.concorrente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class SynchronizedObj {

    private String lastName;

    private int nameCount = 0;

    private List<String> nameList = new ArrayList<>();

    /**
     *
     * @param name
     */
    public void addName(String name) {
        synchronized (this) {
            lastName = name;
            nameCount++;
        }
        nameList.add(name);
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public int getNameCount() {
        return nameCount;
    }

    /**
     *
     * @return
     */
    public List<String> getNameList() {
        return nameList;
    }

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObj sobj = new SynchronizedObj();
        for (int i = 0; i < 100; i++) {
            Thread t = new NameThread(sobj, "Name-" + i);
            t.start();
        }
        Thread.sleep(3000);
        System.err.println(sobj.getNameCount());
        System.err.println(sobj.getLastName());
        System.err.println(sobj.getNameList());
    }

}
