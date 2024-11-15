import java.util.Scanner;

public class IOStream {
    Scanner sc = new Scanner(System.in);

    public String nextLine() {
        return sc.nextLine();
    }

    public int nextInt() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public double nextDouble() {
        double num = sc.nextDouble();
        sc.nextLine();
        return num;
    }

    public boolean nextBoolean(){
        return sc.nextBoolean();
    }
}
