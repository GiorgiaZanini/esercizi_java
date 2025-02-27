package it.univr.identifiers;

//TODO: fate compilare questa classe

public class SnakeStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore snake-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public SnakeStyleIdentifier(String... words) {
		// TODO
		super(words);
	}

	// come sopra
	public SnakeStyleIdentifier(Iterable<String> words) {
		// TODO
		super(words);
	}

	@Override
	protected String toString(int pos, String word) {
		if (pos == 0)
			return word;
		return "_" + word;
	}

	// costruisce un identificatore snake-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public SnakeStyleIdentifier(MultiWordIdentifier... ids) {
		// TODO
		super(concat(ids));
		//MultiWordIdentifier.concat(ids);
	}

	// restituisce un identificatore camel-style con le stesse parole di this
	public CamelStyleIdentifier toCamelStyle() {
		// TODO
		return new CamelStyleIdentifier(this);
	}
}