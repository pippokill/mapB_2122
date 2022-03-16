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
package di.uniba.map.b.lab.classi;

/**
 *
 * @author pierpaolo
 */
public enum Planet {

    /**
     *
     */
    MERCURY(3.303e+23, 2.4397e6),

    /**
     *
     */
    VENUS(4.869e+24, 6.0518e6),

    /**
     *
     */
    EARTH(5.976e+24, 6.37814e6),

    /**
     *
     */
    MARS(6.421e+23, 3.3972e6),

    /**
     *
     */
    JUPITER(1.9e+27, 7.1492e7),

    /**
     *
     */
    SATURN(5.688e+26, 6.0268e7),

    /**
     *
     */
    URANUS(8.686e+25, 2.5559e7),

    /**
     *
     */
    NEPTUNE(1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    /**
     *
     * @return
     */
    public double mass() {
        return mass;
    }

    /**
     *
     * @return
     */
    public double radius() {
        return radius;
    }
}
