import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
public class LineCounterPane {
	public static void main(String[] args) throws IOException {
	   String fileName = JOptionPane.showInputDialog("podaj nazwe pliku (txt)");
	   int lines=0;
	   try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String s;
			while((s=reader.readLine())!=null) 
				lines++;			
			System.out.println("Liczba wierszy w pliku "+ fileName+ " wynosi: "+ lines);
			reader.close();
			}catch (FileNotFoundException exception) {
				System.out.println("nie ma pliku");
			}
	}
}