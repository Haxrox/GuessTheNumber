import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumber extends javax.swing.JFrame{
    // Components //
    private JButton newButton;
    private JPanel panel1;
    private JButton guessButton;
    private JTextField statusField;
    private JTextField lowerBound;
    private JTextField upperBound;
    private JTextField guessField;
    private JLabel triesLabel;

    // Variables //
    Random randomGenerator = new Random();
    int lowestNumber = 0, highestNumber = 100, tries = 0, guess = 0, guessingNumber = 0;

    // Listeners //
    public GuessTheNumber() {

        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newButtonActionPerformed(e);
            }
        });
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessButtonActionPerformed(e);
            }
        });
    }

    // New Button Clicked //
    private void newButtonActionPerformed(ActionEvent e) {
        if (lowestNumber >= highestNumber) {
            statusField.setText("Error! Your lowest number is greater or equal to your highest number!");
        }
        else {
            lowestNumber = Integer.parseInt(lowerBound.getText());
            highestNumber = Integer.parseInt(upperBound.getText());
            guess = randomGenerator.nextInt(highestNumber - lowestNumber + 1)  + lowestNumber;
            statusField.setText("Ok, I'm thinking of a number between " + lowestNumber + " and " + highestNumber + "! Begin guessing!");
            triesLabel.setText("Tries: " + tries);
            guessButton.setEnabled(true);
        }
    }

    // Guess Button Clicked //
    private void guessButtonActionPerformed(ActionEvent e) {
        guessingNumber = Integer.parseInt(guessField.getText());
        tries ++;
        triesLabel.setText("Tries: " + tries);
        if (guess == guessingNumber) {
            statusField.setText("Congratulations! You guessed the number " + guess + " in " + tries + " tries!");
            guess = 0; tries = 0;
            guessButton.setEnabled(false);
        }
        else if (guess > guessingNumber) { statusField.setText("Sorry! Your guess was too low! Try again!"); }
        else if (guess < guessingNumber) { statusField.setText("Sorry! Your guess was too high! Try again!"); }
    }

    // Main //
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess The Number");
        frame.setContentPane(new GuessTheNumber().panel1);
        frame.pack();
        frame.setVisible(true);
    }
}
