package com.example.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.AssetManager;

public class Modals {
public String desc;
public String iurl;
public String phone;
    public Modals(JSONObject object){
        try {
            this.desc = object.getString("desc");
            this.iurl = object.getString("picture");
            this.phone = object.getString("address");
       } catch (JSONException e) {
            e.printStackTrace();
       }
    }
    public ArrayList<Modals> fromJson(Context context) throws IOException, JSONException {
        ArrayList<Modals> modals = new ArrayList<Modals>();
        JSONArray jsonObjects=loadJSONFromAsset(context);
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
               modals.add(new Modals(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
               e.printStackTrace();
            }
       }
       return modals;
 }
	
    public JSONArray loadJSONFromAsset(Context context) throws IOException, JSONException {
        String json = null;
        JSONArray jsonarray=new JSONArray();
        JSONObject jsonobject = null;
        AssetManager manager = context.getAssets();
        InputStream inputstream = manager.open("offers.json");
        int size = inputstream.available();

        byte[] buffer = new byte[size];

        inputstream.read(buffer);

        inputstream.close();

        json = new String(buffer, "UTF-8");
        jsonobject = new JSONObject(json);
        jsonarray.put(jsonobject);
        return jsonarray;

}
	
	
	
}
