package com.assignment.cryptocurrency.util;

import java.util.HashMap;
import java.util.Map;

public final class Storage {
	
	private static Map<String, Object> store=new HashMap<String,Object>();
	
	private Storage() {};
	
	public static Storage getInstance() 
	{
		return new Storage();
	}
	
	public void save(String key, Object value) 
	{
		store.put(key, value);
	}
	
	public Object get(String key) {
		return store.get(key);
	}
	

}
