import java.util.Scanner;

public class DrawSquare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj dlugosc boku: ");
		int dlugosc = scanner.nextInt();
		for (int i = 1; i <= dlugosc; i++) {
            for (int j = 1; j <= dlugosc; j++) {
                if (i == 1 || i == dlugosc)
                    System.out.print("#");
                else if (j == 1 || j == dlugosc)
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

