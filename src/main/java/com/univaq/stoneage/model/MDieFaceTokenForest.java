package com.univaq.stoneage.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@Table(name = "diefacetokenforest")
@DiscriminatorValue("diefacetokenforest")
public class MDieFaceTokenForest extends MTokenForest<Integer> {
    public MDieFaceTokenForest() {
    }

    @Column(name = "die_value")
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