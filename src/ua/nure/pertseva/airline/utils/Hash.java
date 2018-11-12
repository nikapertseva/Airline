package ua.nure.pertseva.airline.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class for hashing password.
 *
 * @author Pertseva Veronika
 */
public class Hash {

	private static final String SALT = "hashSalt";

	private static final String ALGORITHM = "MD5";

	/**
	 * Method for hashing password.
	 *
	 * @param input - password
	 * @return hash-code
	 * @throws NoSuchAlgorithmException
	 */
	public static String hash(String input) throws NoSuchAlgorithmException {

		String passWithSalt = input + SALT;
		MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
		digest.update(passWithSalt.getBytes());
		byte[] hash = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
		}
		String generatedPassword = sb.toString();
		return generatedPassword;
	}
}
