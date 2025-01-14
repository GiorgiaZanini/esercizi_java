package it.univr.corso;

import java.io.FileNotFoundException;
import java.util.*;

public class DirectoryComponent extends AbstractComponent {
	// aggiungete campi, se servissero
	private SortedSet<Component> children = new TreeSet<>(
			(thisComponent, otherComponent) -> thisComponent.getName().compareTo(otherComponent.getName()));

	/**
	 * Costruisce una componente di tipo directory con il nome indicato
	 * e le sottocomponenti (figli) indicate.
	 */
	public DirectoryComponent(String name, Component... children) {
        super(name);
        this.children.addAll(Arrays.asList(children));
		//Component c[] = children;
		//Arrays.sort(c);
	}

	// implementate sotto i metodi public ancora astratti

	@Override
	public String toString(String nesting) {
		String string = nesting + getName() + "/";

		for (Component component : children) {
			string += "\n" + component.toString(nesting + "\t");
		}

		return string;
	}

	@Override
	public int size() {
		int size = 100;

		for (Component component : children) {
			if (component instanceof DirectoryComponent)
				size += component.size();

			if (component instanceof FileComponent)
				size += component.size();
		}

		return size;
	}

	@Override
	public List<FileComponent> getFiles() {
		List<FileComponent> list = new LinkedList<>();

		for (Component component : children) {
			if (component instanceof DirectoryComponent) {
				list.addAll(component.getFiles());
				//return list;
			}
			if (component instanceof FileComponent)
				list.add((FileComponent) component);
		}

		return list;
	}

	@Override
	public String find(String name) throws FileNotFoundException {
		for (Component component : getFiles()) {
			if (component.getName().equals(name))
				return this.getName() + "/" + findRecursive(name);
		}

		throw new FileNotFoundException();
	}

	private String findRecursive(String name) {
		String string = "";

		for (Component component : children) {
			if (component instanceof DirectoryComponent) {
				string = ((DirectoryComponent) component).findRecursive(name);
				if (!string.equals(""))
					return component.getName() + "/" + string;
			}
			if (component instanceof FileComponent) {
				if (component.getName().equals(name))
					return component.getName();
			}
		}

		return string;
	}
}