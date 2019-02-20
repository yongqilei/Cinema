package com.movie.pncinema.us.test;

import org.junit.Test;

import com.alibaba.druid.filter.config.ConfigTools;

public class DecryptTest {

	@Test
	public void test1() {
		String password = "kq0r8RIgixNICNByVI89xL+DNf77oXGS02FdFUmKRYsGIRRRTZ6QkxjfFuMLiiNOVmDUwhfJoJtvZ38c2dGycA==";
		String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ+g9Px1a/iO8RFlEIxRh6LP+3yqJrJR1trEhbocP1XnCTBO1yjZJsQTYLoHrRDXA74JUKl97c6H0bgWnfwF37MCAwEAAQ==";
		String decPass;
		try {
			decPass = ConfigTools.decrypt(publicKey, password).toString();
			System.out.println(decPass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
