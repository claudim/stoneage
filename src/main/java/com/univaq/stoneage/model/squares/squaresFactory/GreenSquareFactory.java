package com.univaq.stoneage.model.squares.squaresFactory;

import com.univaq.stoneage.dao.IGenericDAO;
import com.univaq.stoneage.dao.PersistenceServiceFactory;
import com.univaq.stoneage.model.gameMode.GameMode;
import com.univaq.stoneage.model.squares.MSquare;

import java.util.ArrayList;

/**
 * GreenSquareFactory is responsible for the squares creation if the game mode is green.
 */
public class GreenSquareFactory implements ISquareFactory {
    /**
     * The game mode
     */
    private final GameMode mode;

    /**
     * Constuctor.
     *
     * @param mode The game mode
     */
    public GreenSquareFactory(GameMode mode) {
        this.mode = mode;
    }

    /**
     * Create all the game square according to the green game mode.
     *
     * @return The game square for the mode
     */
    @Override
    public ArrayList<MSquare> createSquares() {
        IGenericDAO dao = PersistenceServiceFactory.getInstance().getDao(MSquare.class.getSimpleName(), "verde");
        ArrayList<MSquare> squares = dao.findAll();
        for (MSquare square : squares) {
            square.setupSquare(mode);
        }
        return squares;
    }
}
