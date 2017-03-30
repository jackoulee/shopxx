package com.shop.entity;

import java.util.Date;

public class Count {

	private String countId;
	private Integer countNumber;//每日访问人次
	private String countDay;//最近一天的时间
	private Date countDaytime;//新的一天重新统计时添加到数据库的时间
	public String getCountId() {
		return countId;
	}
	public void setCountId(String countId) {
		this.countId = countId;
	}
	public Integer getCountNumber() {
		return countNumber;
	}
	public void setCountNumber(Integer countNumber) {
		this.countNumber = countNumber;
	}
	public String getCountDay() {
		return countDay;
	}
	public void setCountDay(String countDay) {
		this.countDay = countDay;
	}
	public Date getCountDaytime() {
		return countDaytime;
	}
	public void setCountDaytime(Date countDaytime) {
		this.countDaytime = countDaytime;
	}
	
	
}
