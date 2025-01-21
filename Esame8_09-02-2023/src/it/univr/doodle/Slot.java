package it.univr.doodle;

// uno slot temporale
public class Slot implements Comparable<Slot> {
	// giorno, mese, anno e momento del giorno
	private final int year;
	private final int month;
	private final int day;
	private final Moment moment;

	public Slot(int year, int month, int day, Moment moment) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.moment = moment;
	}

	public int compareTo(Slot other) {
		if (this.equals(other))
			return 0;

		if (year == other.year) {
			if (month == other.month) {
				if (day == other.day) {
					if (moment.ordinal() > other.moment.ordinal())
						return 1;
					else
						return -1;
				} else if (day > other.day)
					return 1;
				else
					return -1;
			} else if (month > other.month)
				return 1;
			else
				return -1;
		} else if (year > other.year)
			return 1;
		else
			return -1;
	}

	@Override
	public boolean equals(Object other) {
		// this e other sono uguali se rappresentano lo stesso slot temporale
		if (other == null)
			return false;

		if (!(other instanceof Slot))	// se è null potrebbe andare in errore
			return false;

		Slot otherSlot = (Slot) other;
		return (this.day == otherSlot.day) && (this.month == otherSlot.month) && (this.year == otherSlot.year) && (this.moment.equals(otherSlot.moment));
	}

	@Override
	public int hashCode() {
		// deve essere non banale
		//return (day * 100000000) + (month * 1000000) + (year * 10000) + moment.ordinal();	// 10 00 0000 0 - 10 0000 0 - 1000 0 - 1
		return year ^ month ^ day ^ moment.hashCode();
	}

	@Override
	public String toString() { // completo, non modificatelo
		return day + "/" + month + "/" + year + " " + moment;
	}

	// si ricordi che le enum sono sempre comparabili, quindi
	// hanno un metodo compareTo, inserito dal compilatore;
	// inoltre hanno dei metodi equals e hashCode correttamente
	// definiti dal compilatore
	public enum Moment {
		MORNING,
		AFTERNOON,
		EVENING,
		NIGHT
	}
}
