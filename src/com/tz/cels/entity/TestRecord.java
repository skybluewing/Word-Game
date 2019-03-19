package com.tz.cels.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class TestRecord implements Comparable<TestRecord>, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2998233577074787928L;
	
	private Date date = new Date();//����ʱ��
	private long minute;//���Է�����
	private long second;//��������
	private int totalNumber;//����������
	private int finishedNumber;//�������
	private int correctCount;//��ȷ����
	private int wrongCount;//��������
	private List<BaseTerm> list; 
	
	
	
	public TestRecord() {
		super();
	}


	
	



	public TestRecord(List<BaseTerm> list) {
		super();
		this.list = list;
	}







	public TestRecord(Date date, long minute, long second, int totalNumber, int finishedNumber, int correctCount,
			int wrongCount, List<BaseTerm> list) {
		super();
		this.date = date;
		this.minute = minute;
		this.second = second;
		this.totalNumber = totalNumber;
		this.finishedNumber = finishedNumber;
		this.correctCount = correctCount;
		this.wrongCount = wrongCount;
		this.list = list;
	}







	public List<BaseTerm> getList() {
		return list;
	}







	public void setList(List<BaseTerm> list) {
		this.list = list;
	}







	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public long getMinute() {
		return minute;
	}



	public void setMinute(long minute) {
		this.minute = minute;
	}



	public long getSecond() {
		return second;
	}



	public void setSecond(long second) {
		this.second = second;
	}



	public int getTotalNumber() {
		return totalNumber;
	}



	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}



	public int getFinishedNumber() {
		return finishedNumber;
	}



	public void setFinishedNumber(int finishedNumber) {
		this.finishedNumber = finishedNumber;
	}



	public int getCorrectCount() {
		return correctCount;
	}



	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}



	public int getWrongCount() {
		return wrongCount;
	}



	public void setWrongCount(int wrongCount) {
		this.wrongCount = wrongCount;
	}



	@Override
	public int compareTo(TestRecord o) {
		return new CompareToBuilder().append(this.date,o.date).toComparison();
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("����ʱ�䣺").append(date).append("\n");
		builder.append("����ʱ����").append(minute).append("����").append(second).append("��").append("\n");
		builder.append("������������").append(totalNumber).append("���������").append(finishedNumber).append("\n");
		builder.append("��ȷ������").append(correctCount).append("���������").append(wrongCount).append("\n");
		builder.append("���β����������£�").append(list).append("\n");
		return builder.toString();
	}
	
	
	
}
