package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args) throws IOException {
        String propertiesFileLocation = "C:\\Users\\sanem\\development\\selenium-with-java\\AutomationFramework\\src\\test\\java\\configfiles\\config.properties";
        FileReader fileReader = new FileReader(propertiesFileLocation);
        Properties property = new Properties();
        property.load(fileReader);
        System.out.println(property.getProperty("browser"));
        System.out.println(property.getProperty("testurl"));
    }
}