package com.example.en62357788;

import java.util.Hashtable;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ExternalContext {

    private String emailUsername;
    private String emailPassword;

    private InitialContext initialContext;

    
    public String getEmailUsername() {
        return emailUsername;
    }


    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }


    public String getEmailPassword() {
        return emailPassword;
    }


    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }


    public void init() throws NamingException {
            Hashtable<String, String> props = new Hashtable<String, String>();

            if (!(emailUsername == null)) {
                props.put("SEC_PRINCIPAL", emailUsername);
            }
            if (emailPassword != null) {
                props.put("SEC_CREDENTIALS", emailPassword);
            }
            initialContext = new InitialContext(props);
    }
}
