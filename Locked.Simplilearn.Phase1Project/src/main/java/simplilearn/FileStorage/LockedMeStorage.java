package simplilearn.FileStorage;

import java.util.ArrayList;

import java.util.Collections;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class LockedMeStorage {

   public static final String Location = "src/main/Reposetory/";

    private ArrayList<File> file = new ArrayList<File>();
    
    Path path = FileSystems.getDefault().getPath(Location).toAbsolutePath();
    
    File RList = path.toFile();
       
    public String getName() {
        return Location;
    }
    
    public void print() {
    	System.out.println("Existing Files: ");
    	file.forEach(f -> System.out.println(f));
    }

    public ArrayList<File> fillFiles() {
    	
        File[] Repo = RList.listFiles();
        
        
        
        file.clear();
    	for (int i = 0; i < Repo.length; i++) {
    		if (Repo[i].isFile()) {
    			file.add(Repo[i]);
    		}
    	}
    	
    	Collections.sort(file);
    	
    	return file;
    }

    public ArrayList<File> getFiles() {
    	
    	fillFiles();
    	return file;
    }
    
    
    public void mergeSort() {
    	
    }
    
}
