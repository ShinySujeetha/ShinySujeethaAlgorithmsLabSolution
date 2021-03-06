package gl.javafsd.travellersUI;
import gl.javafsd.travellers.currency.*;
import java.util.Scanner;

public class TravellersUI {
	private int[] denominations;
	private Scanner input;
	
	public TravellersUI() {
		input=new Scanner(System.in);
	}
	public void init(){
		userInputsAndProcessing();
	}
	
	private void userInputsAndProcessing() {
		
		System.out.println("Enter the size of currency denominations");
		int size=input.nextInt();
		denominations=new int[size];
		System.out.println();
		
		System.out.println("Enter the currency denominations value");
		for(int index=0;index<denominations.length;index++) {
			denominations[index]=input.nextInt();			
		}
		System.out.println();
		
		System.out.println("Enter the amount you want to pay");
		int paymentAmount=input.nextInt();
		CurrencyDenominationCalculator calculator=new CurrencyDenominationCalculator(denominations,paymentAmount);
		calculator.calculate();
	}	

}
