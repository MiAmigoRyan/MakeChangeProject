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
//1st test : pass
//2nd test : pass
//3rd test : pass
//		Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
//1st test : fail : result 1.31....quarters
//2nd test : pass
//3rd test : pass
//		Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
//1st test : fail : result 1.64...quarter
//2nd test : pass
//3rd test : pass
//		Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
//1st test : fail : result :1 $10's ----no change! ?
//2nd test : fail only 3 pennies!!!!
//3rd test : pass !!!
//		Amount: any amount less than 20.00, Tendered: anything greater than amount: correct denominations for correct change.
//1st test : fail : will only pass for dollars not change...
//2nd test : pass for both dollars and cents.
//3rd test : pass
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
	//System.out.println(coins);
	//	double cents = coins *100;
		double rndCents = Math.round(coins*100);
		int cents = (int) rndCents;
//		System.out.println(coins + "round?");
	//	int cents = (int) coins;
//		System.out.println(cents);
		if (paid > cost) {
			System.out.println("Total Change Due");
			System.out.println("----------------");
			System.out.println("$" + dollars +"."+ cents);
			System.out.println("----------------");
		} else {
			System.err.println("Payment is less than cost");
		}

		
		while (dollars > 0) {
			if (dollars >= 20) {
				int twenty = dollars / 20;
				System.out.println(twenty + " $20's");
				dollars %= 20;
			}
			if (dollars >= 10) {
				int tens = dollars / 10;
				System.out.println(tens + " $10's");
				dollars %= 10;
			}
			if (dollars >= 5) {
				int fives = dollars / 5;
				System.out.println(fives + " $5's");
				dollars %= 5;
			}
		if (dollars >= 1) {
			System.out.println(dollars + " $1's");
			dollars %= 1;
			}
		}
		while (cents > 0) {
			if (cents >= 25) {
				int quarter = cents / 25;
				System.out.println(quarter + " Quarter");
				cents %= 25;
			}
			if (cents >= 10) {
				int dimes = cents / 10;
				System.out.println(dimes + " Dime");
				cents %= 10;
			}
			if (cents >= 5) {
				int nickles = cents / 5;
				System.out.println(nickles + " Nickle");
				cents %= 5;
			}
			if (cents > 0 ) {
				int pennies = cents / 1;
				System.out.println(pennies + " Penny");
				cents %= 1;
			}

		}

		// if (dollars >= 20) {
//				int twenty = dollars / 20;
//				System.out.println(twenty + " $20's");
//				dollars = dollars % (twenty * 20);
//				System.out.println(dollars + " dollars after subtracting 20");
//			} 
//			else if (dollars >= 10) {
//					int tens = dollars / 10;
//					System.out.println(tens + " $10's");
//					dollars = dollars % (tens * 10);
//					System.out.println( dollars + " dollars after sub 10's");
//				}				 

//					if (newDollar2 >= 5 && newDollar2 < 10) {
//						int fives = newDollar2 / 5;
//						System.out.println(fives + " $5's");
//						int newDollar3 = newDollar2 - (fives * 5);
//						if (newDollar3 >= 1 && newDollar3 <5) {
//							int ones = newDollar3 / 1;
//							System.out.println(ones + " $1's");
//						}
		// 10 or less in change not more than 20
//		if (dollars >= 10 && dollars < 20) {
//			int tens = dollars / 10;
//			System.out.println(tens + " $10's");
//			int newDollar = dollars - (tens * 10);
//
//			if (newDollar >= 10) {
//				int fives = newDollar / 5;
//				System.out.println(fives + "$5's");
//				int newDollar2 = newDollar - (fives * 5);
//				if (newDollar2 >= 1) {
//					int ones = newDollar2 / 1;
//					System.out.println(ones + " $1's");
//				}
//			}
//			// 5 or less in change not more than 10
//		}
//		if (dollars >= 5 && dollars < 10) {
//			int fives = dollars / 5;
//			System.out.println(fives + "$5's");
//			int newDollars = dollars - (fives * 5);
//			if (newDollars >= 1) {
//				int ones = newDollars / 1;
//				System.out.println(ones + " $1's");
//			}
//		}
//		if (dollars >= 1 && dollars < 5) {
//			int ones = dollars / 1;
//			System.out.println(ones + " $1's");
//		}

		sc.close();
	}

	public static double changeDue(double paid, double cost) {
		double change = paid - cost;
		return change;

	}
}
