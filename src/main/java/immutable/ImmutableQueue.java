package immutable;

import java.util.NoSuchElementException;

import com.google.gson.Gson;

/**
 * @param <T> the generic type of an item in this queue
 */
public final class ImmutableQueue<T> implements Queue<T> {
	private Node<T> first; // beginning of queue
	private Node<T> last; // end of queue
	private int n; // number of elements on queue

	// helper linked list class
	private static class Node<T> {
		private T item;
		private Node<T> next;
		@SuppressWarnings("rawtypes")
		private Class type;
	}

	/**
	 * Initializes an empty queue.
	 */
	private ImmutableQueue() {
		first = null;
		last = null;
		n = 0;
	}

	public static ImmutableQueue<Object> of(Object... items) {

		ImmutableQueue<Object> of = new ImmutableQueue<Object>();

		of.first = null;
		of.last = null;
		of.n = 0;

		for (int i = 0; i < items.length; i++) {

			Node<Object> oldlast = of.last;
			of.last = new Node<Object>();
			of.last.item = (Object) items[i];
			of.last.next = null;
			of.last.type = items[i].getClass();
			if (of.isEmpty())
				of.first = of.last;
			else
				oldlast.next = of.last;
			of.n++;
		}

		return of;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() {
		return n;
	}

	/**
	 * Adds the item to the copy of this queue.
	 *
	 * @param item the item to add
	 * @return New queue with new T.
	 */
	public ImmutableQueue<T> enQueue(T newItem) {
		ImmutableQueue<T> newQueue = new ImmutableQueue<T>();

		Node<T> current = this.first;
		while (current != null) {
			newQueue.add(newQueue, current.item);
			current = current.next;
		}

		newQueue.add(newQueue, newItem);

		return newQueue;
	}

	private void add(ImmutableQueue<T> queue, T item) {
		Node<T> oldlast = queue.last;
		queue.last = new Node<T>();
		
		// Efficient memory
		queue.last.item = item;
		
		// Providing deep copy 
		//Gson gson = new Gson();
		//queue.last.item = (T) gson.fromJson(gson.toJson(item, item.getClass()), item.getClass());
		
		queue.last.next = null;
		queue.last.type = item.getClass();
		if (queue.isEmpty())
			queue.first = queue.last;
		else
			oldlast.next = queue.last;
		queue.n++;
	}

	/**
	 * Removes the element at the beginning of the immutable queue, and returns the
	 * new queue.
	 *
	 * @return new queue without first item.
	 * @throws NoSuchElementException if this queue is empty
	 */
	public ImmutableQueue<T> deQueue() {
		if (isEmpty())
			throw new NoSuchElementException("ImmutableQueue underflow");

		ImmutableQueue<T> newQueue = new ImmutableQueue<T>();
		boolean first = true;
		Node<T> current = this.first;
		while (current != null) {
			if (!first)
				newQueue.add(newQueue, current.item);
			else
				first = false;
			current = current.next;
		}

		if (newQueue.isEmpty())
			newQueue.last = null; // to avoid loitering

		return newQueue;
	}

	@SuppressWarnings("unchecked")
	public T head() {
		Gson gson = new Gson();
		Object deepCopy = gson.fromJson(gson.toJson(first.item, first.type), first.type);
		return (T) deepCopy;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node<T> current = first;
		while (current != null) {
			s.append(current.item);
			s.append(' ');
			current = current.next;
		}
		return s.toString();
	}
}
