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
	
	private Date date = new Date();//测试时间
	private long minute;//测试分钟数
	private long second;//测试秒数
	private int totalNumber;//测试总题数
	private int finishedNumber;//完成题数
	private int correctCount;//正确题数
	private int wrongCount;//错误题数
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
		builder.append("测试时间：").append(date).append("\n");
		builder.append("测试时长：").append(minute).append("分钟").append(second).append("秒").append("\n");
		builder.append("测试总题数：").append(totalNumber).append("完成题数：").append(finishedNumber).append("\n");
		builder.append("正确个数：").append(correctCount).append("错误个数：").append(wrongCount).append("\n");
		builder.append("本次测试数据如下：").append(list).append("\n");
		return builder.toString();
	}
	
	
	
}
