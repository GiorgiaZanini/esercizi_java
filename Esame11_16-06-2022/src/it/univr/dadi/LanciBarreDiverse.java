package it.univr.dadi;

/**
 * Un tipo speciale di classe Lanci dove le barre degli istogrammi
 * sono stampate usando alternativamente i caratteri *, @ e +
 * (la prima barra usa *, la second @, la terza + e cosi' via
 * ciclicamente).
 */
public class LanciBarreDiverse extends Lanci {

	private String[] simboli = {"*", "@", "+"};

	public LanciBarreDiverse(int quanti, Dado... dadi) {
		// completare
		super(quanti, dadi);
	}

	protected String barra(int i, double frequenza) {
		i = i % 3;
		return simboli[i].repeat((int) frequenza);
	}
}
