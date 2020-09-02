package sbnz.security.annotations;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Secured({"	ROLE_ADMIN", "ROLE_CHEF", "ROLE_TRAINER", "ROLE_USER"})
public @interface LoggedUser {
}

