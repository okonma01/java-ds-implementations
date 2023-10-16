package lab3;

import java.util.Iterator;
import java.util.*;
import java.lang.annotation.*;

public class YorkLinkedList<E> implements List<E> {

	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}

	///////////////////////////////////////////

	/**
	 * Need to use the variable head to refer to the first node in the list, and the
	 * variable tail to the last node.
	 * 
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private Node<E> head, tail;
	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/////////////////////////////////////////

	public YorkLinkedList() {
		// TODO: Your implementation of this method starts here
	}

	public YorkLinkedList(E[] objects) {
		// TODO: Your implementation of this method starts here
		this();
		for (E obj : objects) {
			addLast(obj);
		}
	}

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		return size == 0;

	}

	/**
	 * Add the newly created node to the beginning of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)")
	public void addFirst(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> headNode = new Node<E>(e); // O(1)
		if (isEmpty()) { // O(1)
			headNode.next = null; // O(1)
			tail = headNode; // O(1)
		}
		else { // O(1)
			headNode.next = head; // O(1)
		}
		head = headNode; // O(1)
		size++; // O(1)
	}

	/**
	 * return the element stored inside the first node of this list the method
	 * return null if this list is empty
	 * 
	 * @return
	 */
	public E getFirst() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		else {			
			return head.element;
		}
	}

	/**
	 * Add the newly created node to the end of this list
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 */
	@TimeComplexity(value = "O(1)")
	public void addLast(E e) {
		// TODO: Your implementation of this method starts here
		Node<E> tailNode = new Node<E>(e); // O(1)
		tailNode.next = null; // O(1)
		if (isEmpty()) { // O(1)
			head = tailNode; // O(1)
		}
		else { // O(1)
			tail.next = tailNode; // O(1)
		}
		tail = tailNode; // O(1)
		size++; // O(1)
	}

	/**
	 * Return the last element stored inside the last node in this list if the list
	 * is empty returns null.
	 * 
	 * 
	 * @return
	 */
	public E getLast() {
		// TODO: Your implementation of this method starts here
		if (isEmpty()) {
			return null;
		}
		else {			
			return tail.element;
		}
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}
		int j = 0; // O(1)
		Node<E> node = head; // O(1)
		do { // O(n)
			if (j == i) { // O(1)
				return node.element; // O(1)
			}
			else { // O(1)
				j++; // O(1)
				node = node.next; // O(1)
			}
		} while(node != null); // O(n)

		return null; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}
		Node<E> newNode = new Node<E>(e); // O(1)
		int j = 0; // O(1)
		Node<E> node = head; // O(1)
		do { // O(n)
			if (j == i-1) { // O(1)
				Node<E> temp = node.next; // O(1)
				newNode.next = node.next.next; // O(1)
				node.next = newNode; // O(1)
				return temp.element; // O(1)
			}
			else {
				j++; // O(1)
				node = node.next; // O(1)
			}
		} while(node != null); // O(n)
		
		return null; // O(1)

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		if (i == 0) { // O(1)
			addFirst(e); // O(1)
		}
		else if (i >= size) { // O(1)
			addLast(e); // O(1)
		}
		else { // O(1)
			Node<E> newNode = new Node<E>(e); // O(1)
			int j = 0; // O(1)
			Node<E> node = head; // O(1)
			do { // O(n)
				if (j == i-1) { // O(1)
					newNode.next = node.next; // O(1)
					node.next = newNode; // O(1)
					size++; // O(1)
					break; // O(1)
				}
				else { // O(1)
					j++; // O(1)
					node = node.next; // O(1)
				}
			} while(node != null); // O(n)
		}
	}

	/**
	 * Remove the first node and then return the element stored inside this node the
	 * method return null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(1)")
	public E removeFirst() {
		// TODO: Your implementation of this method starts here
		if(isEmpty()) { // O(1)	
			return null; // O(1)
		}
		Node<E> temp = new Node<E>(head.element); // O(1)
		head = head.next; // O(1)
		size--; // O(1)
		return temp.element; // O(1)
	}

	/**
	 * Remove the last node in this list then return the element stored inside the
	 * last node. the method returns null if this list is empty
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	public E removeLast() {
		// TODO: Your implementation of this method starts here
		if(isEmpty()) { // O(1)		
			return null; // O(1)
		}
		if (size == 1) { // O(1)
			return removeFirst(); // O(1)
		}
		else { // O(1)
			Node<E> node = head; // O(1)
			E elem = null; // O(1)
			do { // O(n)
				if (node.next.next == null) { // O(1)
					elem = node.next.element; // O(1)
					node.next = null; // O(1)
					tail = node; // O(1)
					size--; // O(1)
					break; // O(1)
				}
				else { // O(1)
					node = node.next; // O(1)
				}
			} while(node != null); // O(n)
			return elem; // O(1)
		}
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if (i < 0 || i >= size) { // O(1)
			throw new IndexOutOfBoundsException(); // O(1)
		}
		if (i == 0) { // O(1)
			removeFirst(); // O(1)
		}
		else if (i == size-1) { // O(1)
			removeLast(); // O(n)
		}
		else { // O(1)
			Node<E> node = head; // O(1)
			int j = 0; // O(1)
			do { // O(n)
				if (j == i-1) { // O(1)
					Node<E> temp = node.next; // O(1)
					node.next = node.next.next; // O(1)
					size--; // O(1)
					return temp.element; // O(1)
				}
				else { // O(1)
					j++; // O(1)
					node = node.next; // O(1)
				}
			} while(node != null); // O(n)
		}
		return null; // O(1)
	}

	/**
	 * 
	 * Search this list and return the first match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the lowest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * @param e
	 * @return
	 */
	public int indexOf(E e) {
		// TODO: Your implementation of this method starts here
		if (!isEmpty()) {			
			Node<E> node = head;
			int j = 0;
			do {
				if (node.element.equals(e)) {
					return j;
				}
				j++;
				node = node.next;
			} while(node != null);
		}
		return -1;
	}

	/**
	 * Search this list and return the last match index. If this list does not
	 * contain the element, it is unchanged and return -1 . More formally, returns
	 * the the largest index {@code i} such that {@code equals(e, get(i))} (if such
	 * an element exists). Returns {@code i} if this list contained the specified
	 * element .
	 * 
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 * 
	 * @param e
	 * @return
	 */
	@TimeComplexity(value = "O(n)")
	public int lastIndexOf(E e) {
		// TODO: Your implementation of this method starts here
		int res = -1; // O(1)
		if (!isEmpty()) {	 // O(1)		
			Node<E> node = head; // O(1)
			int j = 0; // O(1)
			do { // O(n)
				if (node.element.equals(e)) { // O(1)
					res = j; // O(1)
				}
				j++; // O(1)
				node = node.next; // O(1)
			} while(node != null); // O(n)
		}
		return res; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) { // O(1)
			throw new NullPointerException(); // O(1)
		}
		Node<E> node = head; // O(1)
		do { // O(n)
			if (e.equals(node.element)) { // O(1)
				return true; // O(1)
			}
			else { // O(1)
				node = node.next; // O(1)
			}
		} while (node != null); // O(n)
		return false; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^2)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if (e == null) { // O(1)
			throw new NullPointerException(); // O(1)
		}
		Node<E> node = head; // O(1)
		int j = 0; // O(1)
		do { // O(n)
			if (e.equals(node.element)) { // O(1)
				remove(j); // O(n)
				return true; // O(1)
			}
			else { // O(1)
				j++; // O(1)
				node = node.next; // O(1)
			}
		} while(node != null); // O(n)
		
		return false; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n)")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean res = false; // O(1)
		if (otherList == null || otherList.contains(null)) { // O(n)
			throw new NullPointerException(); // O(1)
		}
		for (E obj : otherList) { // O(n)
			addLast(obj); // O(1)
			res = true; // O(1)
		}
		return res; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^4)")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean res = false; // O(1)
		if (otherList == null || otherList.contains(null)) { // O(n)
			throw new NullPointerException(); // O(1)
		}
		if (!isEmpty()) { // O(1)
			Node<E> node = head; // O(1)
			do { // O(n)
				if (otherList.contains(node.element)) { // O(n)
					res = res || remove(node.element); // O(n^2)
				}
				node = node.next; // O(1)
			} while (node.next != null); // O(n)
		}

		return res; // O(1)
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity).
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(n^4)")
	@Override
	public boolean retainAll(List<E> otherList) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		boolean res = false; // O(1)
		if (otherList == null || otherList.contains(null)) { // O(n)
			throw new NullPointerException(); // O(1)
		}
		if (!isEmpty()) { // O(1)
			Node<E> node = head; // O(1)
			do { // O(n)
				if (!otherList.contains(node.element)) { // O(n)
					res = res || remove(node.element); // O(n^2)
				}
				node = node.next; // O(1)
			} while (node.next != null); // O(n)
		}
		return res; // O(1)
	}


	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
		// TODO: Your implementation of this method starts here
		String res = "[";
		if (!isEmpty()) {
			Node<E> node = head;
			do {
				res = res.concat(node.element.toString());
				if (node.next != null) {					
					res = res.concat(", ");
				}
				node = node.next;
			} while (node != null);
		}
		return res.concat("]");
	}
	
	private void unlink(int i) {
		remove(i);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO: Your implementation of this method starts here
		return new LinkedListIterator();

	}
	
	private class LinkedListIterator implements Iterator<E> {
		Node<E> node = head;
		E elem = node.element;
		E lastReturned = null;
		int index = -1;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			lastReturned = null;
			return node != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			
			elem = node.element;
			node = node.next;
			index++;
			lastReturned = elem;
			return elem;
		}
		
		@Override
		public void remove() throws IllegalStateException {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}
			unlink(index);
		}
		
	}



}
