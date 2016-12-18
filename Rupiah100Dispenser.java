public class Rupiah100Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 100000){
			int num = cur.getAmount()/100000;
			int remainder = cur.getAmount() % 100000;
			System.out.println("Memecah "+num+" Rp.100000");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}