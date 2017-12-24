package com.shorturl.app.api;

import com.shorturl.app.api.dto.URLShortenerDTO;

public interface URLResource {

	URLShortenerDTO salvarURL(String urlOriginal);
	URLShortenerDTO getURL(String shortenedURL);
}
