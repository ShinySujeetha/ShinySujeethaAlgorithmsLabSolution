package gl.javafsd.travellers.currency;

public class BubbleSort {
	private int[] denominations;
	
	public BubbleSort(int[] denominations) {
		this.denominations=denominations;
	}
	public void sortDescending() {
		int length = denominations.length;
		for (int iIndex = 0; iIndex < (length - 1); iIndex++) {
		
			for (int jIndex = 0; jIndex < (length - iIndex - 1); jIndex++) {
			
				if (denominations[jIndex] < denominations[jIndex + 1]) {
				
					int temp = denominations[jIndex];
					denominations[jIndex] = denominations[jIndex + 1];
					denominations[jIndex + 1] = temp;
				}
			}
		}
	}

}
