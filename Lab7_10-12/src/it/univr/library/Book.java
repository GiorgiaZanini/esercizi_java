package it.univr.library;

/**
 * Un libro.
 */
public abstract class Book implements Comparable<Book> {

	private String title = "";
	private String author = "";
	private int year = -1;
	private final Genre genre;

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
		if (title.equals(null))
			throw new IllegalArgumentException();
		this.title = title;

		if (author.equals(null))
			throw new IllegalArgumentException();
		this.author = author;

		if (year < 0)
			throw new IllegalArgumentException();
		this.year = year;

		if (genre.equals(null))
			throw new IllegalArgumentException();
		this.genre = genre;
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
		return "\"" + title + " - " + author + "\" (" + year + ", " + genre + ")";
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
		return title.length() + author.length() + year + genre.ordinal();	//todo -> rivedere per migliorare
	}

	/**
	 * Due libri sono ordinati per titolo; a parità di titolo, sono ordinati per autore;
	 * a parità anche di autore, sono ordinati per anno di pubblicazione.
	 */
	@Override
	public int compareTo(Book other) {
		if (this.equals(other))
			return 0;

		
	}
}