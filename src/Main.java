import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            Input.input();

            System.out.println("Повторить? (y/n)");
            String repeatInput = scanner.nextLine();

            if (!repeatInput.equals("y")) {
                repeat = false;
            }
        }
    }
}