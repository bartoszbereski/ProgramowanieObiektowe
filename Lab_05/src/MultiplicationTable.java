import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

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
		Random rand = new Random();
		int randz = Integer.parseInt((String) prop.get("wartosc_maximum"));
		
        Scanner scanner = new Scanner(System.in);
        int goodans = 0; int questionsCounter = 0; double percent;
        while (true) {
        	int n = rand.nextInt(randz);
    		int m = rand.nextInt(randz);
    		n+=1;m+=1;
        	System.out.print(m+" * "+n+" = ");
            int mul = scanner.nextInt();
            questionsCounter= questionsCounter+1;
            if((m*n) == mul) { goodans=goodans+1; }
            percent = 100*goodans/questionsCounter;
            if(questionsCounter == 25) {break;}
            if(questionsCounter >= 10 ) {
            	if(percent >= 70) {
            		break;}
            	}
            if(goodans/questionsCounter < 70) {continue;}
        }
        System.out.println("procent poprawnych odpowiedzi "+percent+"%");
    }
}
