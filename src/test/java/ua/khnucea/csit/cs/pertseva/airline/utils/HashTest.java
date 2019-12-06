package ua.khnucea.csit.cs.pertseva.airline.utils;


import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HashTest {

	@Test
	public void testHash() throws NoSuchAlgorithmException {
		String str = "123";
		String result = "35e7b2a3d597628359b08fb7e2806c2b";
		String hashCode = Hash.hash(str);
		assertEquals(hashCode, result);
	}

}
