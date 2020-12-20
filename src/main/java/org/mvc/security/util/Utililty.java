package org.mvc.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Utililty {
	
	public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
