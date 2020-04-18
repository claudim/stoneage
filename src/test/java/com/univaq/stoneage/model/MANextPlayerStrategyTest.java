package com.univaq.stoneage.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MANextPlayerStrategyTest {

    private MPlayerFactory m_playerFactory;
    private ArrayList<MPlayer> m_players;
    private MSquare m_startSquare;
    private MINextPlayerStrategy m_nextPlayerStrategy;

    @Test
    void sort() {
        this.m_playerFactory = new MPlayerFactory();
        this.m_players = new ArrayList<>();
        this.m_startSquare = new MSquare("cantiere");

        MPlayer p = this.m_playerFactory.getPlayer("EmulatedPlayer");
        p.createMarker("Jono", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer("HumanPlayer");
        p.createMarker("Martin", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer("EmulatedPlayer");
        p.createMarker("Jada", m_startSquare);
        m_players.add(p);
        p = this.m_playerFactory.getPlayer("HumanPlayer");
        p.createMarker("Guff", m_startSquare);
        m_players.add(p);
        this.m_nextPlayerStrategy = new MANextPlayerStrategy(m_players);
        assertEquals(this.m_nextPlayerStrategy.getCurrentPlayer().getMarkerName(), "Martin");
        assertEquals(this.m_nextPlayerStrategy.getNextPlayer().getMarkerName(), "Guff");

        assertEquals(this.m_players.get(0).getMarkerName(), "Martin");
        assertEquals(this.m_players.get(1).getMarkerName(), "Guff");
        assertEquals(this.m_players.get(2).getMarkerName(), "Jono");
        assertEquals(this.m_players.get(3).getMarkerName(), "Jada");


    }
}