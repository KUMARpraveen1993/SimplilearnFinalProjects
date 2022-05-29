package simplilearn.Services;

import java.io.File;

import simplilearn.FileStorage.LockedMeStorage;



public class LockedMeStorageService {

    private static LockedMeStorage directory = new LockedMeStorage();
    
    public static void PrintFiles() {
    	
    	directory.fillFiles();

        for (File file : LockedMeStorageService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static LockedMeStorage getFileDirectory() {
        return directory;
    }

    public static void setFileDirectory(LockedMeStorage fileDirectory) {
        LockedMeStorageService.directory = fileDirectory;
    }


}
