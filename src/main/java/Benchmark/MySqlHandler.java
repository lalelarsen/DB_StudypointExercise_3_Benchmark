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

    String[] depths = {"select Count(distinct target_node_id) from endorsements"
        + " join persons on (endorsements.source_node_id = persons.id)"
        + " where persons.name = ?", "select Count(distinct target_node_id) from endorsements\n"
        + "join persons on (endorsements.source_node_id = persons.id)\n"
        + "where persons.id in (\n"
        + "    select target_node_id from endorsements\n"
        + "    join persons on (endorsements.source_node_id = persons.id)\n"
        + "    where persons.`name` = ?"
        + ");", "select Count(distinct target_node_id) from endorsements\n"
        + "join persons on (endorsements.source_node_id = persons.id)\n"
        + "where persons.id in(\n"
        + "    select target_node_id from endorsements\n"
        + "    join persons on (endorsements.source_node_id = persons.id)\n"
        + "    where persons.id in (\n"
        + "        select target_node_id from endorsements\n"
        + "        join persons on (endorsements.source_node_id = persons.id)\n"
        + "        where persons.`name` = ?"
        + "    )\n"
        + ");", "select Count(distinct target_node_id) from endorsements\n"
        + "join persons on (endorsements.source_node_id = persons.id)\n"
        + "where persons.id in(\n"
        + "    select target_node_id from endorsements\n"
        + "    join persons on (endorsements.source_node_id = persons.id)\n"
        + "    where persons.id in(\n"
        + "        select target_node_id from endorsements\n"
        + "        join persons on (endorsements.source_node_id = persons.id)\n"
        + "        where persons.id in (\n"
        + "            select target_node_id from endorsements\n"
        + "            join persons on (endorsements.source_node_id = persons.id)\n"
        + "            where persons.`name` = ?"
        + "        )\n"
        + "    )\n"
        + ");", "select target_node_id from endorsements\n"
        + "join persons on (endorsements.source_node_id = persons.id)\n"
        + "where persons.id in(\n"
        + "    select target_node_id from endorsements\n"
        + "    join persons on (endorsements.source_node_id = persons.id)\n"
        + "    where persons.id in(\n"
        + "        select target_node_id from endorsements\n"
        + "        join persons on (endorsements.source_node_id = persons.id)\n"
        + "        where persons.id in(\n"
        + "            select target_node_id from endorsements\n"
        + "            join persons on (endorsements.source_node_id = persons.id)\n"
        + "            where persons.id in (\n"
        + "                select target_node_id from endorsements\n"
        + "                join persons on (endorsements.source_node_id = persons.id)\n"
        + "                where persons.`name` = ?"
        + "            )\n"
        + "        )\n"
        + "    )\n"
        + ");"};

    public MySqlHandler() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/endorsement";
        String user = "lalelarsen";
        String password = "frederik2000";
        con = DriverManager.getConnection(url, user, password);

    }

    public long MySqlQuery(String name, int depth) throws SQLException {
        long startt = System.currentTimeMillis();

        PreparedStatement st = con.prepareStatement(depths[depth-1]);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();

        long endt = System.currentTimeMillis();
        System.out.println(startt);
        System.out.println(endt);
        return endt - startt;
    }

}
