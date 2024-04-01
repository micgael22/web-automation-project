package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class BaseConfiguration extends BaseController {

    public BaseConfiguration() throws MalformedURLException {
    }

    public static Properties setCustomProperties(String sPath){
        try {
            prop = readPropertiesFile(sPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        }
        catch (IOException ep) {
            ep.printStackTrace();
        }
        finally {
            assert fis != null;
            fis.close();
        }
        return prop;
    }

}
