package br.com.ledbass.budgetControl.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class have methods to read and store properties from a .properties file
 * @author marcio.silva
 *
 */
public class Configurator {
	/*
	 * this is where the file is stored
	 */
	private static String url = "config/config.properties";
	
	private String chosenUrl;
	
	/**
	 * @return the chosenUrl
	 */
	public String getChosenUrl() {
		return chosenUrl;
	}

	/**
	 * @param chosenUrl the chosenUrl to set
	 */
	public void setChosenUrl(String chosenUrl) {
		this.chosenUrl = chosenUrl;
	}
	
	/**
	 * Get the .properties file URL
	 * @return
	 */
	private String getUrl() {
		String urlToUse = "";
		
		if (this.chosenUrl != null || !this.chosenUrl.isEmpty()) {
			urlToUse = chosenUrl;
			
		} else {
			urlToUse = url;
		}
		
		return urlToUse;
	}

	/**
	 * Get a boolean value set on the config.properties file, 0 for {@code FALSE}
	 *  and 1 for {@code TRUE}
	 * @param key the key where the value is stored
	 * @return a configured boolean value 
	 */
	public boolean getBooleanValueByKey(String key) {
		int value;
		Properties properties = new Properties();
		InputStream inputStream;
		boolean result = false;
		String urlToUse = getUrl();
		
		try {
			inputStream = new FileInputStream(urlToUse);
			properties.load(inputStream);
			value = Integer.parseInt(properties.getProperty(key));
			
			if (value > 0) {
				result = true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error while loading file, error: " 
					+ e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error while reading the file, error: " 
					+ e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * This method gets a value stored in the .properties file
	 * @param key a {@link String} value key where the properties is stored
	 * @return a {@link String} with the desired value or and empty 
	 * 			{@link String} if no key is found at .properties file
	 */
	public String getPropertiesValueByKey(String key) {
		String result = "";
		Properties properties = new Properties();
		InputStream inputStream;
		
		String urlToUse = getUrl();
		
		try {
			inputStream = new FileInputStream(urlToUse);
			//load the properties file
			properties.load(inputStream);
			//get the value of the key
			result = properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error while loading file, error: " 
					+ e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error while reading the file, error: " 
					+ e.getMessage());
		}
		
		return result;
	}
	
	/**
	 * This method get an array of values under a key in the config.properties file
	 * @param key A {@link String} key to retrieve the array
	 * @return A {@link String}{@code []} with the values
	 */
	public String[] getPropertiesArrayByKey(String key) {
		String[] resultList = null;
		
		String result = getPropertiesValueByKey(key);
		resultList = result.split(",");
		
		if (resultList != null) {
			for (int i = 0; i < resultList.length; i++) {
				resultList[i] = resultList[i].trim();
			}
			
		}
		
		return resultList;
	}
	
	/**
	 * This method get a {@link List} of values under a key in the config.properties file
	 * @param key A {@link String} key to retrieve the array
	 * @return A {@link List} of {@link String} with the values
	 */
	public List<String> getPropertiesListByKey(String key) {
		List<String> resultList = new ArrayList<String>();
		
		String rawResult = getPropertiesValueByKey(key);
		String[] result = rawResult.split(",");
		
		if (rawResult != null) {
			for (int i = 0; i < result.length; i++) {
				resultList.add(result[i].trim());
			}
		}
		
		return resultList;
	}
	
	/**
	 * This method stores a value under a certain key in a .properties file
	 * @param key A {@link String} key name where the value should be stored
	 * @param value A {@link String} with the value to be stored
	 */
	public void setPropertiesValueByKey(String key, String value){
		OutputStream outputStream = null;
		Properties properties = new Properties();
		
		try {
			outputStream = new FileOutputStream(url);
			//set the property to be stored
			properties.setProperty(key, value);
			//store the property
			properties.store(outputStream, null);
		
		} catch (FileNotFoundException e) {
			System.out.println("Error while loading file, error: " 
					+ e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error while reading the file, error: " 
					+ e.getMessage());
			
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					System.out.println("Error while trying to close the "
							+ "OutputStream, error: " + e.getMessage());
				}
			}
		}
	}
	
	/**
	 * This method converts a {@link List}{@code <}{@link String}{@code >} into 
	 * 		{@link String} and stores its content separated by {@code ", "}
	 * @param key A {@link String} key to store the value
	 * @param value A {@link List} of {@link String} with the values to be stored
	 */
	public void setPropertiesListByKey(String key, List<String> value) {
		String toStore = "";
		
		if (value.isEmpty() || value.size() < 0) {
			throw new NullPointerException("No elements found on the received List");
		
		} else {
			for (int i = 0; i < value.size(); i++) {
				
				if (value.size() == i) {
					toStore += value.get(i);
					
				} else {
					toStore += value.get(i) + ", ";
				}
			}
			setPropertiesValueByKey(key, toStore);
		}
	}
	
	/**
	 * This method converts a {@link Array} of {@link String} into {@link String}
	 * 		and stores its content separated by {@code ", "}
	 * @param key A {@link String} key to store the value
	 * @param value A {@link Array} of {@link String} with the values to be stored
	 */
	public void setPropertiesArrayByKey(String key, String[] value) {
		String toStore = "";
		
		if (value.length == 0 || value.equals("")) {
			throw new NullPointerException("No elements found on the received array");
		
		} else {
			
			for (int i = 0; i < value.length; i++) {
				if (i == value.length) {
					toStore += value[i];
							
				} else {
					toStore += value[i] + ", ";
				}
			}
			
			setPropertiesValueByKey(key, toStore);
		}
	}
}
