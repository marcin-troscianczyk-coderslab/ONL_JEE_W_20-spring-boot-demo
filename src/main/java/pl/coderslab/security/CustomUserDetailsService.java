package pl.coderslab.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
class CustomUserDetailsService implements UserDetailsService {

    // private final UserRepository userRepository
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*
        final User user =
                userRepository.findByLogin(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

        // List<Role> -> List<SimpleGrantedAuthority>
        final Collection<? extends GrantedAuthority> authorities =
                user
                    .getRoles()
                    .stream()
                    .map(Role::getName)
                    .map("ROLE_"::concat)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

        final boolean accountNonExpired = true;
        final boolean accountNonLocked = true;
        final boolean credentialsNonExpired = true;
        final boolean enabled = true;
        final String firstName = user.getFirstName();
        final String lastName = user.getLastName();
        final String email = user.getEmail();

        return new CustomUserDetails(username, password, authorities, accountNonExpired,
                accountNonLocked, credentialsNonExpired, enabled, firstName, lastName, email);
    }
         */
        return new CustomUserDetails("admin23", "{noop}admin23", Collections.emptyList());
    }
}
