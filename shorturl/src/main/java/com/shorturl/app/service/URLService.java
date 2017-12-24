package com.shorturl.app.service;

import com.shorturl.app.api.dto.URLShortenerDTO;

public interface URLService {

	URLShortenerDTO salvarUrl(String urlOriginal);
	URLShortenerDTO getURL(String shortenedURL);
}
