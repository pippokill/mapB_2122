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
package di.uniba.map.b.lab.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class TestInference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> ls=new ArrayList();
        ls.add("pippo");
        Class c=ArrayList.class;
        System.out.println(c.getName());
        System.out.println(ls.getClass().getName());
        List<Integer> ls1=new ArrayList();
        ls1.add(1);
        System.out.println(ls1.getClass().getName());
    }
    
}
