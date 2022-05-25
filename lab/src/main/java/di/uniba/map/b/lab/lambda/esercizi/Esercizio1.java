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
package di.uniba.map.b.lab.lambda.esercizi;

import di.uniba.map.b.lab.dataset.movielens.Movie;
import di.uniba.map.b.lab.dataset.movielens.Movielens;
import di.uniba.map.b.lab.dataset.movielens.Rating;
import di.uniba.map.b.lab.dataset.movielens.User;
import di.uniba.map.b.lab.dataset.movielens.User.Gender;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author pierpaolo
 */
public class Esercizio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Movielens movielens = new Movielens();
            movielens.load(new File("resources/movielens1M"));
            //Effettuare le seguenti operazioni utilizzando il più possibile gli stream e le espressioni lambda
            //1. raggruppare tutti gli utenti di genere femminile con età maggiore o uguale a 25 anni in base all’occupazione
            Map<Integer, List<User>> es1 = movielens.getUsers().stream()
                    .filter(u -> u.getGender() == Gender.FEMALE && u.getAge() >= 25)
                    .collect(Collectors.groupingBy(User::getOccupation));
            //2. raggruppare tutti gli utenti di genere maschile che hanno come occupazione "unemployed" e raggrupparli in base allo zipcode
            Map<String, List<User>> es2 = movielens.getUsers().stream()
                    .filter(u -> u.getGender() == Gender.MALE && u.getOccupation() == 19)
                    .collect(Collectors.groupingBy(User::getZipcode));
            //3. raggruppare tutti gli utenti che hanno come occupazione "unemployed" e contare quanti utenti ci sono per ogni classe di età
            Map<Integer, Long> es3 = movielens.getUsers().stream()
                    .filter(u -> u.getOccupation() == 19)
                    .collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
            //4. contare quanti rating > 3
            long es4 = movielens.getRatings().stream()
                    .filter(r -> r.getRating() > 3)
                    .count();
            // movie con rating > 3
            int es4m = movielens.getRatings().stream()
                    .filter(r -> r.getRating() > 3)
                    .collect(Collectors.groupingBy(Rating::getMovieId)).size();
            //5. calcolare per ogni movie il rating medio dato dagli utenti
            Map<String, Double> es5 = movielens.getRatings().stream()
                    .collect(Collectors.groupingBy(Rating::getMovieId, Collectors.averagingInt(Rating::getRating)));
            //5_1. contare quanti movie hanno rating medio >3
            long count3 = movielens.getRatings().stream()
                    .collect(Collectors.groupingBy(Rating::getMovieId, Collectors.averagingInt(Rating::getRating)))
                    .values().stream().filter(v -> v > 3).count();
            System.out.println(count3);
            //6. calcolare il rating medio dei movie di genere “Comedy”
            //NB: questa implementazione richiede DUE espressioni lambda
            Set<String> comedyMovieSet = movielens.getMovies().stream()
                    .filter(m -> m.getGenres().contains("Comedy"))
                    .map(m -> m.getMovieID())
                    .collect(Collectors.toSet());
            double es6 = movielens.getRatings().stream()
                    .filter(r -> comedyMovieSet.contains(r.getMovieId()))
                    .mapToDouble(r -> r.getRating())
                    .average().getAsDouble();
            System.out.println(es6);
            //NB: questa implementazione è più lenta in quanto ogni volta devo cercare nella lista dei movie
            /*double es6_1 = movielens.getRatings().stream()
                    .filter(r -> {
                        int idx = movielens.getMovies().indexOf(new Movie(r.getMovieId(), ""));
                        if (idx >= 0 && movielens.getMovies().get(idx).getGenres().contains("Comedy")) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .mapToDouble(r -> r.getRating())
                    .average().getAsDouble();
            System.out.println(es6_1);*/
            //7. calcolare il rating medio raggruppando per genere del movie
            //viene riutilizzata la prima soluzione dell'esercizio 6 che viene applicata ad
            //ogni genere
            Map<String, Double> gavg = new HashMap();
            movielens.getMovies().stream()
                    .flatMap(m -> m.getGenres().stream())
                    .collect(Collectors.toSet())
                    .forEach(g -> {
                        Set<String> movieset = movielens.getMovies().stream()
                                .filter(m -> m.getGenres().contains(g))
                                .map(m -> m.getMovieID())
                                .collect(Collectors.toSet());
                        double avg = movielens.getRatings().stream()
                                .filter(r -> movieset.contains(r.getMovieId()))
                                .mapToDouble(r -> r.getRating())
                                .average().getAsDouble();
                        gavg.put(g, avg);
                    });
            System.out.println(gavg);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
