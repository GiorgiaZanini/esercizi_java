package it.univr.sudoku;

import java.util.Random;
import java.util.function.IntFunction;

// un sudoku in cui i numeri da 1 a 9 vengono rappresentati con elementi di tipo E
public class Sudoku<E> {

	// le caselle del sudoku: contengono numeri tra 1 e 9,
	// oppure 0, che indica una casella vuota;
	// la casella (0,0) è quella in alto a sinistra;
	// la casella (8,8) è quella in basso a destra
	private final int[][] matrix = new int[9][9];

	// una funzione che dato un numero tra 1 e 9 restituisce
	// l'elemento di tipo E per rappresentare quel numero
	private final IntFunction<E> generator;

	// la dimensione della stampa di un elemento di tipo E:
	// si assume che tutti gli elementi di tipo E abbiano
	// la stessa dimensione di stampa; questa informazione vi
	// risulterà utile quando dovrete stampare le caselle
	// vuote del sudoku, per capire quanti spazi dovete fare
	private final int elementSize;

	public Sudoku(int empty, IntFunction<E> generator) {
		// completare lanciando una IllegalArgumentException se empty
		// non fosse tra 0 e 61 inclusi
		if (empty < 0 || empty > 61)
			throw new IllegalArgumentException("numero caselle vuote non valido");

		this.generator = generator;

		// calcoliamo quanto e' lunga la stampa dell'elemento che rappresenta 1:
		// stiamo assumendo che la stampa di tutti gli elementi abbia la stessa lunghezza
		this.elementSize = generator.apply(1).toString().length();

		// genera un Sudoku casuale completo
		generate();

		// cancella empty caselle a caso (mettendoci 0)
		hide(empty);
	}

	// restituisce una stringa che descrive il sudoku;
	// si tratta della stampa della matrice 9x9,
	// i cui elementi da 1 a 9 vengono prima trasformati
	// nell'oggetto di tipo E corrispondente, usando la funzione generator,
	// e poi trasformati in stringhe;
	// si inseriscano anche le barrette di separazione orizzontale
	// e verticale fra le 9 regioni del sudoku
	public String toString() {
		String result = "";
		// completare
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				if (matrix[i][j] == 0) {
					result += " ".repeat(elementSize);
				} else {
					result += generator.apply(matrix[i][j]);
				}

				if (i == 2 || i == 5)
					result += "|";
			}
			result += "\n";
			if (j == 2 || j == 5)
				result += "-".repeat(9 * elementSize + 2) + "\n";
		}

		return result;
	}

	private final static Random random = new Random();

	// nasconde (cioè pone a 0) esattamente howMany caselle del sudoku,
	// scelte a caso fra quelle che non sono già a 0
	private void hide(int howMany) {
		// completare
		int i;
		int j;
		for (int n = 0; n < howMany; n++) {
			do {
				i = random.nextInt(9);
				j = random.nextInt(9);
			} while (matrix[i][j] == 0);
			matrix[i][j] = 0;
		}
	}

	// genera un sudokSudokuu risolto (già fatto, non dovete modificare nulla)
	private void generate() {
		generate(0, 0);
	}

	// funzione ausiliaria per generare un sudoku risolto (non modificate)
	private boolean generate(int x, int y) {
		int start = random.nextInt(9);
		int nextX = (x + 1) % 9;
		int nextY = (nextX == 0) ? y + 1 : y;

		for (int num = start; num < start + 9; num++) {
			matrix[x][y] = (num % 9) + 1;
			if (isLegal(x, y) && (nextY == 9 || generate(nextX, nextY)))
				return true;
		}

		matrix[x][y] = 0;

		return false;
	}

	// determina se l'elemento alle coordinate x,y è legale (non modificate)
	private boolean isLegal(int x, int y) {
		return isHorizontallyUnique(x, y)
			&& isVerticallyUnique(x, y)
			&& isUniqueInRegion(x, y);
	}

	// determina se l'elemento alle coordinate x,y è unico nella sua riga
	private boolean isHorizontallyUnique(int x, int y) {
		// completare
		for (int i = 0; i <= 8; i++) {
			if (i != x) {
				if (matrix[i][y] == matrix[x][y])
					return false;
			}
		}
		return true;
	}

	// determina se l'elemento alle coordinate x,y è unico nella sua colonna
	private boolean isVerticallyUnique(int x, int y) {
		// completare
		for (int i = 0; i <= 8; i++) {
			if (i != y) {
				if (matrix[x][i] == matrix[x][y])
					return false;
			}
		}
		return true;
	}

	// determina se l'elemento alle coordinate x,y è duplicato nella sua regione
	private boolean isUniqueInRegion(int x, int y) {
		// completare
		/*
		if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {				// 0-2 - 0-2	// prima riga

			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 0 && x <= 2) && (y >= 3 && y <= 5)) {		// 0-2 - 3-5

			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j <= 5; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 0 && x <= 2) && (y >= 6 && y <= 8)) {		// 0-2 - 6-8

			for (int i = 0; i <= 2; i++) {
				for (int j = 6; j <= 8; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 3 && x <= 5) && (y >= 0 && y <= 2)) {		// 3-5 - 0-2	// seconda riga

			for (int i = 3; i <= 5; i++) {
				for (int j = 0; j <= 2; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 3 && x <= 5) && (y >= 3 && y <= 5)) {		// 3-5 - 3-5

			for (int i = 3; i <= 5; i++) {
				for (int j = 3; j <= 5; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 3 && x <= 5) && (y >= 6 && y <= 8)) {		// 3-5 - 6-8

			for (int i = 3; i <= 5; i++) {
				for (int j = 6; j <= 8; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 6 && x <= 8) && (y >= 0 && y <= 2)) {		// 6-8 - 0-2	// terza riga

			for (int i = 6; i <= 8; i++) {
				for (int j = 0; j <= 2; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else if ((x >= 6 && x <= 8) && (y >= 3 && y <= 5)) {		// 6-8 - 3-5

			for (int i = 6; i <= 8; i++) {
				for (int j = 3; j <= 5; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		} else {													// 6-8 - 6-8

			for (int i = 6; i <= 8; i++) {
				for (int j = 6; j <= 8; j++) {
					if (i != x && j != y) {
						if (matrix[i][j] == matrix[x][y])
							return false;
					}
				}
			}

		}

		return true;
		 */

		// determina numero quadrante
		int i = x/3;
		int j = y/3;

		for (int h = 0; h < 3; h++) {
			for (int k = 0; k < 3; k++) {
				if (((i * 3) + h) != x && ((j * 3) + k) != y) {
					if (matrix[(i * 3) + h][(j * 3) + k] == matrix[x][y])	// (i * 3) + h -> cella corrente da controllare nel quadrante i
						return false;
				}
			}
		}
		return true;
	}
}
