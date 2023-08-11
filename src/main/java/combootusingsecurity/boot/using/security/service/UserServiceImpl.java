package combootusingsecurity.boot.using.security.service;

import combootusingsecurity.boot.using.security.WebDto.UserRegistrationDto;
import combootusingsecurity.boot.using.security.entity.Role;
import combootusingsecurity.boot.using.security.entity.User;
import combootusingsecurity.boot.using.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {


        Role userRole = new Role("ROLE_USER");
        User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),userRole);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(mapRoleToAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), authorities
        );
    }

    private GrantedAuthority mapRoleToAuthority(Role role) {
        return new SimpleGrantedAuthority(role.getName());

    }


}

