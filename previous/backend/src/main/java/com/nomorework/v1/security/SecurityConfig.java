//package com.nomorework.v1.security;
//
//import com.nimbusds.oauth2.sdk.AuthorizationRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
//import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
//import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity()
//public class SecurityConfig{
//
//
//    public SecurityFilterChain filterChain(
//        HttpSecurity httpSecurity,
//        AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository,
//        AuthenticationSuccessHandler authenticationSuccessHandler,
//        AuthenticationFailureHandler authenticationFailureHandler,
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService
//    ) throws Exception{
//        httpSecurity
//            .authorizeHttpRequests(
//                authorizeHttpRequests->
//                    authorizeHttpRequests
//                        .requestMatchers(
//                            new AntPathRequestMatcher("/oauth2/**"),
//                            new AntPathRequestMatcher("/login/oauth2/code/**")
//                        ).permitAll()
//                        .anyRequest().authenticated()
//            )
//            .httpBasic(AbstractHttpConfigurer::disable)
//            .csrf(CsrfConfigurer::disable)
//            .formLogin(AbstractHttpConfigurer::disable)
//            .sessionManagement(c->c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .oauth2Login(oAuth2LoginConfigurer ->
//                oAuth2LoginConfigurer
//                    .authorizationEndpoint(authorizationEndpointConfig ->
//                        authorizationEndpointConfig
//                            .baseUri("/oauth2/authorize")
//                            .authorizationRequestRepository(authorizationRequestRepository))
//                    .redirectionEndpoint(redirectionEndpointConfig ->
//                        redirectionEndpointConfig
//                            .baseUri("/login/oauth2/callback/**"))
//                    .userInfoEndpoint(userInfoEndpointConfig ->
//                        userInfoEndpointConfig
//                            .userService(oAuth2UserService))
//                    .successHandler(authenticationSuccessHandler)
//                    .failureHandler(authenticationFailureHandler)
//            )
//            .exceptionHandling(exceptionHandling ->
//                exceptionHandling
//                    .authenticationEntryPoint(
//                        (httpServletRequest, httpServletResponse, e)-> httpServletResponse.sendError(401)
//                    )
//                    .accessDeniedHandler(
//                        (httpServletRequest, httpServletResponse, e)-> httpServletResponse.sendError(403)
//                    ));
//
//    return httpSecurity.build();
//
//
//    }
//
//    @Bean
//    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> httpSessionOAuth2AuthorizationRequestRepository(){
//        return new HttpSessionOAuth2AuthorizationRequestRepository();
//    }
//
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler(){
//        return new SimpleUrlAuthenticationFailureHandler();
//    }
//
//    @Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService(){
//        return new DefaultOAuth2UserService();
//    }
//}
