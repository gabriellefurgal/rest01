package bookmarks.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ReFormatAspect {

	
	 @AfterReturning(pointcut = "@annotation(bookmarks.aspects.ReFormat)", returning = "response")
	    public void formatter(JoinPoint joinPoint, Object response) {
	        System.out.println("[@AfterReturning] " + ((String) response).toUpperCase()+ "" + new Date());
	}

		
}  

