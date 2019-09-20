package com.vishwanath;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("welcome to number game");

        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //get number generator context from container
        NumberGenerator numgen = context.getBean("numberGenerator", NumberGenerator.class  );

        int number = numgen.next();

        log.info("number = {}", number);

        //get game bean context from container
        Game game = context.getBean("game", Game.class);
        game.reset();

        context.close();
    }
}
