package gl.javafsd.paymoney.transactions;

public class TargetAcheivementCalculator {
	
	private int[] transactions;
	private int dailyTarget;
	private boolean dailyTargetAcheived;
	private int transactionCounter;
	
	public TargetAcheivementCalculator(int[] transactions, int dailyTarget) {
		this.transactions = transactions;
		this.dailyTarget = dailyTarget;
		this.dailyTargetAcheived = false;
		this.transactionCounter=0;
	}
	
	public void calculate() {
		int tempCounter = 0;
		for(int index = 0;index < transactions.length;index++) {
			int targetValue=transactions[index];
			tempCounter=tempCounter+targetValue;
			transactionCounter++;
			
			if(tempCounter >= dailyTarget) {
				dailyTargetAcheived = true;
				break;
			}
		}		
	}
	
	public void printResult() {
		if(dailyTargetAcheived) {
			System.out.println("The daily target of [" + dailyTarget +
					"] is acheived after " + transactionCounter + " transactions" );		
			}
		else {
			System.out.println("The daily target of [" + dailyTarget +
					"] is not acheived");	
		}
	}
}
