package Benchmark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Helge
 */
public class MySqlHandler {

    static Connection con = null;

    String[] depths = {
        "select Count(distinct target) from Endorses"
        + " join Person on (Endorses.source = Person.id)"
        + " where Person.name = ?", 
        
        "select Count(distinct target) from Endorses\n"
        + "join Person on (Endorses.source = Person.id)\n"
        + "where Person.id in (\n"
        + "    select target from Endorses\n"
        + "    join Person on (Endorses.source = Person.id)\n"
        + "    where Person.`name` = ?"
        + ");", 
        
        "select Count(distinct target) from Endorses\n"
        + "join Person on (Endorses.source = Person.id)\n"
        + "where Person.id in(\n"
        + "    select target from Endorses\n"
        + "    join Person on (Endorses.source = Person.id)\n"
        + "    where Person.id in (\n"
        + "        select target from Endorses\n"
        + "        join Person on (Endorses.source = Person.id)\n"
        + "        where Person.`name` = ?"
        + "    )\n"
        + ");", 
        
        "select Count(distinct target) from Endorses\n"
        + "join Person on (Endorses.source = Person.id)\n"
        + "where Person.id in(\n"
        + "    select target from Endorses\n"
        + "    join Person on (Endorses.source = Person.id)\n"
        + "    where Person.id in(\n"
        + "        select target from Endorses\n"
        + "        join Person on (Endorses.source = Person.id)\n"
        + "        where Person.id in (\n"
        + "            select target from Endorses\n"
        + "            join Person on (Endorses.source = Person.id)\n"
        + "            where Person.`name` = ?"
        + "        )\n"
        + "    )\n"
        + ");", 
        
        "select target from Endorses\n"
        + "join Person on (Endorses.source = Person.id)\n"
        + "where Person.id in(\n"
        + "    select target from Endorses\n"
        + "    join Person on (Endorses.source = Person.id)\n"
        + "    where Person.id in(\n"
        + "        select target from Endorses\n"
        + "        join Person on (Endorses.source = Person.id)\n"
        + "        where Person.id in(\n"
        + "            select target from Endorses\n"
        + "            join Person on (Endorses.source = Person.id)\n"
        + "            where Person.id in (\n"
        + "                select target from Endorses\n"
        + "                join Person on (Endorses.source = Person.id)\n"
        + "                where Person.`name` = ?"
        + "            )\n"
        + "        )\n"
        + "    )\n"
        + ");"
    };

    public MySqlHandler() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/social_network";
        String user = "root";
        String password = "pwd";
        con = DriverManager.getConnection(url, user, password);
    }

    public long MySqlQuery(String name, int depth) throws SQLException {
        PreparedStatement st = con.prepareStatement(depths[depth-1]);
        st.setString(1, name);
        
        long startt = System.currentTimeMillis();
        
        ResultSet rs = st.executeQuery();

        long endt = System.currentTimeMillis();

        return endt - startt;
    }

}
