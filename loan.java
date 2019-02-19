import java.util.Scanner;

class loan {
    public static void loan() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is your name? ");
        if (keyboard.hasNextInt() || keyboard.hasNextDouble() || keyboard.hasNextFloat()) {
            System.out.println("Your name is not " + keyboard.nextLine() + "." + " LOAN DENIED.");
            return;
        }

        String name = keyboard.nextLine();

        System.out.print("Enter your annual salary: ");
        if (keyboard.hasNextInt()) {
        } else {
            System.out.println("That's a letter, not a number!" + " LOAN DENIED.");
            return;
        }
        int salary = keyboard.nextInt();

        System.out.print("Enter your credit score: ");
        if (keyboard.hasNextInt()) {
        } else {
            System.out.println("That's a letter, not a number!" + " LOAN DENIED.");
            return;
        }
        int fico = keyboard.nextInt();
        if (fico > 800 || fico < 0) {
            System.out.println("FICO scores are between 0 and 800.");
            return;
        }

        System.out.print("How many years have you been employed? ");
        if (keyboard.hasNextInt()) {
        } else {
            System.out.println("That's a letter, not a number!");
            return;
        }
        int years = keyboard.nextInt();

        System.out.print("Enter your requested loan amount: ");
        if (keyboard.hasNextInt()) {
        } else {
            System.out.println("That's a letter, not a number!" + " LOAN DENIED.");
            return;
        }
        int amount = keyboard.nextInt();

        System.out.print("In how many months will you finance the loan? ");
        if (keyboard.hasNextInt()) {
        } else {
            System.out.println("That's a letter, not a number!");
            return;
        }
        int months = keyboard.nextInt();

//                     -----

        if (salary < 25000) {
            System.out.println("Loan not approved. Salary under $25,000.");
        }

        if (years < 2) {
            System.out.println("Loan not approved. You haven't been employed for at least two years.");
        }

        if (fico < 600) {
            System.out.println("Loan not approved. Credit Score under 600.");
        }

        if (amount > (.30 * salary) || amount < 500) {
            System.out.println("Loan not approved. Loan amount is either under $500 or greater than 13% of your salary.");
        }

        if (months < 3 || months > 75) {
            System.out.println("Loan not approved. Finance months must between 3 and 75.");
        }

//                     -----

        double monthlyInterestRate = 0;

        if (fico >= 750) {
            monthlyInterestRate = .03;
        }
        if (fico >= 700 && fico <= 749) {
            monthlyInterestRate = .05;
        }
        if (fico >= 650 && fico <= 699) {
            monthlyInterestRate = .1;
        }
        if (fico >= 600 && fico <= 649) {
            monthlyInterestRate = .15;
        }
        double monthlyPayment =  monthlyInterestRate * amount / ( 1 - Math.pow(1+monthlyInterestRate, -1*months));
        double monthlyInterestRatePercent = monthlyInterestRate * 100;
        double total = monthlyPayment * months;
        double interest = total - amount;

        System.out.println("");
        System.out.println("");

        System.out.println(" " + name + ", your loan of $" + amount + " has been approved with an interest rate of " + monthlyInterestRatePercent + "%");
        System.out.println("        Number of Finance months:      " + months);
        System.out.println("        Monthly Payment:               " + monthlyPayment);
        System.out.println("        Total Payment after " + months + " months: " + total);
        System.out.println("        Total interest paid:           " + interest);
    }


    public static void main(String[] args) { loan();
    }
}
