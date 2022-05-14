/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.swing.esercizi;

import di.uniba.map.b.lab.collection.esercizi.Articolo;
import di.uniba.map.b.lab.collection.esercizi.Utente;
import di.uniba.map.b.lab.collection.esercizi.UtentePrime;
import static di.uniba.map.b.lab.jdbc.EsempiJDBC.CREATE_TABLE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author pierpaolo
 */
public class DBNegozio {

    /**
     *
     */
    public static final String CREATE_TABLE_ARTICLE = "CREATE TABLE IF NOT EXISTS article (artId INT PRIMARY KEY, desc VARCHAR(1024), price DOUBLE, weight DOUBLE)";

    /**
     *
     */
    public static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS `user` (userId INT PRIMARY KEY, username VARCHAR(64), prime BOOLEAN)";

    private static DBNegozio instance;

    private Connection connection;

    private DBNegozio() {

    }

    /**
     *
     * @return
     */
    public static DBNegozio getInstance() {
        if (instance == null) {
            instance = new DBNegozio();
        }
        return instance;
    }

    /**
     *
     * @throws SQLException
     */
    public void connect() throws SQLException {
        Properties dbprops = new Properties();
        dbprops.setProperty("user", "user");
        dbprops.setProperty("password", "1234");
        connection = DriverManager.getConnection("jdbc:h2:./resources/db/store", dbprops);
        Statement stm = connection.createStatement();
        stm.executeUpdate(CREATE_TABLE_ARTICLE);
        stm.close();
        stm = connection.createStatement();
        stm.executeUpdate(CREATE_TABLE_USER);
        stm.close();
    }

    /**
     *
     * @throws SQLException
     */
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     *
     * @param utente
     * @throws SQLException
     */
    public void insertUser(Utente utente) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO `user` VALUES (?,?,?)");
        pstm.setInt(1, utente.getId());
        pstm.setString(2, utente.getUsername());
        if (utente instanceof UtentePrime) {
            pstm.setBoolean(3, true);
        } else {
            pstm.setBoolean(3, false);
        }
        pstm.execute();
        pstm.close();
    }

    /**
     *
     * @param articolo
     * @throws SQLException
     */
    public void insertArticolo(Articolo articolo) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO article VALUES (?,?,?,?)");
        pstm.setInt(1, articolo.getId());
        pstm.setString(2, articolo.getDesc());
        pstm.setDouble(3, articolo.getPrezzo());
        pstm.setDouble(4, articolo.getPeso());
        pstm.execute();
        pstm.close();
    }

    /**
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public List<Articolo> searchArticolo(String query) throws SQLException {
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM article WHERE desc LIKE '%" + query + "%'");
        List<Articolo> list = new ArrayList();
        while (rs.next()) {
            Articolo articolo = new Articolo(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
            list.add(articolo);
        }
        rs.close();
        stm.close();
        return list;
    }

}
