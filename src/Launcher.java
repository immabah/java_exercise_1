public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue");
        java.util.Scanner entre = new java.util.Scanner(System.in);
        System.out.println("Entrez un element");
        String var= entre.nextLine();
        if (var.equals("quit"))
        {
            System.exit(1);
        }
        else{
            System.out.println("Unknown command");

        }
    }
}
