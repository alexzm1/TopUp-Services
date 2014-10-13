package com.topup.services.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilderSpec;

/**
 * <b>CacheConfig</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

	private final GuavaCacheManager cacheManager;

	/**
	 * <b>Constructor</b>
	 *
	 */
	public CacheConfig() {
		cacheManager = new GuavaCacheManager();
		// TODO: Read these cache names from a configuration properties
		cacheManager.setCacheNames(Arrays.asList("tokens"));
		cacheManager.setCacheBuilderSpec(CacheBuilderSpec
				.parse("expireAfterWrite=60m,expireAfterAccess=10m"));
	}

	/** {@inheritDoc} **/
	@Bean
	@Override
	public CacheManager cacheManager() {
		return cacheManager;
	}

	/** {@inheritDoc} **/
	@Bean
	@Override
	public CacheResolver cacheResolver() {
		return new SimpleCacheResolver(cacheManager);
	}

	/** {@inheritDoc} **/
	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	/** {@inheritDoc} **/
	@Bean
	@Override
	public CacheErrorHandler errorHandler() {
		return new SimpleCacheErrorHandler();
	}

}
