package com.perficient.trainingsystem.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void test() {
		Company company = new Company();
		company.setId("123");
		company.setIntroduce("perficient");
		company.setLogo("IT");
		company.setName("perficient");
		company.setPhone("0571-1234567");
		company.setStatus("online");
		company.setType("IT");
		company.getId();
		company.getIntroduce();
		company.getLogo();
		company.getName();
		company.getPhone();
		company.getStatus();
		company.getType();
		company.getAddress();
		company.toString();
	}

}
