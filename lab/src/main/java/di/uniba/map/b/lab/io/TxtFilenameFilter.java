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
package di.uniba.map.b.lab.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author pierpaolo
 */
public class TxtFilenameFilter implements FilenameFilter {

    /**
     *
     * @param arg0
     * @param arg1
     * @return
     */
    @Override
    public boolean accept(File arg0, String arg1) {
        return arg1.endsWith(".txt");
    }

}
