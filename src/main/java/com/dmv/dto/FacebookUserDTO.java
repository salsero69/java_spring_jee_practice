package com.dmv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookUserDTO {
	String id = null;
	String first_name = null;
	String gender = null;
	String last_name = null;
	String link = null;
	String locale = null;
	String name = "2";
	String username = "1";

	public String getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getGender() {
		return gender;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getLink() {
		return link;
	}

	public String getLocale() {
		return locale;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
