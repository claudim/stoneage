package com.univaq.stoneage.Model;

import java.util.Vector;

public class Square {
	private String m_name;
	private Square m_nextSquare;

	//public Vector<Marker> m_isOn = new Vector<Marker>();
	//public Board m_contains;

	public Square(String m_name) {
		this.m_name = m_name;
		this.m_nextSquare = null;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Square getM_nextSquare() {
		return m_nextSquare;
	}

	public void setM_nextSquare(Square m_nextSquare) {
		this.m_nextSquare = m_nextSquare;
	}
}