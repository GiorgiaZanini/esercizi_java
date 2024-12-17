package it.univr.library;

/**
 * Un catalogo che stampa anche statistiche sui libri contenuti.
 */
public class CatalogWithStatistics extends Catalog {

	/**
	 * Costruisce un catalogo con statistiche. L'ordinamento sara' quello del
	 * compareTo definito in Book.
	 * 
	 * @param books i libri contenuti nel catalogo. Anche se ci fossero ripetizioni,
	 *              il catalogo dovra' contenere una sola istanza del libro ripetuto
	 */
	public CatalogWithStatistics(Book... books) {
		super(books);
	}

	/**
	 * Si comprta come il toString() di Catalog, ma alla fine aggiunge una riga del tipo:
	 * "This catalog contains paper books for a total of XXX pages and audiobooks for a total of YYY minutes"
	 */
	@Override
	public String toString() {
		int allPages = 0;
		int allMinutes = 0;

		while (super.iterator().hasNext()) {

			if (super.iterator() instanceof PaperBook)
				allPages += ((PaperBook) super.iterator()).getPages();

			if (super.iterator() instanceof AudioBook)
				allMinutes += ((AudioBook) super.iterator()).getMinutes();

			super.iterator().next();
		}

		return super.toString() + "This catalog contains paper books for a total of " + allPages + "pages and audiobooks for a total of " + allMinutes + " minutes";
	}
}