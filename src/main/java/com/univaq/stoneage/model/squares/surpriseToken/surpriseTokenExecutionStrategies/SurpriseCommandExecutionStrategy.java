package com.univaq.stoneage.model.squares.surpriseToken.surpriseTokenExecutionStrategies;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;

public interface SurpriseCommandExecutionStrategy {

    void executeSurpriseTokenCommand(ISurpriseTokenCommand surpriseTokenCommand);
}
