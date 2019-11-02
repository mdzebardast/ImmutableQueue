package immutable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImmutableQueueMutableClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		// sample data with custom Mutable class
		// Given
		Address tehranAddress = new Address();
		tehranAddress.city = "Tehran";

		User user = new User();
		user.name = "Mohammad";
		user.address = tehranAddress;

		Address tokyoAddress = new Address();
		tokyoAddress.city = "Tokyo";

		User paypayUser = new User();
		paypayUser.name = "PayPay";
		paypayUser.address = tokyoAddress;

		ImmutableQueue<Object> firstQueue = ImmutableQueue.of(user);
		ImmutableQueue<Object> secondQueue = firstQueue.enQueue(paypayUser);

		/*
		 * Getting first element and modifying it without affecting on queue!
		 * 
		 * Point: mohammadUser is a deep copy of first element in queue!
		 */
		User mohammadUser = (User) secondQueue.head();
		Address shirazAddress = new Address();
		shirazAddress.city = "Shiraz";
		mohammadUser.address = shirazAddress;

		// assert
		assertEquals("Tehran", ((User) firstQueue.head()).address.city);
		assertEquals("Tehran", ((User) secondQueue.head()).address.city);

	}
}

class Address {
	String city;

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
}

class User {
	String name;
	Address address;

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + "]";
	}
}
