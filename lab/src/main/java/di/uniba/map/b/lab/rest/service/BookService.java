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
package di.uniba.map.b.lab.rest.service;

import com.google.gson.Gson;
import di.uniba.map.b.lab.rest.Book;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pierpaolo
 */
@Path("book")
public class BookService {

    /**
     *
     * @param bookid
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getBookById(@DefaultValue("-1") @QueryParam("id") String bookid) {
        System.out.println("Book id: " + bookid);
        Book book = new Book("Lo Zen e l’arte della manutenzione della motocicletta",
                "9788845902826",
                new String[]{"Robert M. Pirsig"},
                12.50);
        Gson gson = new Gson();
        //Object -> JSON
        String jsonString = gson.toJson(book);
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    /**
     *
     * @param bookid
     * @return
     */
    @GET
    @Path("/{bookid}")
    @Produces("application/json")
    public Response book(@PathParam("bookid") String bookid) {
        System.out.println("Book id: " + bookid);
        Book book = new Book("Lo Zen e l’arte della manutenzione della motocicletta",
                "9788845902826",
                new String[]{"Robert M. Pirsig"},
                12.50);
        Gson gson = new Gson();
        //Object -> JSON
        String jsonString = gson.toJson(book);
        return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
    }

    /**
     *
     * @param json
     * @return
     */
    @PUT
    @Path("/add")
    @Consumes("application/json")
    public Response add(String json) {
        Gson gson = new Gson();
        Book book = gson.fromJson(json, Book.class);
        System.out.println("Add book: " + book);
        return Response.ok().build();
    }

}
