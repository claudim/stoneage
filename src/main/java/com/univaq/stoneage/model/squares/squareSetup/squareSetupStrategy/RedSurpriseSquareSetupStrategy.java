package com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy;

import com.univaq.stoneage.model.players.playerFactory.IPlayerFactory;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.surpriseSquare.MSurpriseSquare;
import com.univaq.stoneage.model.squares.surpriseSquare.surpriseToken.*;

import java.util.ArrayList;

public class RedSurpriseSquareSetupStrategy implements MISquareSetupStrategy {
    @Override
    public void setupSquare(MSquare square) {
        MSurpriseSquare surpriseSquare = (MSurpriseSquare) square;
        // surpriseSquare.setSupport(new PropertyChangeSupport(this)); // to implement the observer pattern
        IPlayerFactory playerFactory = new MPlayerFactory();
        ArrayList<ISurpriseTokenCommand> surpriseTokens = new ArrayList<>();

        surpriseTokens.add(new TakeAnotherTurnSurpriseTokenCommand(playerFactory));
        surpriseTokens.add(new GoToBuildingSiteSquareSurpriseTokenCommand(null));
        surpriseTokens.add(new TwoResourcesSupriseTokenCommand(playerFactory));
        surpriseTokens.add(new SkipTurnSurpriseTokenCommand(playerFactory));

        surpriseSquare.setM_supriseTokens(surpriseTokens);

    }
}
