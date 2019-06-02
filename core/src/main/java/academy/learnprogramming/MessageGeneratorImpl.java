package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {


    public static final Logger logger = LoggerFactory.getLogger( MessageGeneratorImpl.class );

    @Autowired
    public Game game;

    private int guessCount = 10;


    @PostConstruct
    private void init() {
        logger.info( "This will be printed from Game {}, LOG has already been injected", game );
    }


    public String getMainMessage() {

        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";


    }

    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";

            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guess left";
        }
    }
}



