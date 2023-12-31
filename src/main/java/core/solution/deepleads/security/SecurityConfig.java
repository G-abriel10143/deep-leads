package core.solution.deepleads.security;

import core.solution.deepleads.service.crudService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@SuppressWarnings("ALL")
@Configuration
@EnableMethodSecurity
public class SecurityConfig  {

    private UserDetailsService userDetailsService;

    @Autowired
    UsuarioService usuarioService;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());


    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public SecurityConfig(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }



    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

//    @Bean
//    SecurityFilterChain web(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(HttpMethod.GET,"/api/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/api/**").permitAll()
//                        .requestMatchers("/api/auth/**").permitAll()
//                        .anyRequest().authenticated()
//                );
//        // ...
//
//        return http.build();
//    }



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                                //authorize.anyRequest().authenticated()
                        {
                            try {
                                authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                                        .requestMatchers("/api/auth/**").permitAll()
                                        .requestMatchers("/**").permitAll()
                                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger.html").permitAll()
                                        .anyRequest().authenticated()
                                        .and().formLogin().and().httpBasic();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }


                );

        return http.build();
    }

}