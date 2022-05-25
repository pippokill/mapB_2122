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
package di.uniba.map.b.lab.rest.esercizi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pierpaolo
 */
public class OpenWeatherClient {

    /**
     *
     */
    public static final String API_KEY = "";

    /**
     *
     * @param city
     * @return
     */
    public static String getWeatherByCity(String city) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.openweathermap.org/data/2.5");
        Response resp = target.path("weather")
                .queryParam("appid", API_KEY)
                .queryParam("q", city)
                .request(MediaType.APPLICATION_JSON).get();
        return resp.readEntity(String.class);
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public static String getWeatherByCoordinates(double lat, double lon) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.openweathermap.org/data/2.5");
        Response resp = target.path("weather")
                .queryParam("appid", API_KEY)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .request(MediaType.APPLICATION_JSON).get();
        return resp.readEntity(String.class);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getWeatherByCity("Bari"));
        System.out.println();
        System.out.println(getWeatherByCoordinates(20.5, 40.9));
    }

}
