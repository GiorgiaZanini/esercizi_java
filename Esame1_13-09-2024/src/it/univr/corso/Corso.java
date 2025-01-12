package it.univr.corso;

/**
 * Un corso di laurea (per esempio, informatica), con nome e durata in anni.
 */
public class Corso {
	// aggiungete campi se servissero
	private final String nome_corso;
	private final int durata;

	public Corso(String nome, int durata) {
		this.nome_corso = nome;
		this.durata = durata;
	}

	@Override
	public String toString() {
		return nome_corso;
	}

	// aggiungete i metodi accessori pubblici getNome() e getDurata()
	
	public String getNome() {
		return nome_corso;
	}

	public int getDurata() {
		return durata;
	}
}