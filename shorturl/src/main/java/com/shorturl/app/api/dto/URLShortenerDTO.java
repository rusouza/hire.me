package com.shorturl.app.api.dto;

public class URLShortenerDTO {

	private String id;
	
	private String urlOriginal;
	
	private String dataCriacao;
	
	private String shortenedURL;
	
	public URLShortenerDTO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getShortenedURL() {
		return shortenedURL;
	}

	public void setShortenedURL(String shortenedURL) {
		this.shortenedURL = shortenedURL;
	}
	
}