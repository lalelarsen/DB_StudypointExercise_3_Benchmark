//match (p:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p5:Person) where p.name = '' return p5

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.util.HashMap;
import java.util.Map;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import static org.neo4j.driver.v1.Values.parameters;

/**
 *
 * @author emilgras
 */
public class NeoJHandler {
    
    private Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "class"));
    private Session session = driver.session();
    
    String[] depths = {"match (p1:Person)-[:ENDORSES]->(p2:Person) where p1.name = {name} return p2",
        "match (p1:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p3:Person) where p1.name = {name} return p3;",
        "match (p1:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p4:Person) where p1.name = {name} return p4",
        "match (p:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p4:Person) where p.name = {name} return p4",
        "match (p:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p5:Person) where p.name = {name} return p5"
    };
    
    public long NeoQuery(String name, int depth){
        long startT = System.currentTimeMillis();
        
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", name);
        
        StatementResult result = session.run(depths[depth-1], parameters);
        
        long endT = System.currentTimeMillis();
        
        return endT-startT;
    }
    
    public void a() {
        String cypher = "match (p1:Person)-[:ENDORSES]->(p2:Person) where p1.name = {name} return p2";
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", "Jeanie Mountcastle");
        
        StatementResult result = session.run(cypher, parameters);
        
        
        //session.run("CREATE (a:Person {name: {name}, title: {title}})", parameters("name", "Arthur", "title", "King"));

        //StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} "
                //+ "RETURN a.name AS name, a.title AS title",
                //parameters("name", "Arthur"));
        
        while (result.hasNext()) {
            Record record = result.next();
            //System.out.println("Result: " + record.values().get(0).get("name").asString());
            //System.out.println(record.get("name").asString() + " " + record.get("name").asString());
        }

    }
    
    public void b() {
        String cypher = "match (p1:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p3:Person) where p1.name = {name} return p3;";
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", "Jeanie Mountcastle");
        
        StatementResult result = session.run(cypher, parameters);
        
        //session.run("CREATE (a:Person {name: {name}, title: {title}})", parameters("name", "Arthur", "title", "King"));

        //StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} "
                //+ "RETURN a.name AS name, a.title AS title",
                //parameters("name", "Arthur"));

                int count = 0;
        while (result.hasNext()) {
            count++;
            Record record = result.next();
            //System.out.println("Result: " + record.values().get(0).get("name").asString());
            //System.out.println(record.get("name").asString() + " " + record.get("name").asString());
        }
    System.out.println("count: " + count);
   
    }
    
    public void c() {
        String cypher = "match (p1:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p4:Person) where p1.name = {name} return p4";
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", "Jeanie Mountcastle");
        
        StatementResult result = session.run(cypher, parameters);
        
        //session.run("CREATE (a:Person {name: {name}, title: {title}})", parameters("name", "Arthur", "title", "King"));

        //StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} "
                //+ "RETURN a.name AS name, a.title AS title",
                //parameters("name", "Arthur"));
        
                int count = 0;
        while (result.hasNext()) {
            count++;
            Record record = result.next();
            //System.out.println("Result: " + record.values().get(0).get("name").asString());
            //System.out.println(record.get("name").asString() + " " + record.get("name").asString());
        }
        System.out.println("count: " + count);
   
    }
     
    public void d() {
        String cypher = "match (p:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p4:Person) where p.name = {name} return p4";
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", "Jeanie Mountcastle");
        
        StatementResult result = session.run(cypher, parameters);
        
        //session.run("CREATE (a:Person {name: {name}, title: {title}})", parameters("name", "Arthur", "title", "King"));

        //StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} "
                //+ "RETURN a.name AS name, a.title AS title",
                //parameters("name", "Arthur"));
        
        int count = 0;
        while (result.hasNext()) {
            count++;
            Record record = result.next();
            //System.out.println("Result: " + record.values().get(0).get("name").asString());
            //System.out.println(record.get("name").asString() + " " + record.get("name").asString());
        }
        System.out.println("count: " + count);

    }
    
    public void e() {
        String cypher = "match (p:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(p5:Person) where p.name = {name} return p5";
        Map<String, Object> parameters = new HashMap();
        parameters.put("name", "Jeanie Mountcastle");
        
        StatementResult result = session.run(cypher, parameters);
        
        //session.run("CREATE (a:Person {name: {name}, title: {title}})", parameters("name", "Arthur", "title", "King"));

        //StatementResult result = session.run("MATCH (a:Person) WHERE a.name = {name} "
                //+ "RETURN a.name AS name, a.title AS title",
                //parameters("name", "Arthur"));
        
        int count = 0;
        while (result.hasNext()) {
            count++;
            Record record = result.next();
            //System.out.println("Result: " + record.values().get(0).get("name").asString());
            //System.out.println(record.get("name").asString() + " " + record.get("name").asString());
        }
        System.out.println("count: " + count);

    }
    
    
    
}
