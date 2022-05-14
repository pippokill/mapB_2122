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

import java.util.Objects;

/**
 * UserID::Gender::Age::Occupation::Zip-code - Gender is denoted by a "M" for
 * male and "F" for female - Age is chosen from the following ranges:
 *
 * 1: "Under 18" 18: "18-24" 25: "25-34" 35: "35-44" 45: "45-49" 50: "50-55" 56:
 * "56+"
 *
 * - Occupation is chosen from the following choices:
 *
 * 0: "other" or not specified 1: "academic/educator" 2: "artist" 3:
 * "clerical/admin" 4: "college/grad student" 5: "customer service" 6:
 * "doctor/health care" 7: "executive/managerial" 8: "farmer" 9: "homemaker" 10:
 * "K-12 student" 11: "lawyer" 12: "programmer" 13: "retired" 14:
 * "sales/marketing" 15: "scientist" 16: "self-employed" 17:
 * "technician/engineer" 18: "tradesman/craftsman" 19: "unemployed" 20: "writer"
 *
 * @author pierpaolo
 */
public class User {

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

    private String userId;

    private Gender gender;

    private int age;

    private int occupation;

    private String zipcode;

    /**
     *
     * @param userId
     * @param gender
     * @param age
     * @param occupation
     * @param zipcode
     */
    public User(String userId, Gender gender, int age, int occupation, String zipcode) {
        this.userId = userId;
        this.gender = gender;
        this.age = age;
        this.occupation = occupation;
        this.zipcode = zipcode;
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
    public int getOccupation() {
        return occupation;
    }

    /**
     *
     * @param occupation
     */
    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    /**
     *
     * @return
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     *
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.userId);
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
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
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
        return "User{" + "userId=" + userId + ", gender=" + gender + ", age=" + age + ", occupation=" + occupation + ", zipcode=" + zipcode + '}';
    }

    private static final String[] OCCUPATION_LABELS = new String[]{
        "other",
        "academic/educator",
        "artist",
        "clerical/admin",
        "college/gradstudent",
        "customerservice",
        "doctor/healthcare",
        "executive/managerial",
        "farmer",
        "homemaker",
        "K-student",
        "lawyer",
        "programmer",
        "retired",
        "sales/marketing",
        "scientist",
        "self-employed",
        "technician/engineer",
        "tradesman/craftsman",
        "unemployed",
        "writer"
    };

    /**
     *
     * @param code
     * @return
     */
    public static String occupationToString(int code) {
        return code >= 0 && code < OCCUPATION_LABELS.length ? OCCUPATION_LABELS[code] : "NA";
    }
}
