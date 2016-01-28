package kernel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

	/*
	 * 
	 * Encode argument with sha1 algorithm
	 * 
	 * @param key : string to encode
	 * 
	 * @return (string) hexadecimal 32-bit value
	 */
	
	public static String getEncodedString(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
	
	/*
	 * 
	 * Test a string and an encoded value (hexadecimal string)
	 * 
	 * @param clearText : the uncoded string to test
	 * 
	 * @param encodedText : the encoded string with sha1 algorithm to test
	 * 
	 * @return true if clearText equals encodedText false otherwise
	 */
	
	public static boolean testString(String clearPwd, String encodedPwd) throws NoSuchAlgorithmException {
		String encodedTestPassword = SHA1.getEncodedString(clearPwd);
		return (encodedTestPassword.equals(encodedPwd));
	}

}
