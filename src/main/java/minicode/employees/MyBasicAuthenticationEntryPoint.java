package minicode.employees;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;

@Component
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
	private final Logger logger = LoggerFactory.getLogger(MyBasicAuthenticationEntryPoint.class);
	
    @Override
    public void commence
      (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
      throws IOException, ServletException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        EmployeeApiResponse error = new EmployeeApiResponse(authEx,HttpStatus.UNAUTHORIZED );

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