import java.util.Date;

public class Weekend {
	public static void main (String[] args ) {	
		Date date = new Date();
		int day = date.getDay();
		System.out.print("Liczba dni do weekendu: ");
		System.out.println(6-day);
	}

	
}
