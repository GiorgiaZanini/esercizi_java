import java.util.Arrays;
import java.util.Scanner;

public class MainNumbersSort {
    public static void main(String[] args) {
        Number[] array = {new DecimalNumber(2024), new BinaryNumber(113), new BinaryNumberWithParity(158),
                new OctalNumber(827), new HexNumber(2066), new Base58Number(8092)};

        Arrays.sort(array); //ordina l’array, secondo il metodo compareTo (ordinamento crescente)
        System.out.println(Arrays.toString(array)); // [1110001, 100111101, 1473, 2024, 812, 3QX]
    }
}