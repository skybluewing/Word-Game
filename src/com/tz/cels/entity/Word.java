package com.tz.cels.entity;

public class Word extends BaseTerm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2353275780690096682L;
	private char first;//Ê××ÖÄ¸
	
	
	
	public Word() {
		super();
		this.first = getEn().trim().toUpperCase().charAt(0);
	}
	
	public Word(long id, String en, String cn) {
		super(id, en, cn);
		this.first = getEn().trim().toUpperCase().charAt(0);
	}
	
	public Word(String en, String cn) {
		super(en, cn);
		this.first = getEn().trim().toUpperCase().charAt(0);
	}

	public char getFirst() {
		return first;
	}

	public void setFirst(char first) {
		this.first = first;
	}

	
}
