//package core.solution.deepleads.security;
//
//import core.solution.deepleads.service.crudService.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@SuppressWarnings("ALL")
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfig  {
//
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
//
//
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers("/api/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//    }
//
//
//
//    public SecurityConfig(UserDetailsService userDetailsService){
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults())
//                .httpBasic();
//
//        return http.build();
//    }
//
//
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeHttpRequests((authorize) ->
//
//                        {
//                            try {
//                                authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
//                                        .("/api/auth/**").permitAll()
//                                        .requestMatchers("/**").permitAll()
//                                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger.html").permitAll()
//                                        .anyRequest().authenticated()
//                                        .and().formLogin().and().httpBasic();
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//
//
//                );
//
//        return http.build();
//    }
//
//}