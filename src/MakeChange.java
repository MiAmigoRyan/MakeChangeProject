import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Ammount?");
		double cost = sc.nextDouble();
		System.out.println("Tendred");
		double paid = sc.nextDouble();

		double giveChange = paid - cost;
		int dollars = (int) giveChange;
		double coins = giveChange - dollars;
		double rndCents = Math.round(coins * 100);
		int cents = (int) rndCents;

		if (paid > cost) {
			System.out.println("Total Change Due");
			System.out.println("----------------");
			System.out.println("$" + dollars + "." + cents);
			System.out.println("----------------");

			int twenties = dollars / 20;
			dollars %= 20;	
			int tens = dollars / 10;
			dollars %= 10;
			int fives = dollars / 5;
			dollars %= 5;	
			int ones = dollars / 1;
			int quarters = cents / 25;
			cents %= 25;
			int dimes = cents / 10;
			cents %= 10;
			int nickles = cents / 5;
			cents %= 5;
			int pennies = cents / 1;

			if (twenties > 0) {
				System.out.println(twenties + " twenties");
			}
			if (tens > 0) {
				System.out.println(tens + " tens");
			}
			if (fives > 0) {
				System.out.println(fives + " fives");
			}
			if (ones > 0) {
				System.out.println(ones + " ones");
			}
			if (quarters > 0) {
				System.out.println(quarters + " quarters");
			}
			if (dimes > 0) {
				System.out.println(dimes + " dimes");
			}
			if (nickles > 0) {
				System.out.println(nickles + " nickles");
			}
			if (pennies > 0) {
				System.out.println(pennies + " pennies");
			}
		} else {
			System.err.println("PAYMENT IS TOO LOW");
		}

	}
}
// tests: 
//		Amount: .67, Tendered: .50, Result: Error message
//1st testing : pass
//2nd testing : pass
//3rd testing : pass
//		Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
//1st testing : fail : result 1.31....quarters
//2nd testing : pass
//3rd testing : pass
//		Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
//1st testing : fail : result 1.64...quarter
//2nd testing : pass
//3rd testing : pass
//		Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
//1st testing : fail : result :1 $10's ----no change! ?
//2nd testing : fail only 3 pennies!!!!
//3rd testing : pass !!!
//		Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations for correct change.
//1st testing : fail : will only pass for dollars not change...
//2nd testing : pass for both dollars and cents.
//3rd testing : pass
//---------------------------------------------------------------------//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("what is the cost of the item?");
//		double cost = sc.nextDouble();
//		System.out.println("what is the payment ammount?");
//		double paid = sc.nextDouble();
//
//		double giveChange = changeDue(paid, cost);
//// could be methods
//		int dollars = (int) giveChange;
//
//		double coins = giveChange - dollars;
//
//		double rndCents = Math.round(coins * 100);
//// method
//		int cents = (int) rndCents;
//
//		if (paid > cost) {
//			System.out.println("Total Change Due");
//			System.out.println("----------------");
//			System.out.println("$" + dollars + "." + cents);
//			System.out.println("----------------");
//		} else {
//			System.err.println("Payment is less than cost");
//		}
//
//		while (dollars > 0) {
//			if (dollars >= 20) {
//				int twenty = dollars / 20;
//				System.out.println(twenty + " $20's");
//				dollars %= 20;
//			}
//			if (dollars >= 10) {
//				int tens = dollars / 10;
//				System.out.println(tens + " $10's");
//				dollars %= 10;
//			}
//			if (dollars >= 5) {
//				int fives = dollars / 5;
//				System.out.println(fives + " $5's");
//				dollars %= 5;
//			}
//			if (dollars >= 1) {
//				System.out.println(dollars + " $1's");
//				dollars %= 1;
//			}
//		}
//		while (cents > 0) {
//			if (cents >= 25) {
//				int quarter = cents / 25;
//				System.out.println(quarter + " Quarter");
//				cents %= 25;
//			}
//			if (cents >= 10) {
//				int dimes = cents / 10;
//				System.out.println(dimes + " Dime");
//				cents %= 10;
//			}
//			if (cents >= 5) {
//				int nickles = cents / 5;
//				System.out.println(nickles + " Nickle");
//				cents %= 5;
//			}
//			if (cents > 0) {
//				int pennies = cents / 1;
//				System.out.println(pennies + " Penny");
//				cents %= 1;
//			}
//
//		}
//
//		sc.close();
//	}
//
//	public static double changeDue(double paid, double cost) {
//		double change = paid - cost;
//		return change;
//
//	}
//}
