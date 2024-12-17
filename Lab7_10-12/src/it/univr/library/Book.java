package it.univr.library;

import java.util.Comparator;

/**
 * Un libro.
 */
public abstract class Book implements Comparable<Book> {

	private String title = "";
	private String author= "";
	private int year = -1;
	private Genre genre = null;

	/**
	 * Crea un libro.
	 * 
	 * @param title il titolo del libro
	 * @param author l'autore del libro
	 * @param year l'anno di pubblicazione del libro
	 * @param genre il genere del libro
	 * @throws IllegalArgumentException se qualche parametro e' null
	 */
	protected Book(String title, String author, int year, Genre genre) {
		try {
			if (!(title.equals(null)))
				this.title = title;

			if (!(author.equals(null)))
				this.author = author;

			if (year < 0)
				throw new IllegalArgumentException();
			this.year = year;

			if (!(genre.equals(null)))
				this.genre = genre;

		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Restituisce il titolo del libro.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Restituisce l'autore del libro.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Restituisce il genere del libro.
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Restituisce l'anno di pubblicazione del libro.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Ritorna il titolo fra doppi apici seguito dall'autore e poi
	 * (fra parentesi) anno di pubblicazione e genere.
	 */
	@Override
	public String toString() {
		return "\"" + title + "\" by " + author + " (" + year + ", " + genre + ")";
	}

	/**
	 * Due libri sono equals se hanno stesso titolo, autore e anno di pubblicazione.
	 * Il genre non viene preso in considerazione.
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Book))
			return false;

		Book otherBook = (Book) other;
		if (title.equals(otherBook.title) && author.equals(otherBook.author) && (year == otherBook.year))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		// return title.length() + author.length() + year + genre.ordinal();
		return title.hashCode() + author.hashCode() + year + genre.hashCode();
	}

	/**
	 * Due libri sono ordinati per titolo; a parità di titolo, sono ordinati per autore;
	 * a parità anche di autore, sono ordinati per anno di pubblicazione.
	 */
	@Override
	public int compareTo(Book other) {
		if (this.equals(other))
			return 0;

		if (!(title.equals(other.title)))
			return title.compareTo(other.title);

		if (!(author.equals(other.author)))
			return author.compareTo(other.author);

		if (year < other.year)
			return -1;
		return 1;
	}
}