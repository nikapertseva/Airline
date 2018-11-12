package ua.nure.pertseva.airline.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

public class HashTest {

	@Test
	void testHash() throws NoSuchAlgorithmException {
		String str = "123";
		String result = "35e7b2a3d597628359b08fb7e2806c2b";
		String hashCode = Hash.hash(str);
		assertEquals(hashCode, result);
	}

}
