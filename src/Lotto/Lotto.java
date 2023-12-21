package exercise2;

import java.util.Random;
import javax.swing.JOptionPane;

public class Lotto{
    	private static final int MAX_TIMES = 5;
    	private int[] numbers;
    	
    	public Lotto() {
    		numbers = new int[3];
    		generateRandomNumbers();
    	}
    	
    	// Generate random numbers for the lotto
    	private void generateRandomNumbers() {
        	Random random =  new Random();
        	for (int i = 0;  i < numbers.length; i++) {
        		numbers[i] = random.nextInt(9) + 1;
        	}
    	}
    
    	public int[] getNumbers() {
    		return numbers;
    	}
    	
    	public static void main(String[] args) {
    	int totalNumber = 0;
    	int userInputNumber = getUserNumber();
    	boolean userWins = false;
    	
    	for(int i = 0; i < MAX_TIMES; i++) {
    		Lotto lotto = new Lotto();
    		int[] lottoNumbers = lotto.getNumbers();
    		int lottoNumberSum = lottoNumbers[0] + lottoNumbers[1] + lottoNumbers[2];
    		
    	    totalNumber += lottoNumberSum;
    		
    	    System.out.println("The " + (i + 1) + " lotto number is " + lottoNumberSum);

    	    
    	    if (userInputNumber == lottoNumberSum) {
    	    	System.out.println("Congratulations! You win the game!");	
    	    	userWins = true;
    	    	break;      	
    	    }    	    
    	}
    	
    	if (!userWins) {
    		System.out.println("The computer wins. The number does not match the sum within five rools.");
    	}
    	
    	System.out.println("Total sum of lotto number is " + totalNumber);  	
    }
    	 // Get the user's number input
		private static int getUserNumber() {
    	//create Random Object
		String input = JOptionPane.showInputDialog(null, "Please enter an integer between 3 and 27: ");
		int userNumber =  Integer.parseInt(input);
		
		if(userNumber >= 3 && userNumber <= 27) {
			JOptionPane.showMessageDialog(null, "The number you picked is : " + userNumber);
			return userNumber;
		}else {
			JOptionPane.showMessageDialog(null,"Input invalid, please enter a number between 3 and 27.");
		    return getUserNumber();
		}
		
	}
}
	
	
	

