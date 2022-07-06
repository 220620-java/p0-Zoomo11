	package com.revature.courseapp.ds;

public interface List<T> {

	public int size();
	public boolean contains(T value);
	public void add(T value);
	public void addAll(T... value);
	public T get(int index);
	public int indexOf(T value);
	public T remove(T value);
	public T remove(int index);
}
