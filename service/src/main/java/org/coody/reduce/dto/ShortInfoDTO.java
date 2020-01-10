package org.coody.reduce.dto;

import org.coody.reduce.domain.ShortInfo;

@SuppressWarnings("serial")
public class ShortInfoDTO extends ShortInfo {

	private String appName;

	private String shortUrl;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
