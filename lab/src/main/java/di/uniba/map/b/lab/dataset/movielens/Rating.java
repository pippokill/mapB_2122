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

import java.util.Date;
import java.util.Objects;

/**
 * UserID::MovieID::Rating::Timestamp
 *
 * @author pierpaolo
 */
public class Rating {

    private String userId;

    private String movieId;

    private int rating;

    private Date date;

    /**
     *
     * @param userId
     * @param movieId
     * @param rating
     */
    public Rating(String userId, String movieId, int rating) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    /**
     *
     * @param userId
     * @param movieId
     * @param rating
     * @param date
     */
    public Rating(String userId, String movieId, int rating, Date date) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.date = date;
    }

    /**
     *
     * @param userId
     * @param movieId
     * @param rating
     * @param timestamp
     */
    public Rating(String userId, String movieId, int rating, long timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.date = new Date(timestamp);
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     *
     * @param movieId
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.userId);
        hash = 37 * hash + Objects.hashCode(this.movieId);
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
        final Rating other = (Rating) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (!Objects.equals(this.movieId, other.movieId)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Rating{" + "userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + ", date=" + date + '}';
    }
    
    

}
