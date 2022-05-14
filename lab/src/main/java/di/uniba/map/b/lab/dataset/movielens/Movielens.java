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
package di.uniba.map.b.lab.dataset.movielens;

import di.uniba.map.b.lab.dataset.Dataset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author pierpaolo
 */
public class Movielens implements Dataset {

    private static final String NAME = "Movielens";

    private List<User> users;

    private List<Rating> ratings;

    private List<Movie> movies;

    /**
     *
     * @param file
     * @throws IOException
     */
    @Override
    public void load(File file) throws IOException {
        if (file.isDirectory()) {
            loadMovies(new File(file.getAbsolutePath() + "/movies.dat"));
            loadRatings(new File(file.getAbsolutePath() + "/ratings.dat.gz"));
            loadUsers(new File(file.getAbsolutePath() + "/users.dat"));
        } else {
            throw new IOException("The file is not a directory");
        }
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     *
     * @return
     */
    public List<Rating> getRatings() {
        return ratings;
    }

    /**
     *
     * @param ratings
     */
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     *
     * @return
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return NAME;
    }

    private void loadMovies(File file) throws IOException {
        movies = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            String[] split = reader.readLine().split("::");
            movies.add(new Movie(split[0],
                    split[1],
                    split[2].split("\\|")));
        }
        reader.close();
    }

    private void loadRatings(File file) throws IOException {
        ratings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(new FileInputStream(file))));
        while (reader.ready()) {
            String[] split = reader.readLine().split("::");
            ratings.add(new Rating(split[0],
                    split[1],
                    Integer.parseInt(split[2]),
                    Long.parseLong(split[3])));
        }
        reader.close();
    }

    private void loadUsers(File file) throws IOException {
        users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            String[] split = reader.readLine().split("::");
            users.add(new User(split[0],
                    split[1].equals("F") ? User.Gender.FEMALE : User.Gender.MALE,
                    Integer.parseInt(split[2]),
                    Integer.parseInt(split[3]),
                    split[4]));
        }
        reader.close();
    }

}
