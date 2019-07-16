package minicode.employees.model;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import lombok.Data;

@Data
public class BadCredentialsResponse {
	
	private String timestamp;
	private int status;
	private String error;
	private String message;

	public BadCredentialsResponse (AuthenticationException ex){
		this.status=HttpStatus.UNAUTHORIZED.value();
		this.timestamp= Instant.now().toString(); //Java 8: java.time package, in this case the Instant object is use for getting the current instant timestamp from system clock 
		this.error=HttpStatus.UNAUTHORIZED.getReasonPhrase();
		this.message=ex.getMessage();
	}
}