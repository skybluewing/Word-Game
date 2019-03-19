package com.tz.cels.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;

public abstract class BaseTerm implements Serializable, Comparable<BaseTerm>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -355111225062287520L;
	private long id;//编号
	private String en;//英文单词
	private String cn;//中文，可能会有多个解释
	//词汇分类
	private String category = "计算机英语";
	
	public BaseTerm() {
		super();
	}

	public BaseTerm(long id, String en, String cn) {
		super();
		this.id = id;
		this.en = en;
		this.cn = cn;
	}

	
	public BaseTerm(String en, String cn) {
		super();
		this.en = en;
		this.cn = cn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((en == null) ? 0 : en.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseTerm other = (BaseTerm) obj;
		if (en == null) {
			if (other.en != null)
				return false;
		} else if (!en.equals(other.en))
			return false;
		return true;
	}

	@Override
	public int compareTo(BaseTerm o) {
		return new CompareToBuilder().append(this.en,o.en).toComparison();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(en).append("   ").append(cn).append("]");
		return builder.toString();
	}


	
	
	
}
