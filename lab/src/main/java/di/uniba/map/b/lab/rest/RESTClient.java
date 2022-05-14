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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pierpaolo
 */
public class RESTClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:4321");
        
        Response resp = target.path("book").queryParam("id", "1").request(MediaType.APPLICATION_JSON).get();
        System.out.println(resp);
        System.out.println(resp.readEntity(String.class));
        
        resp = target.path("book/1").request(MediaType.APPLICATION_JSON).get();
        System.out.println(resp);
        System.out.println(resp.readEntity(String.class));

        Gson gson = new Gson();
        Book book = new Book("Lo Zen e l’arte della manutenzione della motocicletta",
                "9788845902826",
                new String[]{"Robert M. Pirsig"},
                12.50);
        resp=target.path("book/add").request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(gson.toJson(book), MediaType.APPLICATION_JSON));
        System.out.println(resp);
    }

}
