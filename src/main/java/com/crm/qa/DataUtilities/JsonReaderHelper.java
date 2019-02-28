package com.crm.qa.DataUtilities;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonReaderHelper {
	
	
	
	
	public static Object[][] getdata(String Json_Path, String typeData)throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj = jsonParser.parse(new FileReader(Json_Path)).getAsJsonObject();
         JsonArray array = (JsonArray) jsonObj.get(typeData);
         System.out.println("The Json arraySize is "+array.size()+" and the value of array is "+array);
         return searchJsonElemnet(array);
		
	}
	
	
	public static Object[][] searchJsonElemnet(JsonArray jsonArray) throws NullPointerException
    {

        int totalDataRow=jsonArray.size();
        JsonElement element=jsonArray.get(0);
        Set<String> set=element.getAsJsonObject().keySet();
        int totalColumnEntry= set.size();

        Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
        int i =0;
        int j = 0;



        for (JsonElement jsonElement : jsonArray)
        {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet())
            {

                matrix[i][j] = entry.getValue().toString().replace("\"","");
                j++;
            }
            i++;
            j = 0;
        }
        return matrix;
    }
	
	
	public static String getJsonElementData(String JsonContent,String var)
    {
        JsonObject jsonObject = new JsonParser().parse(JsonContent).getAsJsonObject();

        String value = jsonObject.get(var).getAsString();
        return value;
    }
	
	
	public static String[] getJsonArrayData(String JsonContent,String typeName, String var)
    {


        JsonObject jsonObject = new JsonParser().parse(JsonContent).getAsJsonObject();

        JsonArray arr = jsonObject.getAsJsonArray(typeName);
        String[]data=new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
             data[i] = arr.get(i).getAsJsonObject().get(var).getAsString();

        }

        return data;
    }
	
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		String Json_Path ="C:\\Users\\Harish\\Documents\\Workspace\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\Registration.json";
		getdata(Json_Path, "ScenarioTest3");
	    
	
	}

}
