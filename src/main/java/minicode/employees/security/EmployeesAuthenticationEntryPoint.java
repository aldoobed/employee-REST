package minicode.employees.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import minicode.employees.model.BadCredentialsResponse;

@Component
public class EmployeesAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
	private final Logger logger = LoggerFactory.getLogger(EmployeesAuthenticationEntryPoint.class);
	
    @Override
    public void commence
      (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
      throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        BadCredentialsResponse error = new BadCredentialsResponse(authEx);

        String jsonObject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error);
        writer.append(jsonObject);
        writer.close();

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("minicode.employees");
        super.afterPropertiesSet();
    }


}