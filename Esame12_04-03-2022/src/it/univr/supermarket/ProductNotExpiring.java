package it.univr.supermarket;

/**
 * Un prodotto che non scade mai.
 */
public class ProductNotExpiring extends Product {

	// TODO: campi?

	/**
	 * Costruisce un prodotto senza scadenza.
	 * 
	 * @param name il nome del prodotto
	 * @param price il prezzo in euro del prodotto
	 * @throws IllegalArgumentException se name e' null oppure vuota oppure se price e' negativo
	 */
	public ProductNotExpiring(String name, double price) {	// TODO
        super(name, price);
	}

	// TODO

	// non hanno scadenza -> tutto a 0 o false

	@Override
	protected int compareExpiration(Product other) {
		return 0;
	}

	@Override
	public boolean hasExpired(long whenChecked) {
		return false;
	}
}
