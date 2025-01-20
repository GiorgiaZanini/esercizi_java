package it.univr.doodle;

// si renda questa classe comparabile con un'altra Person:
// ordinando prima per priorita' crescente e poi alfabeticamente per nome
// nota: dovrete aggiungere un metodo public: quale?
public abstract class Person implements Comparable<Person> {
	private final String name;
	
	protected Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {	// deve restituire il nome
		return name;
	}
	
	public abstract int priority();

	@Override
	public boolean equals(Object other) {	// devono avere stesso nome e stessa priorità
		if (other == null)
			return false;
		if (!(other instanceof Person))
			return false;

		return (this.priority() == ((Person) other).priority()) && (this.name.equals(((Person) other).name));
	}

	@Override
	public int compareTo(Person other) {
		if (this.priority() == other.priority())
			return this.name.compareTo(other.name);
		else if (this.priority() > other.priority())
			return 1;
		return -1;
	}
}
