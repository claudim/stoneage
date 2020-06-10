package com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.surpriseTokenExecutionStrategyFactory;

import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.ISurpriseTokenCommand;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.surpriseTokenExecutionStrategies.AddOnStartTurnAbilityToPlayerStrategy;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.surpriseTokenExecutionStrategies.SurpriseCommandExecutionStrategy;

public class MSimpleSurpriseCommandExecutionStrategyFactory implements MSurpriseCommandExecutionStrategyFactory {
    @Override
    public SurpriseCommandExecutionStrategy createExecutionStrategy(ISurpriseTokenCommand SurpriseTokenCommand) {

        SurpriseCommandExecutionStrategy surpriseCommandExecutionStrategy = null;
        switch (SurpriseTokenCommand.getClass().getSimpleName()) {
            case "TwoResourcesSurpriseTokenCommand":
                surpriseCommandExecutionStrategy = new AddOnStartTurnAbilityToPlayerStrategy();
                break;
            default:
        }
        return surpriseCommandExecutionStrategy;
    }
}
