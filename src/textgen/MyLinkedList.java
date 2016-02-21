package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		
		this.size = 0;
		this.head = new LLNode<E>();
		this.tail = new LLNode<E>();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) {
		// TODO: Implement this method
	
		if(element == null) {
			throw new NullPointerException("Element must not be null");
		}
		LLNode<E> elementAdd = new LLNode<E>(element);
		elementAdd.next = this.tail;
		elementAdd.prev = this.tail.prev;
		this.tail.prev.next = elementAdd;
		this.tail.prev = elementAdd;
		this.size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) {
		// TODO: Implement this method.
		
		if(index< 0 || index > this.size -1 ) {
			throw new IndexOutOfBoundsException("Index over the size");
		}
		LLNode<E> elementGet = this.head;
		for(int i= 0; i<= index; i++) {
			elementGet = elementGet.next;
		}
		return  elementGet.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) {
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Element must not be null");
		}
		
		if(  (index< 0 || index >= size) &&  (size != 0) ) {
			throw new IndexOutOfBoundsException("Add index over the size");
		}
		
		LLNode<E> elementIndex = this.head;
		for(int i= 0; i<= index; i++) {
			elementIndex = elementIndex.next;
		}
		LLNode<E> elementAdd = new LLNode(element);
		
		elementAdd.next = elementIndex;
		elementAdd.prev = elementIndex.prev;
		elementIndex.prev.next= elementAdd;
		elementIndex.prev = elementAdd;
		
		size++;
	}


	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) {

		if(index < 0 || index>= this.size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> elementRemove = this.head;
		for(int i= 0; i<= index; i++) {
			elementRemove = elementRemove.next;
		}
		elementRemove.prev.next = elementRemove.next;
		elementRemove.next.prev = elementRemove.prev;
		elementRemove.prev = null;
		elementRemove.next = null;
		this.size--;
		
		return elementRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) {
		// TODO: Implement this method


		if (index < 0 || index > size - 1 ) {
			throw new IndexOutOfBoundsException("Invalid index input!!");
		}
		if (element == null) {
			throw new NullPointerException("Invalid element input, must be not null!!");
		}
		
		LLNode<E> elementIndex = this.head;
		for(int i= 0; i<= index; i++) {
			elementIndex = elementIndex.next;
		}
		E temp = elementIndex.data;
		elementIndex.data = element;

		return temp;
	}
}
class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	

}
