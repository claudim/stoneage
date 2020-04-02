package com.univaq.stoneage;

import com.univaq.stoneage.ui.StartGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class StoneageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoneageApplication.class, args);
        System.setProperty("java.awt.headless", "false");

        JDialog start = new StartGame();
        start.setVisible(true);
    }

}
