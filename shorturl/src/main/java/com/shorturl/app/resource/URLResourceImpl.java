package com.shorturl.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.app.api.URLResource;
import com.shorturl.app.api.dto.URLShortenerDTO;
import com.shorturl.app.service.URLService;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/url")
public class URLResourceImpl implements URLResource{
	
	@Autowired
    private URLService urlService;
	
	@RequestMapping(value = "/shorten", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @Override
	public URLShortenerDTO salvarURL(@RequestParam(value = "urlOriginal") String urlOriginal) {
		return urlService.salvarUrl(urlOriginal);
	}

	@RequestMapping(value = "/reverse", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
	@Override
	public URLShortenerDTO getURL(@RequestParam(value = "shortenedURL") String shortenedURL) {
		return urlService.getURL(shortenedURL);
	}
}