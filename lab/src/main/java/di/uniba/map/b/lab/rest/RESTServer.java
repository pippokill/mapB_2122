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

import di.uniba.map.b.lab.rest.service.BookService;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author pierpaolo
 */
public class RESTServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(4321).build();
        ResourceConfig config = new ResourceConfig(BookService.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        try {
            server.start();
            System.out.println(String.format("Jersey app started with WADL available at "
                    + "%sapplication.wadl\nHit enter to stop it...", "http://localhost:4321/"));
            System.in.read();
            server.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(RESTServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
