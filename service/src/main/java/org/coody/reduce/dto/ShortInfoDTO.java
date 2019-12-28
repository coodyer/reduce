package org.coody.reduce.dto;

import org.coody.reduce.domain.ShortInfo;

@SuppressWarnings("serial")
public class ShortInfoDTO extends ShortInfo{

	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	
}
