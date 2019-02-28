package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {
	private HashMap<String, String> users = new HashMap<>();

	public InMemoryLoginService() {
		users.put("majrul", "123");
		users.put("mintu", "133");
		users.put("neha", "134");
	}

	public boolean isValidUser(String userid, String pass) {
		if (users.containsKey(userid))
			if (users.get(userid).equals(pass))
				return true;
		return false;
	}
}
