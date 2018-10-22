package by.training.zorich.storage.repository.impl;

public class IdGenerator {
	private int id;

	public IdGenerator() {
	}

	public IdGenerator(int startId) {
		this.id = startId - 1;
	}

	public int nextId() {
		return ++id;
	}
}
