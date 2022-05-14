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

import java.util.function.IntConsumer;

/**
 *
 * @author pierpaolo
 */
public class Averager implements IntConsumer {

    private int sum = 0;

    private int count = 0;

    /**
     *
     * @return
     */
    public double average() {
        return count > 0 ? ((double) sum) / count : 0;
    }

    /**
     *
     * @param value
     */
    @Override
    public void accept(int value) {
        sum += value;
        count++;
    }

    /**
     *
     * @param other
     */
    public void combine(Averager other) {
        sum += other.sum;
        count += other.count;
    }

}
