package minicode.employees;

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
		this.timestamp= Instant.now().toString();
		this.error=HttpStatus.UNAUTHORIZED.getReasonPhrase();
		this.message=ex.getMessage();
	}
}