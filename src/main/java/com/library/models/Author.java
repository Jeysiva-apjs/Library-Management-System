package com.library.models;

public class Author {
	
	private String name;
	
	public Author(String name) {
		
		if(name.isEmpty())
			throw new IllegalArgumentException("Author name cannot be null");
		
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name.isEmpty())
			throw new IllegalArgumentException("Author name cannot be null");
		
		this.name = name;
	}
	
}
