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
package di.uniba.map.b.lab.rest;

import com.google.gson.Gson;

/**
 *
 * @author pierpaolo
 */
public class TestGson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book = new Book("Lo Zen e l’arte della manutenzione della motocicletta",
                 "9788845902826",
                 new String[]{"Robert M. Pirsig"},
                 12.50);
        Gson gson = new Gson();
        //Object -> JSON
        String jsonString = gson.toJson(book);
        System.out.println(jsonString);
        //JSON -> Object
        Book book2 = gson.fromJson(jsonString, Book.class);
        System.out.println(book2);
    }

}
