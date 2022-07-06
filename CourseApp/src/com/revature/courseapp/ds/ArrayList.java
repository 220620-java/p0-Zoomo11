package com.revature.courseapp.ds;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {

	private T[] array;
	private int size;
	
	public ArrayList() {
		this.array = (T[]) new Object[10];
	}
	
	public ArrayList (T... objects) {
		this.array = objects;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean contains(T value) {
		for (T element : this.array) {
			if (value==null) {
				if (element==null)
					return true;
			} else if (value.equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(T value) {
		this.array[size] = value;
		size++;		
	}

	@Override
	public void addAll(T... values) {
		for (T value : values) {
			this.add(value);
		}
	}

	@Override
	public T get(int index) {
		if (index >= 0 && index < this.size) {
			return this.array[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(T value) {
		for (int i = 0; i < this.size; i++) {
			if (value==null) {
				if (this.array[i]==null)
					return i;
			} else if (value.equals(this.array[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public T remove(T value) {
		int index = this.indexOf(value);
		if (index != -1) {
			return this.remove(index);
		}
		return null;
	}

	@Override
	public T remove(int index) {
		if (index >= 0 && index < this.array.length) {
			T value = this.array[index];
			for (int i=index; i < this.array.length-1; i++) {
				this.array[i] = this.array[i+1];
			}
			this.array[this.array.length-1]=null;
			this.size--;
			return value;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		result = prime * result + Objects.hash(size);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayList other = (ArrayList) obj;
		return Arrays.deepEquals(array, other.array) && size == other.size;
	}
	
	@Override
	public String toString() {
		StringBuilder retString = new StringBuilder("");
		for (int i = 0; i < this.size; i++) {
			retString.append(this.array[i] + "\n");
		}
		return retString.toString();
	}
}
