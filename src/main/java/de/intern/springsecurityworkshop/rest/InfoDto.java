package de.intern.springsecurityworkshop.rest;

public class InfoDto {
	private String text;
	private String nextUrl;

	InfoDto(String text, String nextUrl) {
		this.nextUrl = nextUrl;
		this.text = text;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
