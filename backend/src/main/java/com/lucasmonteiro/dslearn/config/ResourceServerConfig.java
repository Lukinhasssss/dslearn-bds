package com.lucasmonteiro.dslearn.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore); // Com isso o Resource server vai ser capaz de decodificar o token e analizar se este token está batendo com o secret e se está expirado ou não...
	}

	@Override
	public void configure(HttpSecurity http) throws Exception { // Neste método será configurado quem pode acessar o que
		
		// Configuração para liberar o H2
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) { // Se nos profiles ativos contém o profile test...
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.anyRequest().authenticated(); // Qualquer outra rota que não tenha sido especificada pode ser acessada por quem estiver logado (não importando o usuário)
		
		http.cors().configurationSource(corsConfigurationSource());
		
	}
	
	// Métodos para liberar CORS
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOriginPatterns(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean 
			= new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
