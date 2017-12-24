package com.shorturl.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.app.api.URLResource;
import com.shorturl.app.api.dto.URLShortenerDTO;
import com.shorturl.app.service.URLService;

@RestController
@RequestMapping("/api/url")
public class URLResourceImpl implements URLResource{
	
	@Autowired
    private URLService urlService;

	@Override
	public URLShortenerDTO salvarURL(String urlOriginal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URLShortenerDTO getURL(String shortenedURL) {
		// TODO Auto-generated method stub
		return null;
	}

}
