import java.io.InputStreamReader;
import java.util.Scanner;
public class Fibo {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez une valeur:");
            int n = sc.nextInt();
            sc.nextLine();
            for(int i = 1 ; i <= n ; i++)
                System.out.println( "Fibo de "+ i + " = " + fib(i));
        }
        private static int fib(int n) {
            if (n <= 1) return n;
            else return fib(n-1) + fib(n-2);
        }
    }

