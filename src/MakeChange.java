// hints:
// this will give us the cents remaing
//		System.out.println(25.30%25);
// 0.3000000000000000007 pennies issue...
// could add .005 or use Math.round()
//	double num = 25.30 % 25;
//	System.out.println(num);
//	double newNum = Math.round(num*100.0);
//	int newNumInt = (int)newNum;
//			
//	
//	System.out.println( "this is rounded to the nearest 100th" + newNum);
//	System.out.println("this is the rounded number as an int.."+newNumInt);

// above this is thought vommit...

// tests:
//		Amount: .67, Tendered: .50, Result: Error message
//		Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
//		Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
//		Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
//		Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations for correct change.
import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("what is the cost of the item?");
		double cost = sc.nextDouble();
		System.out.println("what is the payment ammount?");
		double paid = sc.nextDouble();

		double giveChange = changeDue(paid, cost);

		int dollars = (int) giveChange;

		double coins = giveChange - dollars;

		System.out.println(dollars + coins + " Total Change Due");

		if (cost > paid) {
			System.err.println("Payment is less than cost");
		} else if (dollars > 0) {
			// 20 or more in change
			if (dollars >= 20) {
				int twenty = dollars / 20;
				System.out.println(twenty);
				int newDollar = dollars - (twenty * 20);

				if (newDollar >= 10) {
					int tens = newDollar / 10;
					System.out.println(tens);
					int newDollar2 = newDollar - (tens * 10);

					if (newDollar2 >= 5) {
						int fives = newDollar2 / 5;
						System.out.println(fives);
						int newDollar3 = newDollar2 - (fives * 5);
						if (newDollar3 >= 1) {
							int ones = newDollar3 / 1;
							System.out.println(ones);
						}

					}
				}
				// 10 or less in change not more than 20
			} else if (dollars >= 10 && dollars < 20) {
				int tens = dollars / 10;
				System.out.println(tens);
				int newDollar = dollars - (tens * 10);

				if (newDollar >= 10) {
					int fives = newDollar / 5;
					System.out.println(fives);
					int newDollar2 = newDollar - (fives * 5);
					if (newDollar2 >= 1) {
						int ones = newDollar2 / 1;
						System.out.println(ones);
					}
				}
				// 5 or less in change not more than 10
			} else if (dollars >= 5 && dollars < 10) {
				int fives = dollars / 5;
				System.out.println(fives);
				int newDollars = dollars - (fives * 5);
				if (newDollars >= 1) {
					int ones = newDollars / 1;
					System.out.println(ones);
				}
			} else if (dollars >= 1 && dollars < 5) {
				int ones = dollars / 1;
				System.out.println(ones);
			}
		} else if (coins > 0) {
			if (coins >= .25) {
				double quarter = coins / .25;
				System.out.println(quarter);
				double newCoins = coins - (quarter * .25);
				if (newCoins >= .10 && coins < .25) {
					double dimes = coins / .1;
					System.out.println(dimes);
					double newCoins2 = newCoins - (dimes * .1);
					if (newCoins2 >= 0.05 && newCoins < 0.1) {
						double nickles = newCoins2 / 0.05;
						System.out.println(nickles);
						double newCoins3 = newCoins2 - (nickles * 0.05);
						if (newCoins3 > 0.01 && newCoins3 < .05) {
							double pennies = newCoins3 / 1;
							System.out.println(pennies);
						}
					}
				}
			}
		}
		sc.close();
	}

	public static double changeDue(double paid, double cost) {
		double change = paid - cost;
		return change;

	}
}

//				// 20's
//				double twenties = Math.floor(roundChange / 20);
//				System.out.println(twenties + " $20's");
//
//			// 10's
//			double min20 = roundChange - (twenties * 20);
//			double tens = Math.floor(min20 / 10);
//			System.out.println(tens + " $10's");
//
//			// 5's
//			double min10 = min20 - (tens * 10);
//			double fives = Math.floor(min10 / 5);
//			System.out.println(fives + " $5's");
//
//			// 1's
//			double min5 = min10 - (fives * 5);
//			double ones = Math.floor(min5 / 1);
//			System.out.println(ones + " $1's");
//			// 0.25's
//			double min1 = min5 - (ones * 1);
//			double quarters = Math.floor(min1 / 0.25);
//			System.out.println(quarters + " $0.25's");
//
//			// 0.1's
//			double minQuarters = min1 - (quarters * 0.25);
//			System.out.println(minQuarters); 
//			double dimes = Math.floor(minQuarters / 0.1);
//			System.out.println(dimes + " $0.10's");
//
//			// 0.05's
//			double minDimes = minQuarters - (dimes * 0.1);
//			double nickles = Math.floor(minDimes / 0.5);
//			System.out.println(nickles + " $0.05's");
//
//			// 0.01's may run into penny problems, checks for pennies
//			double minNickles = minDimes - (nickles * 0.5);
//			double pennies = Math.floor(minNickles / 0.01);
//			System.out.println(pennies + " $0.01's");
//
//	this shouldn't go here because the loop eventually get here always
//		else {
//			System.err.print("!!! Payment is less than total !!!");
// }
