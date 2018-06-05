package com.s63d.ervehicleservice.config

import com.s63d.ervehicleservice.security.JwtAuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class SecurityConfig(private val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.cors()
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs","/swagger-resources","/swagger-resources/**", "/swagger-ui.html", "/webjars/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(JwtAuthorizationFilter(authenticationManager(), userDetailsService), BasicAuthenticationFilter::class.java)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().headers().disable()
    }


    @Bean
    fun corsConfigurationSource() : CorsConfigurationSource {
        val cors = CorsConfiguration().apply {
            applyPermitDefaultValues()
            addExposedHeader(HttpHeaders.AUTHORIZATION)
        }
        return UrlBasedCorsConfigurationSource().apply { registerCorsConfiguration("/**", cors) }
    }
}