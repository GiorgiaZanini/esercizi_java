package it.univr.elezioni;

/**
 * Un partito ha un nome, passato al momento della costruzione.
 */
public class Partito implements Comparable<Partito> {
	private final String nome;

	public Partito(String nome) {
		// completare
		this.nome = nome;
	}

	/**
	 * Determina chi fra this e other viene prima in ordine alfabetico per nome.
	 */
	@Override
	public int compareTo(Partito other) {	// modificare
		if ((this.nome == null) && (other.nome == null))
			return 0;
		else if (other.nome == null)
			return -1;
		else if (this.nome == null)
			return 1;

		return this.nome.compareTo(other.nome);
	}

	// due partiti sono uguali se e solo se hanno nome uguale
	@Override
	public boolean equals(Object other) {	// modificare
		if (this.nome == null || !(other instanceof Partito) || ((Partito) other).nome == null)		// (other == null) coperto da instanceof
			return false;

		return this.nome.equals(((Partito) other).nome);
	}

	@Override
	public int hashCode() {	// modificare in modo che sia non banale
		return nome.hashCode();
	}

	/**
	 * Restituisce il nome del partito.
	 */
	@Override
	public String toString() {	// modificare
		return nome;
	}
}