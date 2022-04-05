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
package di.uniba.map.b.lab.collection;

import java.util.Comparator;

/**
 *
 * @author pierpaolo
 */
public class PersonSurnameComp implements Comparator<PersonEq> {

    /**
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(PersonEq o1, PersonEq o2) {
        /*if (o1.getSurname().equals(o2.getSurname())) {
            return 0;
        } else if (o1.getSurname().compareTo(o2.getSurname()) > 0) {
            return 1;
        } else {
            return -1;
        }*/
        return o1.getSurname().compareTo(o2.getSurname());
    }

}
