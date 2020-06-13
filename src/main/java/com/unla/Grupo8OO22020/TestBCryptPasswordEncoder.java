package com.unla.Grupo8OO22020;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCryptPasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder(4); 
		System.out.println(pe.encode("user"));

	}
}
