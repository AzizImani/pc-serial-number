package kernel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	/*
	 * 
	 * Encode argument with md5 algorithm
	 * 
	 * @param key : string to encode
	 * 
	 * @return (string) hexadecimal 32-bit value
	 */

	public static String getEncodedString(String key) throws NoSuchAlgorithmException {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}

	/*
	 * 
	 * Test a string and an encoded value (hexadecimal string)
	 * 
	 * @param clearText : the uncoded string to test
	 * 
	 * @param encodedText : the encoded string with md5 algorithm to test
	 * 
	 * @return true if clearText equals encodedText false otherwise
	 */

	public static boolean testString(String clearText, String encodedText) throws NoSuchAlgorithmException {
		String encodedTestPassword = MD5.getEncodedString(clearText);

		return (encodedTestPassword.equals(encodedText));
	}
}