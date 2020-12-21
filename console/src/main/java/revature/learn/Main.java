package revature.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import revature.learn.config.AppConfig;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");

        //create the context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        //get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        //get message generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //log main and result message
        log.info("main message = {}", messageGenerator.getMainMessage());
        log.info("result message = {}", messageGenerator.getResultMessage());

        //close context (container)
        context.close();
    }
}
