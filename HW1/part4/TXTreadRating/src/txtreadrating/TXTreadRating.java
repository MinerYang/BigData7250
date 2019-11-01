/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txtreadrating;
import com.mongodb.client.*;
import java.io.*;
import java.util.*;
import org.bson.*;
/**
 *
 * @author mineryang
 */
public class TXTreadRating {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongo = MongoClients.create();
        MongoDatabase db = mongo.getDatabase("movieLens");
        MongoCollection<Document> collection = db.getCollection("ratings");

        File file = new File("/Users/mineryang/Desktop/ml-10M100K/rb.test");
        BufferedReader reader = null;
        List<String> head = new ArrayList<>();
        head.add("UserID");
        head.add("MovieID");
        head.add("Rating");
        head.add("Timestamp");
        List<Document> docs = new ArrayList<>();
        
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {
                Document document = new Document();
                String[] split = tempString.split("\\::");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    document.put(head.get(i), split[i]);      
                }
                docs.add(document);
            }
            reader.close();
            //insert documents into collection 
            collection.insertMany(docs);
        } catch (IOException e) {
            e.printStackTrace(); 
       }
    }
    
}
