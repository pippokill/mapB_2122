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
package di.uniba.map.b.lab.lambda;

/**
 *
 * @author pierpaolo
 */
public class Person {

    /**
     *
     */
    public enum Gender {

        /**
         *
         */
        MALE,

        /**
         *
         */
        FEMALE
    }

    private String name;

    private String surname;

    private int age;

    private Gender gender;

    /**
     *
     * @param name
     * @param surname
     * @param age
     * @param gender
     */
    public Person(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
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
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     */
    public void printPerson() {
        System.out.println("Person{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender + '}');
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender + '}';
    }
    
    

}
