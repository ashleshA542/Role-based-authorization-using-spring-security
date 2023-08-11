package combootusingsecurity.boot.using.security.service;

import combootusingsecurity.boot.using.security.WebDto.UserRegistrationDto;
import combootusingsecurity.boot.using.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
