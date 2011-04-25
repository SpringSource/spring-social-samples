package org.springframework.social.showcase.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.ServiceProviderConnection;
import org.springframework.social.connect.ServiceProviderConnectionRepository;
import org.springframework.social.facebook.api.FacebookApi;
import org.springframework.social.linkedin.api.LinkedInApi;
import org.springframework.social.tripit.api.TripItApi;
import org.springframework.social.twitter.api.TwitterApi;

@Configuration
public class ServiceApisConfig {
	
	@Inject
	private ServiceProviderConnectionRepository connectionRepository;
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public FacebookApi facebookApi() {
		ServiceProviderConnection<FacebookApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(FacebookApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public TripItApi tripitApi() {
		ServiceProviderConnection<TripItApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TripItApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public TwitterApi twitterApi() {
		ServiceProviderConnection<TwitterApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(TwitterApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public LinkedInApi linkedInApi() {
		ServiceProviderConnection<LinkedInApi> connection = connectionRepository.findPrimaryConnectionToServiceApi(LinkedInApi.class);
		return connection != null ? connection.getServiceApi() : null;
	}

}
