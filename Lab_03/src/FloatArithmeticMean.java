
public class FloatArithmeticMean {
	public static void main(String[] args) {
		Float sum =  (float) 0;		
		if(args.length == 0) {
			System.out.println("Brak argumentów programu");
		}else {
			for(int i = 0; i < args.length; i++) {
				System.out.printf("%10.3f %n", Float.parseFloat(args[i]));
				sum = sum + Float.parseFloat(args[i]);  
	        }
			float mean = (float) sum/args.length;
			System.out.println("----------");
			System.out.printf("%10.3f %n", sum);
			System.out.println();
			System.out.print("srednia arytmetyczna:");
			System.out.printf("%.4f %n", mean);
		}
	}

	}

