import java.util.Date;
import java.text.SimpleDateFormat;
public class HelloDate2 {
	public static void main(String[] args) {
		
		System.out.print("Witaj! Teraz jest ");
		String pattern = "yyyy.MM.dd HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		
		
	}
}
