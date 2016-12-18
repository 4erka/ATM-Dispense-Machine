import java.util.Scanner;

public class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Rupiah100Dispenser();
		DispenseChain c2 = new Rupiah50Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
	}

	public static void main(String[] args) {
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 0;
			System.out.println("Masukkan uang yang ingin diambil:");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 50000 != 0) {
				System.out.println("Jumlah harus kelipatan 50000.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}

	}

}