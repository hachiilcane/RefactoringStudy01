package Refactoring01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Regular映画1本を1日借りた時の計算書出力が正しい() {
		// Setup
		Movie m1 = new Movie("風と共に去りぬ", 0);
		Rental r1 = new Rental(m1, 1);
		Customer target = new Customer("まりお");
		target.addRental(r1);
		String expected = "Rental Record for まりお\n"
				+ "\t風と共に去りぬ\t2.0\n"
				+ "Amount owed is 2.0\n"
				+ "You earned 1 frequent renter points";

		// Exercise
		String actual = target.statement();

		// Verify
		assertThat(actual, is(expected));
	}

	@Test
	public void 映画3本をそれぞれ長めに借りた時の計算書出力が正しい() {
		// Setup
		Movie m1 = new Movie("風と共に去りぬ", 0);
		Movie m2 = new Movie("イミテーション・ゲーム", 1);
		Movie m3 = new Movie("映画クレヨンしんちゃん", 2);

		Rental r1 = new Rental(m1, 5);
		Rental r2 = new Rental(m2, 3);
		Rental r3 = new Rental(m3, 7);

		Customer target = new Customer("まりお");
		target.addRental(r1);
		target.addRental(r2);
		target.addRental(r3);

		String expected = "Rental Record for まりお\n"
				+ "\t風と共に去りぬ	6.5\n"
				+ "\tイミテーション・ゲーム\t9.0\n"
				+ "\t映画クレヨンしんちゃん\t7.5\n"
				+ "Amount owed is 23.0\n"
				+ "You earned 4 frequent renter points";

		// Exercise
		String actual = target.statement();

		// Verify
		assertThat(actual, is(expected));
	}

	@Test
	public void 映画3本をそれぞれ1日借りた時の計算書出力が正しい() {
		// Setup
		Movie m1 = new Movie("風と共に去りぬ", 0);
		Movie m2 = new Movie("イミテーション・ゲーム", 1);
		Movie m3 = new Movie("映画クレヨンしんちゃん", 2);

		Rental r1 = new Rental(m1, 1);
		Rental r2 = new Rental(m2, 1);
		Rental r3 = new Rental(m3, 1);

		Customer target = new Customer("まりお");
		target.addRental(r1);
		target.addRental(r2);
		target.addRental(r3);

		String expected = "Rental Record for まりお\n"
				+ "\t風と共に去りぬ	2.0\n"
				+ "\tイミテーション・ゲーム\t3.0\n"
				+ "\t映画クレヨンしんちゃん\t1.5\n"
				+ "Amount owed is 6.5\n"
				+ "You earned 3 frequent renter points";

		// Exercise
		String actual = target.statement();

		// Verify
		assertThat(actual, is(expected));
	}

}
