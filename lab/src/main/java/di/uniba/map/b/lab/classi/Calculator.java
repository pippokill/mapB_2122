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
public class Calculator {
    
    private double memory;  //memoria della calcolatrice

    /**
     *
     */
    public Calculator() {
    }

    /**
     *
     * @param memory
     */
    public Calculator(double memory) {
        this.memory = memory;
    }

    /**
     *
     * @return
     */
    public double getMemory() {
        return memory;
    }

    /**
     *
     * @param memory
     */
    public void setMemory(double memory) {
        this.memory = memory;
    }

    /**
     *
     */
    public void resetMemory() {
        this.setMemory(0);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double sum(double a, double b) {
        return a + b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double diff(double a, double b) {
        return a - b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double mul(double a, double b) {
        return a * b;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double div(double a, double b) {
        return a / b;
    }

    /**
     *
     * @param n
     * @return
     */
    public double sqrt(double n) {
        return Math.sqrt(n);
    }
}
