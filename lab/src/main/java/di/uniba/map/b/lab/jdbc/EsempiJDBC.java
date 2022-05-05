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
package di.uniba.map.b.lab.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author pierpaolo
 */
public class EsempiJDBC {

    /**
     *
     */
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS store (artId INT PRIMARY KEY, desc VARCHAR(1024), price DOUBLE, unit INTEGER)";

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            //connessione senza parametri
            //Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db");
            //connession con username e password
            //Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db","user","1234");
            //connessione con oggetto Properties
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "1234");
            Connection conn = DriverManager.getConnection("jdbc:h2:./resources/db/store", dbprops);
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("TRUNCATE TABLE store");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO store VALUES (1,'pentola',4.5,20)");
            stm.close();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO store VALUES (?,?,?,?)");
            pstm.setInt(1, 2);
            pstm.setString(2, "piatto");
            pstm.setDouble(3, 1.5);
            pstm.setInt(4, 40);
            pstm.executeUpdate();
            pstm.close();
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT artId, desc FROM store WHERE unit>5");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ": " + rs.getString(2));
            }
            rs.close();
            stm.close();
            pstm = conn.prepareStatement("SELECT artId, desc FROM store WHERE unit>?");
            pstm.setInt(1, 20);
            rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ": " + rs.getString(2));
            }
            rs.close();
            stm.close();
            //DatabaseMetaData metaData = conn.getMetaData();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState() + ": " + ex.getMessage());
        }
    }

}
