package Refactoring01;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental : _rentals){
			// この貸出に関する数値の表示
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(rental.getCharge()) + "\n";
		}

		// フッタ部分の追加
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned "
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : _rentals){
			result += rental.getCharge();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for(Rental rental : _rentals){
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}

	public String htmlstatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		for(Rental rental : _rentals){

			// この貸出に関する数値の表示
			result += rental.getMovie().getTitle() + ": "
					+ String.valueOf(rental.getCharge()) + "<BR>\n";
		}
		// フッタ部分の追加
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge())
				+ "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}

}
