package it.univr.supermarket;

/**
 * Un prodotto con un momento di scadenza.
 */
public class ProductWithExpiration extends Product {

	// TODO: campi?
	private long scadenza;

	/**
	 * Costruisce un prodotto con una scadenza.
	 * 
	 * @param name il nome del prodotto
	 * @param price il prezzo in euro del prodotto
	 * @param whenProduced il momento di produzione (millisecondi da 1/1/1970)
	 * @param duration il numero di giorni, successivi all produzione, dopo i quali il prodotto scade
	 * @throws IllegalArgumentException se name e' null oppure vuota oppure se price e' negativo
	 *                                  oppure se whenProduced e' negativo oppure su duration e' negativo
	 */
	public ProductWithExpiration(String name, double price, long whenProduced, int duration) {	// TODO
        super(name, price);
		if (whenProduced < 0 || duration < 0)
			throw new IllegalArgumentException("la scadenza, data da whenProduced e duration, non può essere negativa");
		scadenza = whenProduced + (duration * _24_HOURS);
	}

	// TODO

	@Override
	protected int compareExpiration(Product other) {
		if (!(other instanceof ProductWithExpiration))
			return 0;

		if (this.scadenza > ((ProductWithExpiration) other).scadenza)
			return 1;
		else if (this.scadenza < ((ProductWithExpiration) other).scadenza)
			return -1;
		return 0;
	}

	@Override
	public boolean hasExpired(long whenChecked) {
        return ((whenChecked >= scadenza) || (whenChecked + _24_HOURS) >= scadenza);
    }
}
