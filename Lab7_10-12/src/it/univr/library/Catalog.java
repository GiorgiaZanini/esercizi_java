package it.univr.library;

import java.util.*;

/**
 * Un catalogo contiene dei libri (senza ripetizioni).
 */
public class Catalog implements Iterable<Book> {

	private final SortedSet<Book> catalog;

	/**
	 * Costruisce un catalogo. L'ordinamento sara' quello del
	 * compareTo definito in Book.
	 * 
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public Catalog(Book... books) {
		catalog = new TreeSet<>();
        Collections.addAll(catalog, books);
	}

	/**
	 * Costruisce un catalogo. L'ordinamento sara' quello del comparatore fornito.
	 * 
	 * @param comparator l'oggetto che determina l'ordine fra due libri
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public Catalog(Comparator<Book> comparator, Book... books) {
		catalog = new TreeSet<>(comparator);
		Collections.addAll(catalog, books);
	}

	@Override
	public Iterator<Book> iterator() {
		return catalog.iterator();
	}

	/**
	 * Restituisce il toString dei libri contenuti in questo catalogo, nel loro ordine,
	 * andando a capo dopo ciascuno di essi.
	 */
	@Override
	public String toString() {
		String string = "";
		for (Book book : catalog)
			string += book + "\n";
		return string;
	}
}
