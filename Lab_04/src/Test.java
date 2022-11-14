import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) throws MalformedURLException, IOException {
		if (!file1.isFile()) {
	    	File source = new File(args[0]); 
			File destination = new File(args[1]);

			if (!source.exists()) {
				System.out.println("Plik " + source.getName() + " nie istnieje.");
				return;
			}
			if (source.isDirectory()) {
				System.out.println(source.getName() + " jest katalogiem.");
				return;
			}
			if (!source.canRead()) {
				System.out.println("Brak dostępu do pliku " + source.getName() + ".");
				return;
			}
			if (destination.isDirectory()) {
				if (!destination.canWrite()) {
					System.out.println("Brak wymaganych uprawnień do katalogu " + destination.getName() + ".");
					return;
				}
				String filename = String.valueOf(Paths.get(source.getName()).getFileName());
				destination = new File(destination.getName() + "/" + filename);
			}
			
			if (destination.exists() && !destination.canWrite()) {
				System.out.println("Nie można nadpisać pliku " + destination.getName() + ".");
				return;
			}
			try {
	            Files.copy(source.toPath(), destination.toPath(), REPLACE_EXISTING);
	        }
	        catch (IOException exception) {
	            System.out.println("Błąd związany z: " + exception.getMessage());
	            return;
	        }
			return;
	    }

	}

}
