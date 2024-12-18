import it.univr.library.*;

import java.util.Comparator;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		Book jj = new PaperBook("The joy of Java", "John Stack", 2018, Genre.COMPUTING, 557);
		Book cr = new AudioBook("Cappuccetto rosso", "Charles Perrault", 1697, Genre.FICTION, 13);
		Book ps = new AudioBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 1223);
		Book ps2 = new PaperBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 622);
		Book gl = new PaperBook("Sentieri in Lessinia", "Giovanni Gamba", 2015, Genre.GUIDE, 233);
		Book sv = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);
		Book sv2 = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);

		// crea e poi stampa un catalogo con statistiche che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato secondo il compareTo fra i libri
		System.out.println("Ordinamento naturale:\n" + new CatalogWithStatistics(jj, cr, ps, ps2, gl, sv, sv2) + "\n");

		// crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato per autore e, a parita' di autore, secondo il compareTo fra i libri
		Comparator<Book> comparatorAuthor = new Comparator<Book>() {
			@Override
			public int compare(Book thisBook, Book otherBook) {
				if (!(thisBook.getAuthor().equals(otherBook.getAuthor())))
					return thisBook.getAuthor().compareTo(otherBook.getAuthor());
				return thisBook.compareTo(otherBook);
			}
		};
		System.out.println("Ordinamento per autore:\n" + new Catalog(comparatorAuthor, jj, cr, ps, ps2, gl, sv, sv2) + "\n");

		// crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato per anno e, a parita' di anno, secondo il compareTo fra i libri
		Comparator<Book> comparatorYear = new Comparator<Book>() {
			@Override
			public int compare(Book thisBook, Book otherBook) {
				if (thisBook.getYear() != otherBook.getYear()) {
					if (thisBook.getYear() < otherBook.getYear())
						return -1;
					return 1;
				}
				return thisBook.compareTo(otherBook);
			}
		};
		System.out.println("Ordinamento per anno di pubblicazione:\n" + new Catalog(comparatorYear, jj, cr, ps, ps2, gl, sv, sv2) + "\n");

		try {
			new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, -380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new PaperBook("Gli Scala di Verona", null, 2012, Genre.HISTORY, 380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		Catalog oggettoCatalogo = new Catalog(comparatorAuthor, jj, cr, ps, ps2, gl, sv, sv2);
		for (Book book : oggettoCatalogo) {
			//....
			System.out.println(book);
		}
	}
}
