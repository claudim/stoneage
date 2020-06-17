package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MISquareSetupStrategy;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory.MISetupSquareStrategyFactory;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory.RedSetupSquareFactory;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;

public class MRedBoard extends MBoard {
    public MRedBoard() {
        makeSquares();
    }

    private void makeSquares() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MSquare.class.getSimpleName(), "rossa");
        m_squares = dao.findAll();
        MISetupSquareStrategyFactory setupSquareStrategyFactory = new RedSetupSquareFactory();
        for (MSquare square : m_squares) {
            MISquareSetupStrategy setupSquareStrategy = setupSquareStrategyFactory.getSetupSquareStrategy(square);
            setupSquareStrategy.setupSquare(square);
        }
    }


}
