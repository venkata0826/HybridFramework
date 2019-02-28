package dataprovider;

import java.io.FileNotFoundException;

import com.crm.qa.DataUtilities.JsonReaderHelper;
import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.LoginPageTest;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class JSON_data_provider extends TestBase {
	
	public static JsonReaderHelper jsonReader;
	
	@org.testng.annotations.DataProvider(name="jsonRead")
    public static Object[][] jsonReader() throws JsonIOException, JsonSyntaxException, FileNotFoundException
    {
		String Json_Path ="C:\\Users\\Harish\\Documents\\Workspace\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\Registration.json";
           // return jsonReader.getdata(System.getProperty("user.dir") + "/src/test/resources/data/TestData_Registration.json", LoginPageTest.testName);
            return jsonReader.getdata(Json_Path, "ScenarioTest1");

    }
	
	@org.testng.annotations.DataProvider(name="JsonE2E")
    public static Object[][] jsonRegistrationE2E() throws JsonIOException, JsonSyntaxException, FileNotFoundException
    {
		String Json_Path ="C:\\Users\\Harish\\Documents\\Workspace\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\Registration.json";
           // return jsonReader.getdata(System.getProperty("user.dir") + "/src/test/resources/data/TestData_Registration.json", LoginPageTest.testName);
            return jsonReader.getdata(Json_Path, "ScenarioTest2");

    }
	
	@org.testng.annotations.DataProvider(name="JsonSingleUser")
    public static Object[][] jsonRegistrationSingleUser() throws JsonIOException, JsonSyntaxException, FileNotFoundException
    {
		String Json_Path ="C:\\Users\\Harish\\Documents\\Workspace\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\Registration.json";
           // return jsonReader.getdata(System.getProperty("user.dir") + "/src/test/resources/data/TestData_Registration.json", LoginPageTest.testName);
            return jsonReader.getdata(Json_Path, "ScenarioTest3");

    }

}
