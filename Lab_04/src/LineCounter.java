import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter {
	public static void main(String[] args) throws IOException {
		if (args.length == 0 ) {
			System.out.println("Brak argumentów programu.");
			return;
		}
		int lines = 0;
		String FileName = args[0];	
		try {
		BufferedReader reader = new BufferedReader(new FileReader(FileName));
		String s;
		while((s=reader.readLine())!=null) 
			lines++;
		System.out.println("Liczba wierszy w pliku "+ FileName+ " wynosi: "+ lines);
		reader.close();
		}catch (FileNotFoundException exception) {
			System.out.println("nie ma pliku");
		}
	}
}