
public class CommandLineArgument {

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("brak argumentów programu");
		}else {
		System.out.println("liczba argumentow linii polecen: "+ args.length);
		int i = 1;
        for (String arg : args) {
            System.out.println(i++ +"."+ arg);
        	}
		}

}
}
