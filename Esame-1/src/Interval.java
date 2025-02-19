import java.util.Iterator;

// un intervallo di tempo, da un istante iniziale
// in avanti, per un certo numero di secondi
public class Interval implements Iterable<Time> {
	// completare
	private Time start;
	private int howManySeconds;

	// crea un internal da start (incluso) a start + howManySeconds (escluso)
	// lancia IllegalArgumentException se howManySeconds è negativo
	public Interval(Time start, int howManySeconds) {
		// completate
		if (howManySeconds < 0)
			throw new IllegalArgumentException();
		this.howManySeconds = howManySeconds;
		this.start = start;
	}

	// l'iteratore deve generare gli istanti
	// da start (incluso) a start + howManySeconds (escluso)
	@Override
	public Iterator<Time> iterator() {
		// completate
		return new Iterator<Time>() {
			int counter = 0;
			Time next = start;

			@Override
			public boolean hasNext() {
				return counter < howManySeconds;
			}

			@Override
			public Time next() {
				Time result = next;
				next = next.next();
				counter++;
				return result;
			}
		};
	}
}