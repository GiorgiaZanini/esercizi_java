import java.util.Scanner;

public class MainNumbers {
    public static void main(String[] args) {
        System.out.print("inserire un numero non negativo: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(new DecimalNumber(n) + "\n" + new BinaryNumber(n) + "\n" + new BinaryNumberWithParity(n) +
                "\n"+ new OctalNumber(n) + "\n" + new HexNumber(n) + "\n" + new Base58Number(n));
    }
}
