package main.java.com.fernando.apps.security.boundary;

/**
 * JWTFilter
 */
@Provider
@JWTRequired
@Priority(Properties.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter  {

    
}