package com.univaq.stoneage.Model;

public class DieFaceTokenForest extends TokenForest {

    private int m_dieFace;

    public DieFaceTokenForest(int position, int tokenForestValue) {
        super(position);
        this.m_dieFace = tokenForestValue;
    }

    public int getM_dieFace() {
        return m_dieFace;
    }

    public void setM_dieFace(int m_dieFace) {
        this.m_dieFace = m_dieFace;
    }

    @Override
    public Object getValue() {
        return this.m_dieFace;
    }
}