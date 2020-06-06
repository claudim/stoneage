package com.univaq.stoneage.model.squares.surpriseToken.surpriseTokenExecutionStrategies;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public class ExecuteNowSurpriseCommandStrategy implements SurpriseCommandExecutionStrategy {
    @Override
    public void executeSurpriseTokenCommand(ISurpriseTokenCommand surpriseTokenCommand) {
        surpriseTokenCommand.execute();
    }
}
