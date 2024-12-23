public class Calendar {
    private final int year; // l'anno del calendario
    private static final int[] daysForMonth = {30, 27, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30}; // ogni cella contiene il numero massimo di giorni per ogni mese, ridotto di 1 (anno non bisestile)

    // costruisce il calendario per l'anno indicato
    public Calendar(int year) {
        this.year = year;
    }

    // determina se il calendario è per un anno bisestile
    public boolean isLeapYear() {
        return year % 4 == 0;
    }

    // restituisce la prima data del calendario (primo gennaio)
    public Date getStart() {

    }

    // restituisce l'ultima data del calendario (31 dicembre)
    public Date getEnd() {

    }

    // classe interna (inner class)
    public class Date {
        // 0 = primo gennaio, 364 = 31 dicembre (per i bisestili: 365 = 31 dicembre)
        private final int daysFromStart;    // giorno nel range da trasformare in data
        private int iMonth; // indice dell'array, corrisponde al mese ridotto di 1 (alla fine del for già giusta)
        private int currentDay;

        private Date(int daysFromStart) {
            this.daysFromStart = daysFromStart;
            rangeDaysForMonth();
        }

        /*
        gennaio ---> 1-31 ---------> 0-30
        febbraio --> 1-28 | 1-29 --> 31-58 | 31-59
        marzo -----> 1-31 ---------> 59-89 | 60-90
        aprile ----> 1-30 ---------> 90-119 | 91-120
        maggio ----> 1-31 ---------> 120-150 | 121-150
        giugno ----> 1-30 ---------> 150-180 | 151-181
        luglio ----> 1-31 ---------> 181-211 | 182-212
        agosto ----> 1-31 ---------> 212-242 | 213-243
        settembre -> 1-30 ---------> 242-272 | 244-273
        ottobre ---> 1-31 ---------> 273-303 | 274-304
        novembre --> 1-30 ---------> 304-333 | 305-334
        dicembre --> 1-31 ---------> 334-364 | 335-365
         */ // tabella mesi-giorni
        private void rangeDaysForMonth() {
            int daysFromStart = this.daysFromStart;
            for (iMonth = 0; iMonth < 12; iMonth++) {
                if (daysFromStart <= daysForMonth[iMonth]) {
                    currentDay = daysFromStart;
                    break;
                }
                daysFromStart -= daysForMonth[iMonth];
                if (iMonth == 1 && isLeapYear())
                    daysFromStart--;
            }
        }

        // ritorna il giorno di questa data, tra 1 e 31
        public int getDay() {
            return currentDay;
        }

        // ritorna il mese di questa data tra 1 e 12
        public int getMonth() {
            return iMonth;
        }

        // ritorna l'anno di questa data
        public int getYear() {
            return year;
        }

        public String toString() {
            return String.format("%d/%d/%d", getDay(), getMonth(), getYear());
        }
    }
}
