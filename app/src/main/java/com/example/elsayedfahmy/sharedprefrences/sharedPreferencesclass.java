package com.example.elsayedfahmy.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by elsayed fahmy on 16/12/2016.
 */

public class sharedPreferencesclass  {
    private SharedPreferences sharedPreferences;
    public sharedPreferencesclass(Context context) {
        sharedPreferences = context.getSharedPreferences("shareddata",Context.MODE_PRIVATE);
    }

    public void saveData(String name,String id) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        prefsEditor.putString("name",name);
        prefsEditor.putString("id",id);
        prefsEditor.commit();
    }


    public String getData() {
        if (sharedPreferences!= null) {
            String Default="NA";
            String name=sharedPreferences.getString("name",Default);
            String id=sharedPreferences.getString("id",Default);
         //   if (name.equals(Default)||id.equals(Default))
          //  {return "No data found";}
            return "name = "+name +" , "+"id = "+id;
        }
        return "No data found";
    }

// if you want write and read by key value
    public void saveData_by_key(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public String getData_by_key(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "NA");
        }
        return "No data found";
    }

}

