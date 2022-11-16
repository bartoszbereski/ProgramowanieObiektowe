import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MultiplicationTable {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
	    File file;
        try {
            file = new File("setup.properties");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return;
        }
        if (!file.exists()) {
    	 prop.setProperty("wartosc_minimum", "1");
         prop.setProperty("wartosc_maximum", "10");
         prop.setProperty("powtorzen_minimum", "10");
         prop.setProperty("powtorzen_maximum", "25");
         prop.setProperty("procent", "70");
         prop.store(new FileWriter("setup.properties"), "Multiplication Table settings");
        }
        FileReader reader = new FileReader(file);
        prop.load(reader);
    }
}
