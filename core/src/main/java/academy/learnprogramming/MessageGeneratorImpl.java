package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {


    public static final Logger logger = LoggerFactory.getLogger( MessageGeneratorImpl.class );

    @Autowired
    public Game game;

    private int guessCount=10;


    @PostConstruct
    private void init(){
        logger.info("This will be printed from Game {}, LOG has already been injected",game);
    }


    public String getMainMessage() {
        return "getMainMessage()  Called";
    }

    public String getResultMessage() {
        return "getResultMessage() get Called";
    }


}
