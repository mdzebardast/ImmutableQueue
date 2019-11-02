package immutable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ImmutableQueueTest {

	ImmutableQueue<Object> queue;

	@Before
	public void setUp() throws Exception {
		queue = ImmutableQueue.of("t1", "t2", "t3", "t4", "t5");
	}

	@Test
	public void testOf() {
		assertEquals(5, queue.size());
	}

	@Test
	public void testIsEmpty() {
		ImmutableQueue<Object> queue = ImmutableQueue.of("t1");
		ImmutableQueue<Object> emptyQueue = queue.deQueue();

		assertEquals(1, queue.size());
		assertTrue(emptyQueue.isEmpty());
	}

	@Test
	public void testEnQueue() {
		ImmutableQueue<Object> modifiedQueue = queue.enQueue("t6");

		assertEquals(5, queue.size());
		assertEquals(6, modifiedQueue.size());
	}

	@Test
	public void testDeQueue() {
		ImmutableQueue<Object> modifiedQueue = queue.deQueue();

		assertEquals(5, queue.size());
		assertEquals(4, modifiedQueue.size());
	}

	@Test
	public void testHead() {
		assertTrue(queue.head().equals("t1"));
	}

}
