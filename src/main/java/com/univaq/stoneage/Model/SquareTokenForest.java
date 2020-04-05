package com.univaq.stoneage.Model;

public class SquareTokenForest extends TokenForest {

    private String m_squareName;

    public SquareTokenForest(int position, String tokenForestValue) {
        super(position);
        this.m_squareName = tokenForestValue;
    }

    public String getM_squareName() {
        return m_squareName;
    }

    public void setM_squareName(String m_squareName) {
        this.m_squareName = m_squareName;
    }

    @Override
    public Object getValue() {
        return this.m_squareName;
    }
}