package com.univaq.stoneage.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tokenforest")
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "tokenforest")
public abstract class MTokenForest<T> implements Serializable {

    @Transient
    public final boolean FACEDOWN = false;
    @Transient
    public final boolean FACEUP = true;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int token_id;
    @Column(name = "state")
    private boolean m_state;
    @Column(name = "position")
    private int m_position;

    public MTokenForest() {
    }

    public MTokenForest(int position) {
        this.m_state = FACEDOWN;
        this.m_position = position;
    }

    public int getToken_id() {
        return token_id;
    }

    public void setToken_id(int token_id) {
        this.token_id = token_id;
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
