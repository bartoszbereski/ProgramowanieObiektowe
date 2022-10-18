import java.util.Calendar;

public class Weekend2 {
		private final static String days[] = { "poniedzialek", "wtorek","sroda", "czwartek", 
				"piatek"};
		public static void main(String[] args) {
			Calendar c = Calendar.getInstance(); 
			int day = c.get(Calendar.DAY_OF_WEEK);
			/*c.set(Calendar.DAY_OF_WEEK , 6);		//setting custom day of the week  
			day = c.get(Calendar.DAY_OF_WEEK);
			*/
			if (day == 0 || day == 7) {
				System.out.println("Mamy weekend!");	
			}
			else{
				if(day == 5) {
					System.out.println("Dzis "+ days[day-2] +", do weekendu pozostal "+(6-day)+" dzien");	
				}
				else{
					System.out.println("Dzis "+ days[day-2] +", do weekendu pozostalo "+(6-day)+" dni");
				}	
			}			
		}
	}


