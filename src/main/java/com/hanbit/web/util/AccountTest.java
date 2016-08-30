package com.hanbit.web.util;

import com.hanbit.web.account.AccountMemberVO;
import com.hanbit.web.account.AccountServiceImpl;

public class AccountTest {
	public static void main(String[] args) {
		AccountMemberVO a = AccountServiceImpl.getInstance().findByAccountNo(198392);
		
		System.out.println(a.getName());
	}
}
