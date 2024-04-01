package utilities;

import components.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GeneralModels extends Constants {

    // locate to path [target]
    public static String PATH_TARGET_TESTCLASS = "target" + FILEPATHSEPARATOR + "test-classes";

    public GeneralModels(WebDriver driver) throws MalformedURLException {
        this.driver = driver;
    }

    // LOCATE PATH
    public static Path resourcePathToLocalPath(String resourcePath) {
        String url = PATH_USER_DIR + FILEPATHSEPARATOR + PATH_TARGET_TESTCLASS + FILEPATHSEPARATOR + resourcePath;
        if (url == null) {
            throw new IllegalArgumentException(String.format("CANNOT FIND THE '%s' RESOURCE", resourcePath));
        }
        return Path.of(url);
    }

    // SCREENSHOT ACTION
    public InputStream takeScreenshot(String sActionStepDescription) throws IOException {
        TakesScreenshot screenShot = ((TakesScreenshot)this.driver);
        File SrcFile = screenShot.getScreenshotAs(OutputType.FILE);
        // ADD PATH & AND PROJECT NAME AND FILE PATH SEPARATOR
        String path = PATH_TO_REPORTS + PROJECTNAME.toLowerCase() + FILEPATHSEPARATOR;
        String fileType = ".png";
        String fileWithPath = sActionStepDescription;
        if (fileWithPath == null || fileWithPath.length() == 0){
            String format = "yyyy.MM.dd.HH.mm.ss";
            SimpleDateFormat sdf1 = new SimpleDateFormat(format);
            DateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(TimeZone.getTimeZone("GMT+2"));
            Date today = Calendar.getInstance().getTime();
            String dateToString = df.format(today);
            fileWithPath = "DummyScreenshot_" + dateToString;
        }
        InputStream inputstream = null;
        try{
            File DestFile=new File(path+ fileWithPath + fileType);
            FileUtils.copyFile(SrcFile, DestFile);
            inputstream = new FileInputStream(path+ fileWithPath + fileType);
        }catch (IOException e){
        }
        return inputstream;
    }

}
