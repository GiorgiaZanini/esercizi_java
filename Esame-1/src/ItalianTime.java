public class ItalianTime extends AbstractTime {

	public ItalianTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		// completate
		Time time = new ItalianTime((getSecondsFromStartOfDay() + 1) % SECONDS_IN_ONE_DAY);
		return time;
	}

	// restituisce una stringa che rappresenta un Time all'italiana
	public String toString() {
		// completate
		int hours = getSecondsFromStartOfDay() / 3600;
		int minutes = getSecondsFromStartOfDay() / 60 % 60;
		int seconds = getSecondsFromStartOfDay() % 60;

		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}