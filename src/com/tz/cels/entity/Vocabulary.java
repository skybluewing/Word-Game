package com.tz.cels.entity;

public class Vocabulary extends BaseTerm {

	private static final long serialVersionUID = 6896241654613683892L;
	private String acronym;// ¥ ª„Àı–¥

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Vocabulary() {
		super();
	}

	public Vocabulary(long id, String en, String cn, String acronym) {
		super(id, en, cn);
		this.acronym = acronym;
	}

	public Vocabulary(String en, String cn, String acronym) {
		super(en, cn);
		this.acronym = acronym;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(getEn()).append(getCn()).append(acronym).append("]");
		return builder.toString();
	}
	
	

}
