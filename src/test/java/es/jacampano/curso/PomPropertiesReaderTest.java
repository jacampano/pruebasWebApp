package es.juntadeandalucia.devsecops;
import org.junit.jupiter.api.Test;

import es.juntadeandalucia.devsecops.PomPropertiesReader;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PomPropertiesReaderTest {

    @Test
    public void testGetVersion() {
        String pomPropertiesContent = "#Created by Apache Maven 3.6.3\n" +
                "groupId=es.juntadeandalucia\n" +
                "artifactId=pruebaswebapp\n" +
                "version=0.0.11-SNAPSHOT\n";

        File tempFile = null;
        try {
            tempFile = File.createTempFile("pom", ".properties");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(pomPropertiesContent);
            writer.close();
            String version = PomPropertiesReader.getVersion(tempFile.getAbsolutePath());
            assertEquals("0.0.11-SNAPSHOT", version);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }

    //No conformidad creada test unitario que da error
/*
    @Test
    public void testGetVersionFail() {
        String pomPropertiesContent = "#Created by Apache Maven 3.6.3\n" +
                "groupId=es.juntadeandalucia\n" +
                "artifactId=pruebaswebapp\n" +
                "version=0.0.11-SNAPSHOT\n";

        File tempFile = null;
        try {
            tempFile = File.createTempFile("pom", ".properties");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(pomPropertiesContent);
            writer.close();

            String version = PomPropertiesReader.getVersion(tempFile.getAbsolutePath());

            assertEquals("0.0.12-SNAPSHOT", version);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }
 */
}