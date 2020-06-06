package com.univaq.stoneage.model.squares.surpriseToken.surpriseTokenExecutionStrategyFactory;

import com.univaq.stoneage.model.squares.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.model.squares.surpriseToken.surpriseTokenExecutionStrategies.SurpriseCommandExecutionStrategy;

public interface MSurpriseCommandExecutionStrategyFactory {
    SurpriseCommandExecutionStrategy createExecutionStrategy(ISurpriseTokenCommand SurpriseTokenCommand);
}
