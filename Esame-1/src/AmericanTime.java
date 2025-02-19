public class AmericanTime extends AbstractTime {

	public AmericanTime(int secondsFromStartOfDay) {
		super(secondsFromStartOfDay);
	}

	public final Time next() {
		// completate
		Time time = new AmericanTime((getSecondsFromStartOfDay() + 1) % SECONDS_IN_ONE_DAY);
		return time;
	}

	// restituisce una stringa che rappresenta un Time all'americana (am/pm)
	public String toString() {
		// completate
		int hours = getSecondsFromStartOfDay() / 3600;
		int minutes = (getSecondsFromStartOfDay() % 3600) / 60;	//getSecondsFromStartOfDay() / 60 % 60
		int seconds = getSecondsFromStartOfDay() % 60;

		if (hours == 0)
			return String.format("12:%02d:%02dam", minutes, seconds);
		else if (hours < 12)
			return String.format("%02d:%02d:%02dam", hours, minutes, seconds);
		else if (hours == 12)
			return String.format("12:%02d:%02dpm", minutes, seconds);
		else
			return String.format("%02d:%02d:%02dpm", (hours - 12), minutes, seconds);
	}
}