package immutable;

public class App {
	public static void main(String[] args) {

		// Test case has been written in ImmutableQueueTest class

		// Sample immutable queue
		ImmutableQueue<Object> iq2 = ImmutableQueue.of("t1", "t2", "t3", "t4", "t5");
		System.out.println("iq2: " + iq2);

		ImmutableQueue<Object> iq3 = iq2.enQueue("iq3");
		System.out.println("iq2: " + iq2);
		System.out.println("iq3: " + iq3);

		ImmutableQueue<Object> iq4 = iq3.enQueue("iq4");
		System.out.println("iq2: " + iq2);
		System.out.println("iq3: " + iq3);
		System.out.println("iq4: " + iq4);

		ImmutableQueue<Object> iq5 = iq4.enQueue("iq5");
		System.out.println("iq2: " + iq2);
		System.out.println("iq3: " + iq3);
		System.out.println("iq4: " + iq4);
		System.out.println("iq5: " + iq5);

		ImmutableQueue<Object> iq6 = iq2.deQueue();
		System.out.println("iq2: " + iq2);
		System.out.println("iq3: " + iq3);
		System.out.println("iq4: " + iq4);
		System.out.println("iq5: " + iq5);
		System.out.println("iq6: " + iq6);

		System.out.println("head:" + iq6.head());

		ImmutableQueue<Object> iq7 = ImmutableQueue.of("te", 12, 1l);
		System.out.println("head:" + iq7.head());
		ImmutableQueue<Object> iq8 = iq7.deQueue();
		System.out.println("head:" + iq8.head());
		ImmutableQueue<Object> iq9 = iq8.deQueue();
		System.out.println("head:" + iq9.head());
	}
}
