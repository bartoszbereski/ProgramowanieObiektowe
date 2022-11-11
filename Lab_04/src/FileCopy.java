import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Nie wystarczajaca ilosc argumentow");
			return;
		}	
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
	}
}