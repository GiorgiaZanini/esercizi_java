package it.univr.identifiers;

// TODO: fate compilare questa classe

public class CamelStyleIdentifier extends MultiWordIdentifier {

	// costruisce un identicatore camel-style le cui parole sono quelle indicate;
	// fallisce nelle stesse condizioni del costruttore della superclasse
	public CamelStyleIdentifier(String... words) {
		// TODO
		super(words);
	}

	// come sopra
	public CamelStyleIdentifier(Iterable<String> words) {
		// TODO
		super(words);
	}

	@Override
	protected String toString(int pos, String word) {
		if (pos == 0)
			return word.toLowerCase();
		String string = "";
		Character character;
		for (int i = 0; i < word.length(); i++) {
			character = word.charAt(i);
			if (i == 0)
				string += character.toString().toUpperCase();
			else
				string += character.toString().toLowerCase();
		}
		return string;
	}

	// costruisce un identificatore camel-style le cui parole componenti
	// sono la concatenazione delle parole degli ids
	public CamelStyleIdentifier(MultiWordIdentifier... ids) {
		// TODO
		super(concat(ids));
		//super(MultiWordIdentifier.concat(ids));
	}

	// restituisce un identificatore snake-style con le stesse parole di this
	public SnakeStyleIdentifier toSnakeStyle() {
		// TODO
		return new SnakeStyleIdentifier(this);
	}
}