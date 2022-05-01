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

/**
 *
 * @author pierpaolo
 */
public class EsempioFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File dir=new File("resources");
        File newDir=new File("resources/newdir");
        newDir.mkdir();
        System.out.println("Directory: "+dir.isDirectory());
        System.out.println("All files...");
        System.out.println("================");
        File[] listFiles = dir.listFiles();
        for (File file:listFiles) {
            System.out.println(file.getName()+"\t"+file.length()+"\t"+(file.isFile() ? "F" : "D"));
        }
        System.out.println("TXT files...");
        System.out.println("================");
        listFiles = dir.listFiles(new TxtFileFilter());
        for (File file:listFiles) {
            System.out.println(file.getName()+"\t"+file.length()+"\t"+(file.isFile() ? "F" : "D"));
        }
        System.out.println("TXT files...");
        System.out.println("================");
        listFiles = dir.listFiles(new TxtFilenameFilter());
        for (File file:listFiles) {
            System.out.println(file.getName()+"\t"+file.length()+"\t"+(file.isFile() ? "F" : "D"));
        }
        newDir.delete();
    }
    
}
