package br.com.healthtrack.utils;

public class CryptographyTest {
	
	public static void main(String[] args) {
		try {
			System.out.println(CryptographyUtils.cryptography("123456"));
			System.out.println(CryptographyUtils.cryptography("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}