package ro.itschool.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ro.itschool.entity.MyUser;
import ro.itschool.entity.Role;

import ro.itschool.service.UserService;
import ro.itschool.util.Constants;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class RunAtStartUp {

    @Autowired
    private UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    private void saveAdminUser() {

        MyUser myUser = new MyUser();
        myUser.setUsername("admin");
        myUser.setPassword("admin");
        myUser.setRandomToken("randomToken");
        final Set<Role> roles = new HashSet<>();
        roles.add(new Role(Constants.ROLE_USER));
        roles.add(new Role(Constants.ROLE_ADMIN));
        myUser.setRoles(roles);
        myUser.setEnabled(true);
        myUser.setAccountNonExpired(true);
        myUser.setAccountNonLocked(true);
        myUser.setCredentialsNonExpired(true);
        myUser.setEmail("user2@gmail.com");
        myUser.setFullName("Userescu2 Userila2");
        myUser.setPasswordConfirm("admin");
        myUser.setRandomTokenEmail("randomToken");

        userService.saveUser(myUser);
    }
}