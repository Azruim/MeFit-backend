package fi.experis.mefit.controllers.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.HashSet;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Enable CORS -- this is further configured on the controllers
                .cors().and()

                // Sessions will not be used
                .sessionManagement().disable()

                // Disable CSRF -- not necessary when there are sessions
                .csrf().disable()

                // Enable security for http requests
                .authorizeRequests(authorize -> authorize
                        // Specify paths where public access is allowed
                        .antMatchers("/api/docs", "/api/docs/*", "/api/docs/**").permitAll()
                        .antMatchers("/api/swagger-ui", "/api/swagger-ui/*", "/api/swagger-ui/**").permitAll()
                        .antMatchers("/register", "/register/*", "/register/**").permitAll()
                        // All remaining paths require authentication
                        .anyRequest().authenticated())

                // Configure OAuth2 Resource Server (JWT authentication)
                .oauth2ResourceServer(oauth2 -> {
                    // Convert Jwt to AbstractAuthenticationToken
                    JwtAuthenticationConverter authnConverter = new JwtAuthenticationConverter();

                    // Convert Jwt roles claim to GrantedAuthorities
                    JwtGrantedAuthoritiesConverter roleConverter = new JwtGrantedAuthoritiesConverter();
                    roleConverter.setAuthorityPrefix("ROLE_");
                    roleConverter.setAuthoritiesClaimName("roles");

                    // Jwt -> GrantedAuthorities -> AbstractAuthenticationToken
                    authnConverter.setJwtGrantedAuthoritiesConverter(jwt -> {

                        System.out.println(jwt.getClaims());
                        // This will read the 'roles' claim you configured above
                        // jwt["roles"] -> new GrantedAuthority("ROLE_roleName")
                        Collection<GrantedAuthority> roles = roleConverter.convert(jwt);

                        // Merge the above sets
                        HashSet<GrantedAuthority> union = new HashSet<>(roles);

                        for (var a : union) {
                            logger.warn("JWT Authority: {}", a.getAuthority());
                        }
                        return union;
                    });

                    // Enable JWT authentication and access control from JWT claims
                    oauth2.jwt().jwtAuthenticationConverter(authnConverter);
                });
    }
}
