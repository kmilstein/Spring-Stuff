package revature.learn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import revature.learn.GuessCount;
import revature.learn.MaxNumber;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    //== fields ==//
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    //== bean methods ==//
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
