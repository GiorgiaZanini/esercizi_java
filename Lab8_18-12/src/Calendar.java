import java.util.Iterator;
import java.util.Objects;

public class Calendar implements Iterable<Calendar.Date> {
    private final int year; // l'anno del calendario
    //private static final int[] daysForMonth = {30, 27, 30, 29, 30, 29, 30, 30, 29, 30, 29, 30};
    // ogni cella contiene il numero massimo di giorni per ogni mese, ridotto di 1 (anno non bisestile)
    private static final int[] daysForMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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
        return new Date(0);
    }

    // restituisce l'ultima data del calendario (31 dicembre)
    public Date getEnd() {
        if (isLeapYear())
            return new Date(365);
        return new Date(364);
    }

    @Override
    public Iterator<Calendar.Date> iterator() {
        return new Iterator<Calendar.Date>() {
            private Date date = getStart();
            int day = 0;

            public boolean hasNext() {
                return !date.equals(getEnd());
            }

            public Date next() {
                date = new Date(day);
                day++;
                return date;
            }
        };
    }


    // classe interna (inner class)
    public class Date {
        // 0 = primo gennaio, 364 = 31 dicembre (per i bisestili: 365 = 31 dicembre)
        private final int daysFromStart;    // giorno nel range da trasformare in data
        private int iMonth; // indice dell'array, corrisponde al mese ridotto di 1
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
            int daysFromStart = this.daysFromStart + 1;
            for (iMonth = 0; iMonth < 12; iMonth++) {
                if (isLeapYear() && iMonth == 1) {
                    if (daysFromStart <= daysForMonth[iMonth] + 1) {
                        currentDay = daysFromStart;
                        break;
                    }
                    daysFromStart--;
                } else {
                    if (daysFromStart <= daysForMonth[iMonth]) {
                        currentDay = daysFromStart;
                        break;
                    }
                }
                daysFromStart -= daysForMonth[iMonth];
            }
        }

        // ritorna il giorno di questa data, tra 1 e 31
        public int getDay() {
            return currentDay;
        }

        // ritorna il mese di questa data tra 1 e 12
        public int getMonth() {
            return Math.min(iMonth+1, 12);
        }

        // ritorna l'anno di questa data
        public int getYear() {
            return year;
        }

        public String toString() {
            return String.format("%d/%d/%d", getDay(), getMonth(), getYear());
        }

        @Override
        public boolean equals(Object other) {
             if (!(other instanceof Date))
                 return false;

             return ((Date) other).daysFromStart == this.daysFromStart;
        }
    }
}
