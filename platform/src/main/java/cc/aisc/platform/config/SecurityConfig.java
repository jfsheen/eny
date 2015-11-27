package cc.aisc.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by sjf on 15-11-11.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/", "/resources/**", "/*/create/**").permitAll()
                .antMatchers("/users*").hasAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("remember-me")
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .rememberMe();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    /*@Bean(name = "requestCache")
    public RequestCache getRequestCache() {
        return new HttpSessionRequestCache();
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired private RequestCache requestCache;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .regexMatcher("/rest.*")
                    .authorizeRequests()
                    .antMatchers("/rest/calendar*//**")
     .hasAuthority("ROLE_USER")
     .antMatchers("/rest*//**")
     .permitAll()
     .and()
     .headers()
     .xssProtection()
     .and()
     .logout()
     .logoutUrl("/rest/security/logout-url")
     .and()
     .requestCache()
     .requestCache(requestCache)
     .and()
     .formLogin()
     .loginProcessingUrl("/rest/security/login-processing")
     .loginPage("/rest/security/login-page")
     .failureUrl("/rest/security/authentication-failure")
     .defaultSuccessUrl("/rest/security/default-target", false)
     .and()
     .httpBasic();
     }
     }

     @Configuration
     @Order(2)
     public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

     @Autowired private RequestCache requestCache;

     @Override
     protected void configure(HttpSecurity http) throws Exception {
     http
     .authorizeRequests()
     .regexMatchers("/calendar/.*")
     .hasAuthority("ROLE_USER")
     .regexMatchers("/.*")
     .permitAll()
     .and()
     .logout()
     .logoutUrl("/security/j_spring_security_logout")
     .and()
     .requestCache()
     .requestCache(requestCache)
     .and()
     .formLogin()
     .loginProcessingUrl("/security/j_spring_security_check")
     .loginPage("/login")
     .failureUrl("/login?login_error=t" )
     .and()
     .httpBasic();
     }
     }

     @Override
     public void configure(WebSecurity web) throws Exception {
     web
     .ignoring()
     .antMatchers("/resources*//**")
     .antMatchers("/sitemap.xml");
     }*/
}
