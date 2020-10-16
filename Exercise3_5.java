package CH03;

import java.util.Scanner;

/*
You have just purchased a stereo system that cost $1,000 on the following credit
plan: no down payment, an interest rate of 18% per year (and hence 1.5% per
month), and monthly payments of $50. The monthly payment of $50 is used to
pay the interest, and whatever is left is used to pay part of the remaining debt.
Hence, the first month you pay 1.5% of $1,000 in interest. That is $15 in interest.
So, the remaining $35 is deducted from your debt, which leaves you with a debt of
$965.00. The next month, you pay interest of 1.5% of $965.00, which is $14.48.
Hence, you can deduct $35.52 (which is $50 – $14.48) from the amount you owe.
Write a program that tells you how many months it will take you to pay off the
loan, as well as the total amount of interest paid over the life of the loan.
Use a loop to calculate the amount of interest and the size of the debt after
each month. (Your final program need not output the monthly amount of interest paid
and remaining debt, but you may want to write a preliminary version of the program
that does output these values.)
Use a variable to count the number of loop iterations and hence,
the number of months until the debt is zero. You may want to use other variables as
well. The last payment may be less than $50 if the debt is small, but do not forget
the interest. If you owe $50, your monthly payment of $50 will not pay off your
debt, although it will come close. One month’s interest on $50 is only 75 cents.
 */

public class Exercise3_5 {
    public static void main(String[] args) {
        double annualInterestRate = 0.18;
        double monthlyInterestRate = annualInterestRate / 12;
        double loanAmount = 1000;
        int years;

        Scanner input = new Scanner(System.in);

        //Prompt user to input the number of years for the loan
        System.out.print("Years: ");
        years = input.nextInt();

        //How many months it will take to pay off the loan
        //Monthly Loan Payment Formula
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, years * 12));

        //the total amount of interest paid over the life of the loan
        double totalPayment = monthlyPayment * years * 12;

        //Header
        System.out.println("Payment#" + "\t\t" + "Interest"
                + "\t\t" + "Principal" + "\t\t" + "Balance");

        // Create amortization schedule
        double balance = loanAmount, principal, interest;

            //Display Monthly payments
            for (int paymentCounter = 1; paymentCounter <= years * 12; paymentCounter++) {
                interest = monthlyInterestRate * balance;
                principal = monthlyPayment - interest;
                balance = balance - principal;

                //Output 2
                System.out.printf("%3d %18.2f %16.2f %15.2f \n",
                        paymentCounter, interest, principal, balance);
            }




        }
    }
