package com.univaq.stoneage.Model;

public class MDieFaceTokenForest extends MTokenForest<Integer> {

    private int m_dieFace;

    public MDieFaceTokenForest(int position, int tokenForestValue) {
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
    public Integer getValue() {
        return this.m_dieFace;
    }

    @Override
    public void setValue(Integer value) {
        this.m_dieFace = value;
    }
}