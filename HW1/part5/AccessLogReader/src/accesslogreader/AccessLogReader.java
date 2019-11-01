/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesslogreader;
import com.mongodb.client.*;
import java.io.*;
import java.util.*;
import org.bson.*;
/**
 *
 * @author mineryang
 */
public class AccessLogReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongo = MongoClients.create();
        MongoDatabase db = mongo.getDatabase("WebLog");
        MongoCollection<Document> collection = db.getCollection("access");

        File file = new File("/Users/mineryang/Desktop/access.log");
        BufferedReader reader = null;
//        List<String> head = new ArrayList<>();
//        head.add("UserID");
//        head.add("MovieID");
//        head.add("Tag");
//        head.add("Timestamp");
        List<Document> docs = new ArrayList<>();
        
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {
                Document doc = new Document();
                
                String[] split = tempString.split(" ");
                int length = split.length;
                String ip=split[0];
                String[] timeData= split[3].split("/|:");
                String month=timeData[1];
                String year=timeData[2];
                
                doc.put("ip",ip);
                doc.put("year",year);
                doc.put("month",month);
                doc.put("log", tempString);
           
                docs.add(doc);
            }
            reader.close();
            //insert documents into collection 
            collection.insertMany(docs);
        } catch (IOException e) {
            e.printStackTrace(); 
       }
    }
    
}
