package com.univaq.stoneage;

import com.univaq.stoneage.ui.UMainFrame;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StoneageApplication extends Application {

    public static void main(String[] args) {
        SpringApplication.run(StoneageApplication.class, args);
        System.setProperty("java.awt.headless", "false");

        UMainFrame mainFrame = UMainFrame.getInstance();
        mainFrame.setStartPage();
        mainFrame.setVisible(true);
    }


    @Override
    public void start(Stage stage) throws Exception {

    }
}
