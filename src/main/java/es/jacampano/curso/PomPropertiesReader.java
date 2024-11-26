package es.juntadeandalucia.devsecops;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PomPropertiesReader {

    //Metodo que crea un fichero
    public static String getVersion(String pomPropertiesPath) throws IOException {
        String version = "";
        try (FileReader fr = new FileReader(new File(pomPropertiesPath))){
            Properties properties = new Properties();
            properties.load(fr);
            version = properties.getProperty("version");
        }
        return version;
    }

   /*
    public static String getVersion(String pomPropertiesPath) {
        String version = "";
        try {
            File pomPropertiesFile = new File(pomPropertiesPath);
            Properties properties = new Properties();
            properties.load(new FileReader(pomPropertiesFile));
            version = properties.getProperty("version");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return version;
    }
    */
}