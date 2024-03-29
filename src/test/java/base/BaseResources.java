package base;

import components.Constants;
import org.openqa.selenium.WebDriver;
import utilities.GeneralModels;

import java.net.MalformedURLException;
import java.nio.file.Path;

public class BaseResources extends GeneralModels {

    public BaseResources(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    public static String FILEPATHSEPARATOR = System.getProperty("file.separator");

     //GET DATA FROM PROPERTIES FILE
     public static Path swagLabUser(String dataToUse){
         return resourcePathToLocalPath("properties" + Constants.FILEPATHSEPARATOR + dataToUse + ".properties");
     }

    public static Path swagLabUser00(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "/creds.swaglab.user00.properties");
    }

    public static Path swagLabUser01(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "/creds.swaglab.user01.properties");
    }

    public static Path swagLabUser02(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "/creds.swaglab.user02.properties");
    }

    public static Path hrmUser00(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "/creds.hrm.user00.properties");
    }

    public static Path hrmUser01(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "/creds.hrm.user01.properties");
    }





}