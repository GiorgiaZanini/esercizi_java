package it.univr.corso;

public class StudenteIllegaleException extends IllegalArgumentException {
	public StudenteIllegaleException() {
		super("studente incompatibile");
	}
	
	public StudenteIllegaleException(String string) {
		super("studente incompatibile: " + string);
	}
}
