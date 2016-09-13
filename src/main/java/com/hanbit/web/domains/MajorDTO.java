package com.hanbit.web.domains;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
public class MajorDTO {
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String majorTitle,id,pw,name,regDate,gender,ssn,profileImg,role,email,phone;
	@Getter @Setter private int majorSeq,birth;
}
