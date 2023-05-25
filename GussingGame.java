package OsissTask;

	import java.util.Random;
	import javax.swing.JOptionPane;

	public class GussingGame {
	    public static void main(String[] args) {
	        int lowerBound = 1;
	        int upperBound = 100;
	        int maxAttempts = 5;
	        int score = 0;
	        boolean continuePlaying = true;
	        
	        Random random = new Random();
	        while (continuePlaying) {
	            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
	            int attemptsRemaining = maxAttempts;
	            boolean guessedCorrectly = false;
	            
	            while (attemptsRemaining > 0 && !guessedCorrectly) {
	                String guessString = JOptionPane.showInputDialog(null, 
	                        "Guess the number between " + lowerBound + " and " + upperBound + 
	                        "\nAttempts remaining: " + attemptsRemaining, 
	                        "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	                
	                if (guessString == null) {
	                    // User clicked cancel, so exit the game
	                    continuePlaying = false;
	                    break;
	                }
	                
	                int guess = Integer.parseInt(guessString);
	                
	                if (guess == numberToGuess) {
	                    guessedCorrectly = true;
	                    score += attemptsRemaining;
	                    JOptionPane.showMessageDialog(null, 
	                            "Congratulations, you guessed the number in " + (maxAttempts - attemptsRemaining + 1) + " attempts!", 
	                            "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	                } else if (guess < numberToGuess) {
	                    JOptionPane.showMessageDialog(null, "Too low!", "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	                    attemptsRemaining--;
	                } else {
	                    JOptionPane.showMessageDialog(null, "Too high!", "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	                    attemptsRemaining--;
	                }
	            }
	            
	            if (!guessedCorrectly) {
	                JOptionPane.showMessageDialog(null, "Sorry, the number was " + numberToGuess + ".", 
	                        "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	            }
	            
	            int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", 
	                    "Guessing Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if (option == JOptionPane.NO_OPTION) {
	                continuePlaying = false;
	            }
	        }
	        
	        JOptionPane.showMessageDialog(null, "Your final score was " + score + ".", 
	                "Guessing Game", JOptionPane.PLAIN_MESSAGE);
	    }

}
