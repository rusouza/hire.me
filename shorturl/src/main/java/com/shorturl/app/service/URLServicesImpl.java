package com.shorturl.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.shorturl.app.api.dto.URLShortenerDTO;
import com.shorturl.app.model.URLShortener;
import com.shorturl.app.repository.URLRepository;
import com.shorturl.app.util.Base62;

public class URLServicesImpl implements URLService{
	
	@Autowired
	private URLRepository urlRepository;
	
	private final String dominio;
	
	@Autowired
	public URLServicesImpl(@Value("${dominio.pequeno}") String dominio) {
		this.dominio = dominio;
	}

	@Override
	public URLShortenerDTO salvarUrl(String urlOriginal) {
		URLShortener url = new URLShortener();
		urlOriginal = sanitizeURL(urlOriginal);
		Optional<URLShortener> exitURL = urlRepository.findByOriginalURL(urlOriginal);
	
		if(exitURL.isPresent()) {
			url = exitURL.get();
		} else {
			url.setId(urlRepository.getIdWithNextUniqueId());
			url.setUrlOriginal(urlOriginal);
			url = urlRepository.save(url);
		}
		return gerarShortenUrl(url);
	}
	
	private String sanitizeURL(String url) {
		if (url.substring(0, 7).equals("http://"))
			url = url.substring(7);

		if (url.substring(0, 8).equals("https://"))
			url = url.substring(8);

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}
	
	private URLShortenerDTO gerarShortenUrl(URLShortener url) {
		URLShortenerDTO dto = new URLShortenerDTO();
		dto.setId(url.getId().toString());
		dto.setUrlOriginal(url.getUrlOriginal());
		dto.setDataCriacao(url.getDataCriacao().toString());
		
		String shortenedURL = this.dominio +"/" + Base62.paraBase62(url.getId().intValue());
		dto.setShortenedURL(shortenedURL);
		return dto;
	}

	@Override
	public URLShortenerDTO getURL(String shortenURL) {
		URLShortenerDTO dto = new URLShortenerDTO();
		String str = shortenURL.replace(this.dominio +"/", "");
		
		long id = Base62.paraBase10(str);
		Optional<URLShortener> urlShortener = urlRepository.findById(id);
		
		if(urlShortener.isPresent()) {
			URLShortener url = urlShortener.get();
			dto.setId(url.getId().toString());
			dto.setShortenedURL(shortenURL);
			dto.setUrlOriginal(url.getUrlOriginal());
			dto.setDataCriacao(url.getDataCriacao().toString());
		} 
		return dto;
	}
	

}
