package com.fernando.apps.helpdeskng.users.boundary;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import com.fernando.apps.helpdeskng.users.entity.Credential;
import com.fernando.apps.helpdeskng.users.entity.User;

/**
 *
 * @author prashantp.org
 */
@Singleton
@Startup
public class SeedData {
    
    @Inject
    private UserService service;
    
    @PostConstruct
    public void init() {
        //Dummy accounts
        User adminUser = new User();
        adminUser.setCredential(new Credential("admin", "admin"));
        adminUser.setName("Admin");
        service.add(adminUser);
        
        User guestUser = new User();
        guestUser.setCredential(new Credential("guest", "guest"));
        guestUser.setName("Guest");
        
        service.add(guestUser);
    }
}