package it.univr.sudoku;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Main {

	public static void main(String[] args) {
		IntFunction<Integer> integer = new IntFunction<Integer>() {
			@Override
			public Integer apply(int i) {
				return i;
			}
		};

		System.out.println("Un sudoku di interi (1-9) con 61 caselle nascoste");
		System.out.println(new Sudoku<Integer>(61, integer)); // completare
		System.out.println("Un sudoku di interi (1-9) con 0 caselle nascoste");
		System.out.println(new Sudoku<Integer>(0, integer)); // completare
		System.out.println("Un sudoku di caratteri (A-I) con 30 caselle nascoste");
		System.out.println(new Sudoku<Character>(30, i -> (char) ('A'+i-1))); // completare	//A+i-1
		System.out.println("Un sudoku di emoji " + Arrays.toString(Emoji.values()) + " con 20 caselle nascoste");
		System.out.println(new Sudoku<Emoji>(20, i -> Emoji.values()[i-1])); // completare
		System.out.println("Un sudoku di interi (1-9) con 62 caselle nascoste");
		System.out.println(new Sudoku<Integer>(62, integer)); // completare, va in eccezione
	}
}