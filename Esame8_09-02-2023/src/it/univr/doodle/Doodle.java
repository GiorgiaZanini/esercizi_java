package it.univr.doodle;

import java.util.*;

public class Doodle {
	// per ogni persona, dice in quali slot temporali è disponibile
	private final Map<Person, Set<Slot>> availabilities = new HashMap<>();
	//private Set<Slot> w = new TreeSet<>();

	// aggiunge gli slot temporali "when" a quelli disponibili per person
	public void available(Person person, Slot... when) {
		//
		Set<Slot> w = new TreeSet<>();	// classi concrete
										// HashSet<>(); -> non ordinato, più veloce
										// TreeSet<>(); -> ordinato	-> prende l'equals e il comare to dell'oggetto passato
										//							   o prende in input il Comparator<? super E>
		// Set<Slot> w = new TreeSet<>(List.of(when));
		/*
		for (int i = 0; i < when.length; i++) {
			w.add(when[i]);
		}
		*/
		// w.addAll(Arrays.asList(when));	// addAll(Collection<? extends Slot> collection)	boolean
		Collections.addAll(w, when);
		availabilities.put(person, w);
	}

	// aggiunge gli slot temporali "when" a quelli disponibili per person
	public void available(Person person, Iterable<Slot> when) {
		//
		//Set<Slot> w = new TreeSet<>();

		if (availabilities.get(person) == null) {
			Set<Slot> w = new TreeSet<>();

			while (when.iterator().hasNext())
				w.add(when.iterator().next());

			availabilities.put(person, w);
		} else {
			//w = availabilities.get(person);
			while (when.iterator().hasNext())
				//w.add(when.iterator().next());
				availabilities.get(person).add(when.iterator().next());	// get -> restituidce puntatore al Set,
																		// 		  aggiorno il Set che stà gia nella mappa

			//availabilities.put(person, w);
		}
	}

	// costruisce una tabella come negli esempi del compito:
	// nella prima riga tutti gli slot temporali in "availabilities",
	// in ordine crescente;
	// poi le disponibilità di ciascuna persona in "availabilities"
	// poi la priorità di ciascuno slot temporale (somma delle priorità di
	// chi può partecipare), con un asterisco a lato del primo slot
	// con priorità massima
	public String toString() {
		String result = "";
		//
		// Slot disponibili tra tutte le persone
		Set<Slot> wAll = new TreeSet<>();
        Set<Person> persone = new TreeSet<>(availabilities.keySet());    // insieme ordinato delle persone
        for (Person person : persone) {
			wAll.addAll(availabilities.get(person));
		}
		for (Slot slot : wAll)
			result += slot.toString() + "\t";

		// lista disponibilità della persona per ogni slot
		ArrayList<Integer> disponibilita = new ArrayList<>();	// per passaggio successivo
		Integer counterDisponibilita;	// per passaggio successivo

		for (Person person : persone) {
			counterDisponibilita = 0;	// per passaggio successivo
			result += "\n";

			for (Slot slot : wAll) {
				result += "\t";
				if (availabilities.get(person).contains(slot)) {
					result += "yes";
					counterDisponibilita += priority(person);
				} else {
					result += "no";
				}
				result += "\t\t\t\t";
			}

			result = result.trim();
			result += "\t" + person;
			disponibilita.add(counterDisponibilita);
		}

		// conteggi disponibilità, con '*' sulla maggiore
		int max = 0;
		for (Integer dispMax : disponibilita) {
			if (dispMax > max)
				max = dispMax;
		}

		result += "\n";
		for (Integer disp : disponibilita) {
			result += "\t" + disp;
			if (disp.equals(max))
				result += "*";
			result += "\t\t\t\t";
		}

		// return
		return result.trim() + "\n";
	}

	protected int priority(Person person) {
		return 1; // non modificate: per default i doodle danno a tutti la stessa priorità (1)
	}
}
