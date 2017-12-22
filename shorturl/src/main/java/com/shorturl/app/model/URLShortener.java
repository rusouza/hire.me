package com.shorturl.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.shorturl.app.util.DomainConstants;

@Entity
@Table(name="url")
public class URLShortener implements DomainConstants {
	
	@Id
    @Column(name = "id")
    private Long id;
	     
    @Column(name = "created_on", updatable = false)
    //@Type(type = COMMON_DATE_TYPE)
    private DateTime createdOn = new DateTime();
	     
    @Column(name = "url_original")
    private String urlOriginal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}
    
}