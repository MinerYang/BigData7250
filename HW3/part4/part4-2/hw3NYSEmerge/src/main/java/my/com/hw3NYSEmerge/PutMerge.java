package my.com.hw3NYSEmerge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class PutMerge {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Configuration conf = new Configuration();
		    FileSystem hdfs  =FileSystem.get(conf);
		    FileSystem local = FileSystem.getLocal(conf);
		    
		    Path inputDir = new Path(args[0]);  // Specify input directory
		    Path hdfsFile = new Path(args[1]);  // Specify output file
		  
		    try {
		      // Get list of local files
		      FileStatus[] inputFiles = local.listStatus(inputDir);
		      // Create HDFS output stream
		      FSDataOutputStream out = hdfs.create(hdfsFile);
		      
		      for (int i=0; i<inputFiles.length; i++) {
		        System.out.println(i+" "+inputFiles[i].getPath().getName());
		        // Open local input stream
		        FSDataInputStream in = local.open(inputFiles[i].getPath());
		        
		        // Copy local file to HDFS
		        byte buffer[] = new byte[256];
		        int bytesRead = 0;
		        //read the header first
		        in.readLine();
		        while( (bytesRead = in.read(buffer)) > 0) {
		            out.write(buffer, 0, bytesRead);
		        }
		        in.close();
		      }
		      out.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }

	}

}
