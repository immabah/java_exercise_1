import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }
    @Override
    public boolean run(Scanner cmd) {
        System.out.println("Entrez un nombre :");
        System.out.println(fibo(cmd.nextInt()));
        cmd.nextLine();

        return false;
    }
    private static int fibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre est négatif");
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}