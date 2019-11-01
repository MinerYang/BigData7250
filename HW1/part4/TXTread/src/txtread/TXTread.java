/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txtread;

import com.mongodb.client.*;
import java.io.*;
import java.util.*;
import org.bson.*;

/**
 *
 * @author mineryang
 */
public class TXTread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MongoClient mongo = MongoClients.create();
        MongoDatabase db = mongo.getDatabase("movieLens");
        MongoCollection<Document> collection = db.getCollection("movies");

        File file = new File("/Users/mineryang/Desktop/movies.txt");
        BufferedReader reader = null;
        List<String> head = new ArrayList<>();
        head.add("MovieID");
        head.add("Name");
        head.add("Year");
        head.add("Genres");
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
                    //document.put(head.get(i), split[i]);
                    if(i==0){
                        document.put(head.get(i), split[i]);
                    }
                    //seperate title into name and year
                    else if(i==1){
                        String title=split[i];
                        String[] tsp=title.split("[()]");
                        int len1 =tsp.length;
                        for(int j=0;j<len1;j++){
                            if(j==0){
                                document.put(head.get(1), tsp[j]);
                                System.out.println(head.get(1)+tsp[j]);
                            }
                            else{
                                document.put(head.get(2), tsp[j]);
                                System.out.println(head.get(3)+tsp[j]);
                            }
                        }
                    }
                    
                    //seperate genrestr into a list
                    else if(i==2){
                        String gstr=split[i];
                        String[] gsp=gstr.split("\\|");
                        List<String> gl=new ArrayList();
                        int len2 = gsp.length;
                        for(int k=0;k<len2;k++){
                            gl.add(gsp[k]);
                        }
                        document.put(head.get(3), gl);
                    }
                    
                    
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
