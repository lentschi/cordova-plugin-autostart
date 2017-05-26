package com.tonikorin.cordova.plugin.autostart;
 
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import com.tonikorin.cordova.plugin.autostart.AutoStart;
//import android.util.Log;
 
public class AppStarter {

    public static final int BYPASS_USERPRESENT_MODIFICATION = -1;
    
    public void run(Context context, Intent intent, int componentState) {
        // Starting your app...
        //Log.d("Cordova AppStarter", "STARTING APP...");
        SharedPreferences sp = context.getSharedPreferences(AutoStart.PREFS, Context.MODE_PRIVATE);
        String packageName = context.getPackageName();
        String className = sp.getString(AutoStart.CLASS_NAME, "");
        if( !className.equals("") ){
            //Log.d("Cordova AppStarter", className);
            Intent serviceIntent = new Intent();
            serviceIntent.setClassName(context, packageName + "." + className);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	          serviceIntent.putExtra("cdvStartInBackground",true);
            context.startActivity(serviceIntent);
        }
    }
}
