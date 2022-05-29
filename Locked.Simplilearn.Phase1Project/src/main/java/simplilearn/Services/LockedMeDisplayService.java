package simplilearn.Services;

import simplilearn.Screen.LockedMeDisplay;
import simplilearn.Screen.LockedMeFirstScreen;
import simplilearn.Screen.LockedMeUserOptions;

public class LockedMeDisplayService {
	
	public static LockedMeFirstScreen LockedMeFirstScreen = new LockedMeFirstScreen();
    public static LockedMeUserOptions LockedMeUserOptions = new LockedMeUserOptions();
    
    

    public static LockedMeDisplay CurrentScreen = LockedMeFirstScreen;

    
    public static LockedMeDisplay getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(LockedMeDisplay currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    
    
}
