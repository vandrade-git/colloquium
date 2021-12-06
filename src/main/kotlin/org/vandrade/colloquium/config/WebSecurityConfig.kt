package org.vandrade.colloquium.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.HttpStatusEntryPoint


/**
 * Author: Vitor Andrade
 * Date: 12/6/21
 * Time: 2:34 PM
 */

/**
 * To enable authentication uncomment it.anyRequest().authenticated() and comment it.anyRequest().permitAll()
 * and go to localhost:6080/oauth2/authorization/github to login
 */
@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests {
//                it.anyRequest().authenticated()
                it.anyRequest().permitAll()
            }.exceptionHandling { exceptionHandler ->
                exceptionHandler.authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            }.oauth2Login()
    }
}