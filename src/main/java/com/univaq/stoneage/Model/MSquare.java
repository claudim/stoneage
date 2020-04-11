package com.univaq.stoneage.Model;

public class MSquare {
	private String m_name;
	private MSquare m_nextSquare;

	public MSquare(String m_name) {
		this.m_name = m_name;
		this.m_nextSquare = null;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public MSquare getM_nextSquare() {
		return m_nextSquare;
	}

	public void setM_nextSquare(MSquare m_nextSquare) {
		this.m_nextSquare = m_nextSquare;
	}
}