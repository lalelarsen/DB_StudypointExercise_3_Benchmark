/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 *
 * @author Frederik
 */
public class BenchmarkRunner {
    
    private static DecimalFormat formatter = new DecimalFormat("#0000.00");
    
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
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Depth 1 Processing...");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            NeoJSumD1 += NJH.NeoQuery(name,1);
            MySqlSumD1 += MSH.MySqlQuery(name, 1);       
        }

        System.out.println("\n");
        System.out.println("Results:");
        System.out.println("\n");
        System.out.println("NeoJ depth 1:    total (mill): " + BenchmarkRunner.getMillis(NeoJSumD1) + "  Avg (mill): " + BenchmarkRunner.getMillis(NeoJSumD1/20.0));
        System.out.println("MySql depth 1:   total (mill): "  + BenchmarkRunner.getMillis(MySqlSumD1) + "  Avg (mill): " + BenchmarkRunner.getMillis(MySqlSumD1/20));
        
        
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Depth 2 Processing...");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            NeoJSumD2 += NJH.NeoQuery(name,2);
            MySqlSumD2 += MSH.MySqlQuery(name, 2);
        }
        
        System.out.println("\n");
        System.out.println("Results:");
        System.out.println("\n");
        System.out.println("NeoJ depth 2:    total (mill): " + BenchmarkRunner.getMillis(NeoJSumD2) + "  Avg (mill): " + BenchmarkRunner.getMillis(NeoJSumD2/20.0));
        System.out.println("MySql depth 2:   total (mill): "  + BenchmarkRunner.getMillis(MySqlSumD2) + "  Avg (mill): " + BenchmarkRunner.getMillis(MySqlSumD2/20.0));
        
        
        
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Depth 3 Processing...");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            NeoJSumD3 += NJH.NeoQuery(name,3);
            MySqlSumD3 += MSH.MySqlQuery(name, 3);
        }
        
        System.out.println("\n");
        System.out.println("Results:");
        System.out.println("\n");
        System.out.println("NeoJ depth 3:    total (mill): " + BenchmarkRunner.getMillis(NeoJSumD3) + "  Avg (mill): " + BenchmarkRunner.getMillis(NeoJSumD3/20.0));
        System.out.println("MySql depth 3:   total (mill): "  + BenchmarkRunner.getMillis(MySqlSumD3) + "  Avg (mill): " + BenchmarkRunner.getMillis(MySqlSumD3/20.0));
        
        
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Depth 4 Processing...");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            NeoJSumD4 += (NJH.NeoQuery(name,4));
        }
        
        System.out.println("\n");
        System.out.println("Results:");
        System.out.println("\n");
        System.out.println("NeoJ depth 4:   total (sec): " + BenchmarkRunner.getSeconds(NeoJSumD4) + "  Avg (sec): " + BenchmarkRunner.getSeconds(NeoJSumD4/20.0));
        System.out.println("\n");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            MySqlSumD4 += MSH.MySqlQuery(name, 4) / 1000;
        }
        
        System.out.println("MySql depth 4:   total (sec): "  + formatter.format(MySqlSumD4) + "  Avg (sec): " + formatter.format((MySqlSumD4) /20.0));
        System.out.println("MySql depth 4:   total (min): "  + formatter.format(MySqlSumD4 / 60) + "  Avg (min): " + formatter.format((MySqlSumD4 / 60) / 20));
        
        
        
        
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Depth 5 Processing...");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            NeoJSumD5 += NJH.NeoQuery(name,5);
        }
        
        System.out.println("\n");
        System.out.println("Results:");
        System.out.println("\n");
        System.out.println("NeoJ depth 5:   total (mill): " + BenchmarkRunner.getMillis(NeoJSumD5) + "  Avg (mill): " + BenchmarkRunner.getMillis(NeoJSumD5/20.0));
        System.out.println("\n");
        
        for (int i = 0; i < RandomPeople.length; i++) {
            String name = RandomPeople[i];
            MySqlSumD5 += (MSH.MySqlQuery(name, 5) / 1000);
        }
              
        System.out.println("MySql depth 5:   total (sec): "  + formatter.format(MySqlSumD5) + "  Avg (sec): " + formatter.format(MySqlSumD5/20));
        System.out.println("MySql depth 5:   total (min): "  + formatter.format(MySqlSumD5 / 60) + "  Avg (min): " + formatter.format((MySqlSumD5 / 60) / 20));
        
        
        
        
        
        
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        //OUTPUT
        System.out.println("Total time MySql:   " + (formatter.format(((MySqlSumD1 + MySqlSumD2 + MySqlSumD3)/1000/60) + (MySqlSumD4 + MySqlSumD5) / 60)) + " min");
        System.out.println("Total time NeoJ:   " + (formatter.format(NeoJSumD1 + NeoJSumD2 + NeoJSumD3 + NeoJSumD4 + NeoJSumD5)) + " mill");

        System.out.println("\n");
        System.out.println("__________________________________________________");
        System.out.println("END OF BENCHMARK");
    }
    
    public static String getMillis(double millis) {
        return formatter.format(millis);
    }
    
    public static String getSeconds(double millis) {
        return formatter.format(millis / 1000.0);
    }
    
    public static String getMinutes(double millis) {
        return formatter.format((millis / 1000.0) / 60.0);
    }
    
}
