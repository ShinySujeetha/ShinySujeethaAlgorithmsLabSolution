package gl.javafsd.travellers.currency;
import java.util.Arrays;

public class CurrencyDenominationCalculator {
	private int[] denominations;
	private int paymentAmount;
	
	private int[] resultantDenominationArray;
	private int[] resultantDenominationCountArray;
	
	public CurrencyDenominationCalculator(int[] denominations,int paymentAmount) {
		this.denominations = denominations;
		this.paymentAmount = paymentAmount;
		this.resultantDenominationArray = new int[denominations.length];
		this.resultantDenominationCountArray = new int[denominations.length];		
	}
	
	public void calculate() {
		
		sort();
		
		int index=0;
		int resultIndex=0;
		int balance=paymentAmount;
		
		while(index<denominations.length) {
			
			int denomination = denominations[index];
			int quotient = balance/denomination;
			int remainder = balance%denomination;
			
			if(quotient!=0) {
				int temp = denomination*quotient;
				
				balance = balance-temp;
				
				resultantDenominationArray[resultIndex] = denomination;
				resultantDenominationCountArray[resultIndex] = quotient;
				
				resultIndex++;
				
				if(remainder!=0) {
					//continue
				}
				else {
					if(balance==0) {
						printSuccessMessage(resultIndex);
						break;
					}
				}
				
			}
			else {
				
				if(remainder!=0) {
					if(!isLastDenominationIndex(index)) {
						//continue
					}
					else {
						printErrorMessage();
						break;
					}
				}
			}
			index++;
		}
	}
	
	private void sort(){
		BubbleSort bubbleSort=new BubbleSort(denominations);
		bubbleSort.sortDescending();
	}
	
	private boolean isLastDenominationIndex(int index) {
		if(index == denominations.length-1) 
			return true;
		else
			return false;
	}
	
	private void printSuccessMessage(int resultIndex) {
		resultantDenominationArray=Arrays.copyOf(resultantDenominationArray,resultIndex);
		resultantDenominationCountArray=Arrays.copyOf(resultantDenominationCountArray,resultIndex);
		
	    System.out.println("Your payment approach in order to give min no of notes will be");
	    System.out.println();
	    
	    for(int index=0;index<resultantDenominationArray.length;index++) {
	    	int denomination=resultantDenominationArray[index];
	    	int denominationCount=resultantDenominationCountArray[index];
	    	System.out.println(denomination +":"+ denominationCount);
	    } 
	}
	
	private void printErrorMessage() {
		System.out.println("Your payment approach cannot be processed.Please check the ammount you have entered");
	}
}