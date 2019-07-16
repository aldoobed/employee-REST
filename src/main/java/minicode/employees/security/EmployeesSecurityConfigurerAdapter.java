package minicode.employees.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
@Configuration
public class EmployeesSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Autowired
  private EmployeesAuthenticationEntryPoint authenticationEntryPoint;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
        .and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint)
        .and().csrf().disable();
  }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
     
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      String encodedPassword = passwordEncoder().encode("admin");
      manager.createUser(User.withUsername("admin").password(encodedPassword).roles("ADMIN").build());
      return manager;
    }
}  