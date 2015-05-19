package Refactoring01;


public class Main {

	public static void main(String[] args) {

		Movie m1 = new Movie("風と共に去りぬ", 0);
		Movie m2 = new Movie("イミテーション・ゲーム", 1);
		Movie m3 = new Movie("映画クレヨンしんちゃん", 2);

		Rental r1 = new Rental(m1, 5);
		Rental r2 = new Rental(m2, 3);
		Rental r3 = new Rental(m3, 7);

		Customer mario = new Customer("まりお");
		mario.addRental(r1);
		mario.addRental(r2);
		mario.addRental(r3);

		System.out.println(mario.statement());
		System.out.println("\n\nHTML version --------");
		System.out.println(mario.htmlStatement());
	}

}
