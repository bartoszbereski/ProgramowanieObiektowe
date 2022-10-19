public class ArithmeticMean {
	public static void main(String[] args) {
		Integer sum = 0;
		if(args.length == 0) {
			System.out.println("Brak argumentów programu");
		}else {
			System.out.println("srednia arytmetyczna Liczb: " );
			for(int i = 0; i < args.length; i++) {
				System.out.print(args[i]+", ");
				sum = sum + Integer.valueOf(args[i]);
	        }
			int mean = sum/args.length;
			System.out.println("wynosi "+mean);
		}
	}
}