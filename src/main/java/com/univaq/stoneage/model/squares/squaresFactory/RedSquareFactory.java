package com.univaq.stoneage.model.squares.squaresFactory;

import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;

import java.util.ArrayList;

/**
 * RedSquareFactory is responsible for the squares creation if the game mode is red.
 */
public class RedSquareFactory implements ISquareFactory {
    /**
     * The game mode
     */
    private final GameMode mode;

    /**
     * Constuctor.
     *
     * @param mode The game mode
     */
    public RedSquareFactory(GameMode mode) {
        this.mode = mode;
    }

    /**
     * Create all the game squares for the red game mode.
     *
     * @return The game squares
     */
    @Override
    public ArrayList<MSquare> createSquares() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MSquare.class.getSimpleName(), "rossa");
        ArrayList<MSquare> squares = dao.findAll();
        for (MSquare square : squares) {
            //square.setupSquare(mode);
        }
        return squares;
    }
}
