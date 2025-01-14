package it.univr.corso;

import java.io.FileNotFoundException;
import java.util.List;

public class FileComponent extends AbstractComponent {
	// aggiungete campi, se servissero
	private final int size;

	/**
	 * Costruisce una componente di tipo file con il nome indicato
	 * e la dimensione in byte indicata.
	 */
	public FileComponent(String name, int size) {
		super(name);
		this.size = size;
	}

	// implementate sotto i metodi public ancora astratti

	@Override
	public String toString(String nesting) {
		return nesting + getName();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<FileComponent> getFiles() {
		return null;
	}

	@Override
	public String find(String name) throws FileNotFoundException {
		return "";
	}
}