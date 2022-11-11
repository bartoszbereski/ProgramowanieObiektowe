import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("Brak argumentów programu.");
			return;
		}
		String filename = getFilename(args);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		}
		catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
			return;
		}
		String lines;
		int wordCount = 0;
		int lineCount = 0;
		int znaki = 0;
		while((lines = reader.readLine()) != null) {
			lineCount++;
			String words[] = lines.split(" ");
			wordCount += words.length;
			for (String word : words) {
				znaki += word.length();
			}
		}
		reader.close();
		boolean   l = isArg(args, "l"),
				  c = isArg(args, "c"),
				  w = isArg(args, "w");
		if( !(l || c || w) ) 
			l = c = w = true;

		
		if (l) {	
			System.out.println("wierszy: " + lineCount);
		}

		if (c) {
			System.out.println("znaków: " + znaki);
		}

		if (w) {
			System.out.println("słów: " + wordCount);
		}
		
	}
	private static boolean isArg(String[] args, String argToCheck) {
		for (String arg : args) {
			if (!arg.startsWith("-")) {
				continue;
			}
			if (arg.contains(argToCheck)) {
				return true;
			}
		}
		return false;
	}
	private static String getFilename(String[] args) {
		for (String arg : args) {
			if (!arg.startsWith("-")) {
				return arg;
			}
		}
		return null;
	}
}