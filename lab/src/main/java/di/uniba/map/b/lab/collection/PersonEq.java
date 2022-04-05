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

import java.util.Objects;

/**
 *
 * @author pierpaolo
 */
public class PersonEq implements Comparable<PersonEq> {

    private String cf;

    private String surname;

    private String name;

    private int age;

    /**
     *
     * @param cf
     * @param surname
     * @param name
     * @param age
     */
    public PersonEq(String cf, String surname, String name, int age) {
        this.cf = cf;
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    /**
     *
     * @param cf
     */
    public PersonEq(String cf) {
        this.cf = cf;
    }

    /**
     *
     * @return
     */
    public String getCf() {
        return cf;
    }

    /**
     *
     * @param cf
     */
    public void setCf(String cf) {
        this.cf = cf;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.cf);
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
        final PersonEq other = (PersonEq) obj;
        if (!Objects.equals(this.cf, other.cf)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(PersonEq o) {
        /*if (age == o.getAge()) {
            return 0;
        } else if (age > o.getAge()) {
            return 1;
        } else {
            return -1;
        }*/
        return Integer.compare(age, o.getAge());
    }
    
    /**
     *
     * @return
     */
    public String toString() {
        return name+" "+surname+" "+cf;
    }

}
