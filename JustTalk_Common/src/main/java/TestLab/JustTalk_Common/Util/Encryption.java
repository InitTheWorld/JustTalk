package TestLab.JustTalk_Common.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encryption {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    StatusCode statusCode;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String encode( String password )
    {
        if(password == null)
        {
            logger.info("[Encryption_encode][({})]", "password can not be null");
            return statusCode.failed();
        }

        return passwordEncoder.encode(password);
    }

    public boolean decode(String encodePassword,String password)
    {
        if (password == null) {
            logger.info("[Encryption_decode][({})]", "password can not be null");
            return false;
        }

        if (encodePassword == null || encodePassword.length() == 0) {
            logger.info("[Encryption_decode][({})]", "encodePassword can not be null");
            return false;
        }
        return passwordEncoder.matches(password,encodePassword);
    }
}
