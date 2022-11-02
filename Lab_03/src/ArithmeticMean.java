public class ArithmeticMean {
	public static void main(String[] args) {
		Integer sum = 0;
		if(args.length == 0) {
			System.out.println("Brak argumentów programu");
			return;
		}
		else if(args.length == 1) {
			System.out.print("Przekazano tylko jedną wartość: "+ args[0]);
			return;
		}
		int first_element =  Integer.valueOf(args[0]);
		System.out.print("srednia arytmetyczna Liczb: " );
		System.out.print(first_element);
		for(int i = 1; i < args.length; i++) {
			System.out.print(","+args[i]);
			sum = sum + Integer.valueOf(args[i]);
        }
		sum = sum + first_element;
		int mean = sum/args.length;
		int reszta = sum%args.length;
		if(reszta != 0) {
			System.out.println(" wynosi "+mean+",reszta: "+reszta);
			return;
		}
		System.out.println(" wynosi "+mean);
	
	}
}