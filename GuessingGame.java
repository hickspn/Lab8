import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  int numRand;
  JTextField userGuess; 
  JLabel hint, lastGuess, guessText;
  Random rand;
  GuessingGame(){
    rand = new Random();
    numRand = rand.nextInt(101) + 1;
    
    JButton guessButton = new JButton("Guess");
    JButton playAgainButton = new JButton("Play Again");

    hint = new JLabel("");
    lastGuess = new JLabel("");
    guessText = new JLabel("Enter your guess: ");

    userGuess = new JTextField(10); 
    userGuess.setActionCommand("myTF");


    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,110);

    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    frame.add(guessText);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(hint);
    frame.add(lastGuess);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    if (ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      if(guess > numRand){
        hint.setText("Too High!");
        lastGuess.setText("Last guess was: " + guess);
      }else if(guess < numRand){
        hint.setText("Too Low!");
        lastGuess.setText("Last guess was: " + guess);
      }else{
        hint.setText("You got it!");
        lastGuess.setText("Last guess was: " + guess);
      }
    }else if(ae.getActionCommand().equals("Play Again")){
      numRand = rand.nextInt(101) + 1;
      hint.setText("");
      lastGuess.setText("");
      userGuess.setText("");
    }else{
      hint.setText("Please press the Guess Button");
    }
  }
}
  