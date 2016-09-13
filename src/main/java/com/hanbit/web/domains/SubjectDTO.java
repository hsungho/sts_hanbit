package com.hanbit.web.domains;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @date   :2016. 7. 26.
 * @author :ckan
 * @file   :SubjectBean.java 
 * @story  :
 */
@Component
@Data
public class SubjectDTO implements Serializable{
	@Getter @Setter private int subjSeq,birth;
	@Getter @Setter private String id,subjName,pw,name,regDate,gender,ssn,profileImg,role,email,phone;
}
