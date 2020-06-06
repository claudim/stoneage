package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.nextId.IGetNextIdStrategy;
import com.univaq.stoneage.model.nextId.RandomStrategy;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.model.squares.surpriseToken.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;

@Entity
@DiscriminatorValue(value = "surprisesquare")
public class MSurpriseSquare extends MSquare {

    @Transient
    private ArrayList<ISurpriseTokenCommand> m_supriseTokens;

    // after object creation from Hibernate this method is called
    @PostLoad
    public void setupSquare() {
        // super.support = new PropertyChangeSupport(this); // to implement the observer pattern

        m_supriseTokens = new ArrayList<>();

        m_supriseTokens.add(new TakeAnotherTurnSurpriseTokenCommand(null));
        m_supriseTokens.add(new GoToBuildingSiteSquareSurpriseTokenCommand(null));
        m_supriseTokens.add(new TwoResourcesSupriseTokenCommand(null));
        m_supriseTokens.add(new SkipTurnSurpriseTokenCommand(null));

    }

    @Override
    public ActionResult doAction(MPlayer mPlayer) {

        IGetNextIdStrategy getNextIdStrategy = new RandomStrategy(); // todo meglio una factory??
        int nextId = getNextIdStrategy.getNextId(Collections.singletonList(m_supriseTokens));

        ISurpriseTokenCommand supriseToken = m_supriseTokens.get(nextId);

        try {
            supriseToken.setReceiver(mPlayer);
            // scegli una sorpresa
            //TwoResourcesSupriseTokenCommand supriseToken = new TwoResourcesSupriseTokenCommand(mPlayer);
            // SkipTurnSurpriseTokenCommand supriseToken = new SkipTurnSurpriseTokenCommand(mPlayer);
            //GoToBuildingSiteSquareSurpriseTokenCommand supriseToken = new GoToBuildingSiteSquareSurpriseTokenCommand();
            return supriseToken.execute();

        } catch (Exception e) {
            System.out.println("Errore set receiver in doAction MSurpriseSquare");
        }
        return ActionResult.ACTION_DONE;
    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
