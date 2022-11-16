import java.util.InputMismatchException;
import java.util.Scanner;

public class DrawTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj dlugosc boku: ");
		int size = 0;
		try {
		size = scanner.nextInt();
		for(int i = 1; i <= size; i++){
		    for(int j = 1; j <= size-i; j++){
		    System.out.print(" ");
		    }
		    for(int k = 1; k<= 2*i-1; k++){
		        System.out.print("#");
		    }
		System.out.print("\n");
		}
		}catch(InputMismatchException exception) {
			System.out.println("InputMismatchException");
			return;
		}
		if (size < 2) {
			System.out.println("bledny rozmiar");
			return;
		}
	}
}