package com.univaq.stoneage.Model;

public class TokenForest {
	public final boolean FACEDOWN =  false;
	public final boolean FACEUP =  true;

	private boolean m_state;
	private String m_value;
	public Position m_occupedBy;

	public TokenForest(String tokenForestValue) {
		this.m_state = FACEDOWN; // false  = faceDown; true = faceUp
		this.m_value = tokenForestValue;

	}

	public boolean getState() {
		return m_state;
	}

	public void setState(boolean aFaceUpOrDown) {
		this.m_state = aFaceUpOrDown;
	}

	public String getValue() {
		return this.m_value;
		//throw new UnsupportedOperationException();
	}
}