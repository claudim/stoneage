package com.univaq.stoneage.model.gameState;

import com.univaq.stoneage.model.squares.ActionResult;

public class SimpleStateFactory implements IStateFactory {

    @Override
    public IGameState createState(ActionResult actionResult, GameState gameState) {
        IGameState iGameState;
        switch (actionResult) {
            case HUT_TOKEN_CHECK_DONE: {
                iGameState = new WaitingForHutTokenGameState(gameState);
                break;
            }
            case MISSING_RESOURCE: {
                iGameState = new WaitingForPreyGameState(gameState);
                break;
            }
            case GOT_RESOURCE: {
                iGameState = new EndTurnGameState(gameState);
                break;
            }
            default: //ACTION_DONE
            {
                iGameState = new EndTurnGameState(gameState);
                break;
            }

        }
        return iGameState;
    }
}
