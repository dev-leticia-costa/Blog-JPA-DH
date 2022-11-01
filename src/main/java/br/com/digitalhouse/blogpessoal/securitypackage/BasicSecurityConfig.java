package br.com.digitalhouse.blogpessoal.securitypackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@Configuration
public class BasicSecurityConfig {
    @Bean //--> é um objeto que é instanciado e gerenciado pelo Spring.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();}



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable()
                .cors();

//        http.authorizeHttpRequests((auth) -> auth
//                .antMatchers("/usuarios/logar").permitAll()
//                .antMatchers("/usuarios/cadastrar").permitAll()
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .anyRequest().authenticated()).httpBasic();
      return http.build();}
    //se tudo deu certo, parte html retorna. Filtro das paginas
    }
//qualquer usuario que acessar o sistema vai chegar na oagina de login e cadastro;
//as outras paginas (tema, postagem) so poderao ser acessadas depois de passar por aqui
//statless recursos isolados dentro da app

    //cria a sessao de gerenciamento, politicas

    //filtro http
