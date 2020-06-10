package com.univaq.stoneage.model;

import com.univaq.stoneage.model.playerTurning.INextPlayerStrategy;
import com.univaq.stoneage.model.playerTurning.MHumanPlayersFirstStrategy;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.players.playerFactory.MPlayerFactory;
import com.univaq.stoneage.model.squares.MSquare;
import com.univaq.stoneage.model.squares.buildingSiteSquare.MBuildingSiteSquare;
import com.univaq.stoneage.utility.PlayerType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MHumanPlayersFirstStrategyTest {

    private MPlayerFactory m_playerFactory;
    private ArrayList<MPlayer> m_players;
    private MSquare m_startSquare;
    private INextPlayerStrategy m_nextPlayerStrategy;

    @Test
    void sort() {
        this.m_playerFactory = new MPlayerFactory();
        this.m_players = new ArrayList<>();
        // this.m_startSquare = new MSquare("cantiere");
        this.m_startSquare = new MBuildingSiteSquare("cantiere");

        MPlayer p = this.m_playerFactory.getPlayer(PlayerType.EmulatedPlayer);
        p.createMarker("Jono", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer(PlayerType.HumanPlayer);
        p.createMarker("Martin", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer(PlayerType.EmulatedPlayer);
        p.createMarker("Jada", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer(PlayerType.HumanPlayer);
        p.createMarker("Guff", m_startSquare);
        m_players.add(p);
        this.m_nextPlayerStrategy = new MHumanPlayersFirstStrategy(m_players.size());
        assertEquals(m_players.get(this.m_nextPlayerStrategy.getIndexActivePlayer()).getMarkerName(), "Martin");
        assertEquals(m_players.get(this.m_nextPlayerStrategy.getIndexNextPlayer()).getMarkerName(), "Guff");

        assertEquals(this.m_players.get(0).getMarkerName(), "Martin");
        assertEquals(this.m_players.get(1).getMarkerName(), "Guff");
        assertEquals(this.m_players.get(2).getMarkerName(), "Jono");
        assertEquals(this.m_players.get(3).getMarkerName(), "Jada");


    }
}