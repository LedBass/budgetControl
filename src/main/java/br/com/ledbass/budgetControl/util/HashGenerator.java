package br.com.ledbass.budgetControl.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * 
 * @author marcio.silva
 *
 */
public class HashGenerator {
	
	private static Logger logger = Logger.getLogger(HashGenerator.class);
	
	/**
	 * 
	 * @param toHash
	 * @return
	 */
	public static String generateHashFromAString(String toHash) {
		logger.info("Creating hashcode for a string");
		String result = "";
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(toHash.getBytes("UTF-8"));
			
			byte[] hash = digest.digest();
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				
				if (hex.length() == 1) {
					sb.append('0');
				}
				
				sb.append(hex);
			}
			
			result = sb.toString();
			
			logger.info("Hashcode created successfully");
			
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error while creating the hashcode, "
					+ "the given algorithm, error: " + e.getMessage());
			logger.error("Stack trace: " + e.getStackTrace());
			
		} catch (UnsupportedEncodingException e) {
			logger.error("Error while trying to encode a string, error: " + e.getMessage());
			logger.error("Stack trace: " + e.getStackTrace());
		}
		
		return result;
	}
}
