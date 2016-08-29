package com.hanbit.web.subject;

import java.io.Serializable;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectBean.java 
 * @story  :
 */
public class SubjectVO implements Serializable{
	private static final long serialVersionUID = 1L;
	String id,major,subjects;
    int subjSeq;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public int getSubjSeq() {
		return subjSeq;
	}

	public void setSubjSeq(int subjSeq) {
		this.subjSeq = subjSeq;
	}
}
