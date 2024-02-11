package base;

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
    public static Path propUserLoginDetails(String dataToUse){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + dataToUse + "ttt.properties");
    }

    public static Path propUserB(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "ttt.properties");
    }

    public static Path propBusinessUserA(){
        return resourcePathToLocalPath("properties" + FILEPATHSEPARATOR + "ttt.properties");
    }





}