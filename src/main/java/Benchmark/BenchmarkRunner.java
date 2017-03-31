/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.sql.SQLException;

/**
 *
 * @author Frederik
 */
public class BenchmarkRunner {
    
    public static void main(String[] args) throws SQLException {
        PersonData pd = new PersonData();
        MySqlHandler MSH = new MySqlHandler();
        NeoJHandler NJH = new NeoJHandler();
        
        String[] RandomPeople = pd.getPeople();
        long MySqlSumD1 = 0;
        long MySqlSumD2 = 0;
        long MySqlSumD3 = 0;
        long MySqlSumD4 = 0;
        long MySqlSumD5 = 0;
        
        long NeoJSumD1 = 0;
        long NeoJSumD2 = 0;
        long NeoJSumD3 = 0;
        long NeoJSumD4 = 0;
        long NeoJSumD5 = 0;
        
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            MySqlSumD1 += MSH.MySqlQuery(name, 1);
            MySqlSumD2 += MSH.MySqlQuery(name, 2);
            MySqlSumD3 += MSH.MySqlQuery(name, 3);
            MySqlSumD4 += MSH.MySqlQuery(name, 4);
            MySqlSumD5 += MSH.MySqlQuery(name, 5);
            
            NeoJSumD1 += NJH.NeoQuery(name,1);
            NeoJSumD2 += NJH.NeoQuery(name,2);
            NeoJSumD3 += NJH.NeoQuery(name,3);
            NeoJSumD4 += NJH.NeoQuery(name,4);
            NeoJSumD5 += NJH.NeoQuery(name,5);
            
        }
        
        //OUTPUT
        System.out.println("Total time MySql:   " + ((MySqlSumD1 + MySqlSumD2 + MySqlSumD3 + MySqlSumD4 + MySqlSumD5)/1000/60) + " min");
        System.out.println("MySql depth 1:   total: "  + MySqlSumD1 + "  Avg: " + MySqlSumD1/20);
        System.out.println("MySql depth 2:   total: "  + MySqlSumD2 + "  Avg: " + MySqlSumD2/20);
        System.out.println("MySql depth 3:   total: "  + MySqlSumD3 + "  Avg: " + MySqlSumD3/20);
        System.out.println("MySql depth 4:   total: "  + MySqlSumD4 + "  Avg: " + MySqlSumD4/20);
        System.out.println("MySql depth 5:   total: "  + MySqlSumD5 + "  Avg: " + MySqlSumD5/20);
        System.out.println("__________________________________________________");
        System.out.println("Total time NeoJ:   " + ((NeoJSumD1 + NeoJSumD2 + NeoJSumD3 + NeoJSumD4 + NeoJSumD5)/1000/60) + " min");
        System.out.println("NeoJ depth 1:   total: " + NeoJSumD1 + "  Avg: " + NeoJSumD1/20);
        System.out.println("NeoJ depth 2:   total: " + NeoJSumD2 + "  Avg: " + NeoJSumD2/20);
        System.out.println("NeoJ depth 3:   total: " + NeoJSumD3 + "  Avg: " + NeoJSumD3/20);
        System.out.println("NeoJ depth 4:   total: " + NeoJSumD4 + "  Avg: " + NeoJSumD4/20);
        System.out.println("NeoJ depth 5:   total: " + NeoJSumD5 + "  Avg: " + NeoJSumD5/20);
        System.out.println("__________________________________________________");
        System.out.println("END OF BENCHMARK");
    }
    
}
