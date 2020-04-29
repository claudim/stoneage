package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.players.MPlayer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.beans.PropertyChangeListener;

@Entity
@DiscriminatorValue(value = "buildingsitesquare")
public class MBuildingSiteSquare extends MSquare {

    public MBuildingSiteSquare() {
//        super();
    }

    public MBuildingSiteSquare(String a_squareName) {
        super(a_squareName);
    }


    @Override
    public void doAction(MPlayer mPlayer) {

    }

    @Override
    public String getSquareType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {

    }

    @Override
    public void notifyPropertyChange(Object object) {
        //no-op
    }
}
