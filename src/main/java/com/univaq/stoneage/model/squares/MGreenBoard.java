package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MISquareSetupStrategy;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory.GreenSetupSquareFactory;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategyFactory.MISetupSquareStrategyFactory;
import com.univaq.stoneage.persistence.IPersistentGeneric;
import com.univaq.stoneage.persistence.PersistenceServiceFactory;

public class MGreenBoard extends MBoard {
    public MGreenBoard() {
        makeSquares();
    }

    private void makeSquares() {
        IPersistentGeneric dao = PersistenceServiceFactory.getInstance().getPersistenceClass(MSquare.class.getSimpleName(), "verde");
        m_squares = dao.findAll();
        MISetupSquareStrategyFactory setupSquareStrategyFactory = new GreenSetupSquareFactory();
        for (MSquare square : m_squares) {
            MISquareSetupStrategy setupSquareStrategy = setupSquareStrategyFactory.getSetupSquareStrategy(square);
            setupSquareStrategy.setupSquare(square);
        }
    }
}
