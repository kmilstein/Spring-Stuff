package revature.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

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
        return "Main message string";
    }

    @Override
    public String getResultMessage() {
        return "Result message string";
    }
}
