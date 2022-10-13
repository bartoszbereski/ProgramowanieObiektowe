import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
public class HelloDate2 {
	public static void main(String[] args) {
		System.out.print("Witaj! Teraz jest ");
		String pattern = "yyyy-MM-dd HH:mm";
		
		Locale loc = new Locale("en", "US");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		
		//DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
		
		String date = simpleDateFormat.format(new Date());
		
		System.out.println(date);
		
		
		
	}
}
