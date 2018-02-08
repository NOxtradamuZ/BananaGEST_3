package com.generation.jwd.beans;

public class Project {

	private int id;
	private String name;
	private String description;
	private String date_start;
	private String date_end;
	private int id_user;
	
	public Project() {};
	
	public Project(int id, String name, String description, String date_start,String date_end, int id_user) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_start = date_start;
		this.date_end = date_end;
		this.id_user = id_user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return date_end;
	}

	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}

		



