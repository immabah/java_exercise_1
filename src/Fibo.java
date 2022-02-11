import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }
    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter a number :");
        System.out.println(fibo(scanner.nextInt()));
        scanner.nextLine();

        return false;
    }

    private static int fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Should be positive");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}