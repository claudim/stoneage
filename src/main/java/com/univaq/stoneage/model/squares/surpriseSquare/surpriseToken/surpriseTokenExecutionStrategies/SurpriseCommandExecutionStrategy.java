package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.surpriseTokenExecutionStrategies;

import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;

public interface SurpriseCommandExecutionStrategy {

    void executeSurpriseTokenCommand(ISurpriseTokenCommand surpriseTokenCommand);
}
