package revature.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    //== constants ==//
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    //== fields == //
    @Autowired
    private Game game;
    private int guessCount = 10;

    //== init ==//
    @PostConstruct
    public void postConstruct() {
        int number = game.getNumber();
        log.debug("Number in the messageGenerator is {}", number);
    }

    //== public methods ==//
    @Override
    public String getMainMessage() {
        return "Number is between" +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameLost()) {
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

            return direction + "! You have " + game.getRemainingGuesses() + "guesses left";
        }
    }
}
