package com.univaq.stoneage.model.gameInitializer;

import com.univaq.stoneage.model.MStoneAgeGame;
import com.univaq.stoneage.model.forestTokens.grid.MGrid;
import com.univaq.stoneage.model.forestTokens.grid.MRedGrid;
import com.univaq.stoneage.model.gameGoal.IGameGoalStrategy;
import com.univaq.stoneage.model.gameGoal.ThreeHutTokenGoalStrategy;
import com.univaq.stoneage.model.gameState.GameState;
import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.shuffle.IShuffleStrategyFactory;
import com.univaq.stoneage.model.shuffle.RedShuffleStrategyFactory;
import com.univaq.stoneage.model.squares.MBoard;
import com.univaq.stoneage.model.squares.MRedBoard;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.squareSetup.squareSetupStrategy.MResourceSquareRedSetupStrategy;

import java.beans.PropertyChangeSupport;

public class RedGameInitializer implements IGameInitializer {
    @Override
    public void initializeStoneAgeGame(MStoneAgeGame mStoneAgeGame, int aNumPlayers, String aMarkerName) {
        //creates gamestate
        GameState gameState = makeGameState();
        mStoneAgeGame.setM_gameState(gameState);

        // create support to be observable
        mStoneAgeGame.setSupport(new PropertyChangeSupport(mStoneAgeGame));

        mStoneAgeGame.setNumPlayer(aNumPlayers);
        MResourceSquareRedSetupStrategy.setPlayersNumber(aNumPlayers);

        // creates board and squares
        MBoard board = makeBoard();
//        ArrayList<MSquare> squares = makeSquares();
//        board.setM_squares(squares);
        mStoneAgeGame.setM_board(board);

        MSquare startSquare = board.getStartSquare();

        //players
        MPlayerFactory mPlayerFactory = new MPlayerFactory();
        mPlayerFactory.createPlayers(aNumPlayers, aMarkerName);
        mPlayerFactory.setStartSquare(startSquare);

        // creates grid and forestTokens
        MGrid grid = makeGrid();
//        grid.setM_tokens(makeForestTokens());
//        grid.setM_shuffleStrategy(makeShuffleStrategy());
//        grid.setM_nextForestTokenStrategy(makeNextForestTokenStrategy());

        IShuffleStrategyFactory shuffleStrategyFactory = new RedShuffleStrategyFactory();
        grid.setM_shuffleStrategy(shuffleStrategyFactory.getShuffleStrategy(mStoneAgeGame.getNumPlayer()));
        mStoneAgeGame.setM_grid(grid);

        mStoneAgeGame.setM_gameGoalStrategy(makeGameGoalStrategy());

        INextPlayerStrategy nextPlayerStrategy = makeTurningStrategy();
        nextPlayerStrategy.setNumberOfPlayer(aNumPlayers);
        mStoneAgeGame.setM_nextPlayerStrategy(nextPlayerStrategy);

        // set the right strategy to identify the players order and set the players.
        mStoneAgeGame.setM_players(nextPlayerStrategy.sortPlayers(mPlayerFactory.getPlayers()));

        gameState.initialize();
    }

    @Override
    public MBoard makeBoard() {
        return new MRedBoard();
    }

//    @Override
//    public ArrayList<MSquare> makeSquares() {
//        RedSquareFactory redSquareFactory = new RedSquareFactory(new GameMode("rossa"));
//        return redSquareFactory.createSquares();
//    }

//    @Override
//    public MGrid makeGrid() {
//        return new MGrid(new GameMode("rossa"));
//    }

    @Override
    public MGrid makeGrid() {
        return new MRedGrid();
    }

//    @Override
//    public ArrayList<MTokenForest> makeForestTokens() {
//        ITokenForestFactory forestTokenFactory = new RedTokenForestFactory();
//        return forestTokenFactory.createForestTokens();
//    }

//    public IShuffleStrategy makeShuffleStrategy() {
//        IShuffleStrategy externalShuffling = new RandomOrgAdapter();
//        IShuffleStrategy localShuffling = new CollectionsShuffleStrategy();
//        return new ShufflingRedirectionProxy(externalShuffling, localShuffling);
//    }

//    public MINextForestTokenStrategy makeNextForestTokenStrategy() {
//        return new MRandomNextForestTokenStrategy();
//    }

    public GameState makeGameState() {
        return new GameState();
    }

    public IGameGoalStrategy makeGameGoalStrategy() {
        return new ThreeHutTokenGoalStrategy();
    }

    public INextPlayerStrategy makeTurningStrategy() {
        return new MHumanPlayersFirstStrategy();
    }
}
