package it.univr.library;

/**
 * Un libro cartaceo.
 */
public class PaperBook extends Book {

	private int pages = -1;

	/**
	 * Crea un libro cartaceo.
	 * 
	 * @param title il titolo del libro
	 * @param author l'autore del libro
	 * @param year l'anno di pubblicazione del libro
	 * @param genre il genere del libro
	 * @param pages il numero di pagine del libro
	 * @throws IllegalArgumentException se qualche parametro e' null o se pages e' negativo
	 */
	public PaperBook(String title, String author, int year, Genre genre, int pages) {
		super(title, author, year, genre);
		if (pages < 0)
			throw new IllegalArgumentException();
		this.pages = pages;
	}

	/**
	 * Ritorna il numero di pagine del libro.
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * Si comporta come il toString di Book ma aggiunge in fondo il numero
	 * di pagine fra parentesi quadre.
	 */
	@Override
	public String toString() {
		return super.toString() + " [" + pages + " pages]";
	}

	/**
	 * Si comporta come l'equals di Book ma in piu' richiede che other sia un PaperBook.
	 */
	@Override
	public boolean equals(Object other) {
		if (!super.equals(other))
			return false;

		return other instanceof PaperBook;
	}

	/**
	 * Si comporta come il compareTo di Book ma, a parità di titolo, autore e anno,
	 * mette prima i PaperBook e poi gli AudioBook.
	 */
	@Override
	public int compareTo(Book other) {
		if (super.compareTo(other) != 0)
			return super.compareTo(other);

		if (!(other instanceof PaperBook)) {
			return 1;
		}

		if (pages < ((PaperBook) other).pages)
			return -1;
		else if (pages > ((PaperBook) other).pages)
			return 1;
		return 0;
	}
}