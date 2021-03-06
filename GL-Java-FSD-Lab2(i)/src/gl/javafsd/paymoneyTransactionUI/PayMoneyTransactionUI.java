package gl.javafsd.paymoneyTransactionUI;
import gl.javafsd.paymoney.transactions.*;
import java.util.Scanner;

public class PayMoneyTransactionUI {
	private int[] transactions;
	private Scanner input;
	
	public PayMoneyTransactionUI() {
		input=new Scanner(System.in);
	}
	public void init(){
		userInputsAndProcessing();
	}
	
	private void userInputsAndProcessing() {
		
		System.out.println("Enter the size of transaction array:");
		int sizeOfTransactionArray=input.nextInt();
		transactions=new int[sizeOfTransactionArray];
		System.out.println();
		
		System.out.println("Enter the values of Array");
		for(int index=0;index<transactions.length;index++) {
			transactions[index]=input.nextInt();			
		}
		System.out.println();
		
		System.out.println("Enter the total no.of targets to be acheived:");
		int totalNoOfTargets=input.nextInt();
		
		for(int index=0;index<totalNoOfTargets;index++) {
			System.out.println("Enter the value of target:");
			int dailyTarget=input.nextInt();
			
			TargetAcheivementCalculator calculator = new TargetAcheivementCalculator(transactions,dailyTarget);
			calculator.calculate();
			calculator.printResult();		
		}
		
		
	}

}
