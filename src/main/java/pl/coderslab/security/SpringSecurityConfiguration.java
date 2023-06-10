package pl.coderslab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                //.csrf().disable()
                .authorizeHttpRequests(authorization ->
                        authorization
                                .shouldFilterAllDispatcherTypes(false)
                                //.requestMatchers(HttpMethod.GET, "/hello").permitAll()
                                //.requestMatchers(HttpMethod.POST, "/book/add").hasAuthority("ROLE_ADMIN")//hasRole("ADMIN")
                                //.requestMatchers(HttpMethod.GET, "/resources/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form.loginPage("/login")
                                .permitAll()
                );

        return httpSecurity.build();
    }
}
