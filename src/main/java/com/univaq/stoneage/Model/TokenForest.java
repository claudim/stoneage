package com.univaq.stoneage.Model;

public abstract class TokenForest<T> {

    public final boolean FACEDOWN = false;
    public final boolean FACEUP = true;
    private boolean m_state;
    private int m_position;

    public TokenForest(int position) {
        this.m_state = FACEDOWN;
        this.m_position = position;
    }

    public int getM_position() {
        return m_position;
    }

    public void setM_position(int m_position) {
        this.m_position = m_position;
    }

    public boolean getState() {
        return m_state;
    }

    public void setState(boolean aFaceUpOrDown) {
        this.m_state = aFaceUpOrDown;
    }

    public abstract T getValue();

    public abstract void setValue(T value);

}
