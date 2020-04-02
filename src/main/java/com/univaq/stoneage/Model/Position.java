package com.univaq.stoneage.Model;

public class Position {
	private int m_id;
	//public Grid m_contains;
	private TokenForest m_tokenForest;

	public Position(int m_id) {
		this.m_id = m_id;

		//TODO create automaticamente i token forest sulla base dei valori presenti da qualche parte
		createTokenForestNaive(m_id);
	}

	private void createTokenForestNaive(int m_id) {
		if (m_id<16 && m_id>=0)
		{
		switch (m_id) {
			case 7:
				this.m_tokenForest = new TokenForest("cantiere");
				break;
			case 8:
				this.m_tokenForest = new TokenForest("cane");
				break;
			case 9:
				this.m_tokenForest = new TokenForest("sorpresa");
				break;
			case 10:
				this.m_tokenForest = new TokenForest("prateria");
				break;
			case 11:
				this.m_tokenForest = new TokenForest("foresta");
				break;
			case 12:
				this.m_tokenForest = new TokenForest("artigiano");
				break;
			case 13:
				this.m_tokenForest = new TokenForest("cava");
				break;
			case 14:
				this.m_tokenForest = new TokenForest("campoDiBattaglia");
				break;
			case 15:
				this.m_tokenForest = new TokenForest("fiume");
				break;
			case 0:
				this.m_tokenForest = new TokenForest("mercato");
				break;
			default:
				this.m_tokenForest = new TokenForest(Integer.toString(m_id));
				break;
		}
		}
	}

	public TokenForest getTokenForest() {
		return this.m_tokenForest;
	}

	public int getIdPosition() { return m_id; }
}