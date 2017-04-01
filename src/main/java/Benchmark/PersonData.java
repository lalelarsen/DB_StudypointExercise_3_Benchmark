/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Frederik
 */
public class PersonData {

    static Connection con = null;

    public PersonData() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/social_network";
        String user = "root";
        String password = "pwd";
        con = DriverManager.getConnection(url, user, password);

    }

    public String[] getPeople() throws SQLException {
        String[] list = new String[20];
        String query = "select name from Person";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        ArrayList<String> people = new ArrayList();

        while (rs.next()) {
            people.add(rs.getString(1));            
        }

        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int randomNumber = r.nextInt(people.size());
            rs.next();
            list[i] = people.get(randomNumber);
        }
        
        return list;
    }

}
