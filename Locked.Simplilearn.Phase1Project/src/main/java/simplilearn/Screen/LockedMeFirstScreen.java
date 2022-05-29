package simplilearn.Screen;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import simplilearn.Services.LockedMeDisplayService;
import simplilearn.Services.LockedMeStorageService;

public class LockedMeFirstScreen implements LockedMeDisplay {

    private String welcomeText = "Welcome to LockedMe.com";
    private String developerText = "Developer: S Praveen Kumar";

    private ArrayList<String> options = new ArrayList<>();


    public LockedMeFirstScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Exit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.DisplayFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	LockedMeDisplayService.setCurrentScreen(LockedMeDisplayService.LockedMeUserOptions);
                LockedMeDisplayService.getCurrentScreen().Show();
                LockedMeDisplayService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void DisplayFiles() {

       
        System.out.println("List of Files: ");
    	LockedMeStorageService.PrintFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
