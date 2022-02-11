import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        List<Command> commands = List.of(
                new Fibo(),
                new Freq(),
                new Quit(),
                new Predict()
        );
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Entrez un element:");
            String comd = scanner.nextLine();
            boolean shouldContinue = false;
            for (var a : commands) {
                if (a.name().equals(comd)) {
                    if (a.run(scanner))
                        return;
                    shouldContinue = true;
                }
            }

            if (!shouldContinue)
                System.out.println("Unknown command");
        } while (true);
    }
}
