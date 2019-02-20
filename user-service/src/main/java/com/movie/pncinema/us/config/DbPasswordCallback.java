package com.movie.pncinema.us.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

public class DbPasswordCallback extends DruidPasswordCallback {

	private static final Logger LOG = LoggerFactory.getLogger(DbPasswordCallback.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 7082759934307994470L;
	
	@Value(value = "${public-key}")
	private String publicKey;

	@Override
	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String password = properties.getProperty("spring.datasource.primary.password");
		String publicKey = properties.getProperty("spring.datasource.primary.public-key");
		try {
			String dbPassword = ConfigTools.decrypt(publicKey, password);
			setPassword(dbPassword.toCharArray());
		} catch (Exception e) {
			LOG.error("Druid ConfigTools.decrypt error!", e);
		}
	}
	

}
