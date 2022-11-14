import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAndURLCopy {
	public static void main(String[] args) throws IOException {
		if(args.length < 2) {
			System.out.println("podano za malo argumentow");
			return;
		}
	String UrlToCheck = args[0];
	URLConnection conn;
	InputStream in1 = null;
    URL url = null;

    if (!isValidURL(UrlToCheck)) {
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
     try {
         url = new URL(args[0]);
         conn = url.openConnection();
         in1 = conn.getInputStream();
     }
     catch(UnknownHostException e) {
         System.out.println("Podany adres " + url + " jest nieprawidłowy");
         return;
     }
     catch(AccessDeniedException e) {
         System.out.println("Brak dostępu do " + url);
         return;
     }
     try {
         File dstFile = new File(args[1]);
         copy(url,dstFile);
     }
     catch(IOException e) {
         System.out.println("Błąd kopiowania");
         return;
     }
}
	public static void copy(URL in, File out) throws IOException {
        InputStream is = in.openStream();
        OutputStream os = new FileOutputStream(out);
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
    }
	public static boolean isValidURL(String url)
	    {
	        try {
	            new URL(url).toURI();
	            return true;
	        }
	        catch (Exception e) {
	            return false;
	        }
	    }
}
