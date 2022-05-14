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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * MovieID::Title::Genres
 *
 * - Titles are identical to titles provided by the IMDB (including year of
 * release) - Genres are pipe-separated and are selected from the following
 * genres:
 *
 * Action Adventure Animation Children's Comedy Crime Documentary Drama Fantasy
 * Film-Noir Horror Musical Mystery Romance Sci-Fi Thriller War Western
 *
 * @author pierpaolo
 */
public class Movie {

    private String movieID;

    private String title;

    private Set<String> genres;

    /**
     *
     * @param movieID
     * @param title
     */
    public Movie(String movieID, String title) {
        this.movieID = movieID;
        this.title = title;
    }

    /**
     *
     * @param movieID
     * @param title
     * @param genres
     */
    public Movie(String movieID, String title, Set<String> genres) {
        this.movieID = movieID;
        this.title = title;
        this.genres = genres;
    }

    /**
     *
     * @param movieID
     * @param title
     * @param genres
     */
    public Movie(String movieID, String title, String[] genres) {
        this.movieID = movieID;
        this.title = title;
        this.genres = new HashSet(Arrays.asList(genres));
    }

    /**
     *
     * @return
     */
    public String getMovieID() {
        return movieID;
    }

    /**
     *
     * @param movieID
     */
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Set<String> getGenres() {
        return genres;
    }

    /**
     *
     * @param genres
     */
    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Movie{" + "movieID=" + movieID + ", title=" + title + ", genres=" + genres + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.movieID);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.movieID, other.movieID)) {
            return false;
        }
        return true;
    }

}
