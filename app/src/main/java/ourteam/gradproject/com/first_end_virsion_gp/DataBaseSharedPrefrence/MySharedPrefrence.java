package ourteam.gradproject.com.first_end_virsion_gp.DataBaseSharedPrefrence;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by yasser ahmed on 6/13/2018.
 */

public class MySharedPrefrence {
    Context context;
    private static final String MY_PREFS_NAME="statusfilePref",STATUS="status";
    public MySharedPrefrence(Context context){
        this.context=context;
    }

   public void saveoperationstatus(){
       SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
       editor.putString(STATUS, "done");


   }
   public boolean isdone(){
       SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
       String restoredText = prefs.getString(STATUS, null);
       if (restoredText != null&&restoredText.equals("done")) {
           return true;

       }
       return false;
   }
}
