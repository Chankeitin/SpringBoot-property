package com.bnuz.config;



import com.bnuz.handler.auth.*;
import com.bnuz.util.AnonymousAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chanchitin
 * @date 2021/5/4
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailService;

    //登陆成功处理
    @Autowired
    private MyAuthenticationSuccessHandler SuccessHandler;
    //登录失败处理
    @Autowired
    private MyAuthenticationFailureHandler failureHandler;
    //未登录跳转处理
    @Autowired
    private MyAuthenticationEntryPoint entryPoint;
    //权限不足处理
    @Autowired
    private MyAccessDeniedHandler deniedHandler;
    //成功退出处理
    @Autowired
    private MyLogoutSuccessHandler logoutSuccessHandler;
    //注销处理 删除token
    @Autowired
    private MyLogoutHandler logoutHandler;
    //被挤下线处理
    @Autowired
    private MyExpiredSessionStrategy sessionStrategy;
    @Resource
    private ApplicationContext applicationContext;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录
        http.formLogin()

                //自定义登录逻辑    html中表单的action会找这个"/login"
                .loginProcessingUrl("/login").permitAll()
                //登录成功跳转页面 必须是post
                //自定义用户登录名参数 name=""
                .usernameParameter("username")//默认 username
                .passwordParameter("password")//默认 password
                .successHandler(SuccessHandler)//登陆成功处理
                .failureHandler(failureHandler)//登录失败处理
                .and()
                .exceptionHandling()
                .accessDeniedHandler(deniedHandler)//权限不足
                .authenticationEntryPoint(entryPoint)//未登录
                .and()
                .sessionManagement()
                .maximumSessions(1)//最大允许登录数量
                .maxSessionsPreventsLogin(false) //是否允许另一个账号登录
                .expiredSessionStrategy(sessionStrategy);//被挤下线的处理方式
                //.sessionRegistry(sessionRegistry());

        //第1步：解决跨域问题。cors 预检请求放行,让Spring security 放行所有preflight request（cors 预检请求）
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
        //放行掉这个iframe加载
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                //放行swagger
                .antMatchers("/swagger-ui.html",
                        "/swagger-ui/*",
                        "/swagger-resources/**",
                        "/v2/**",
                        "/v3/**",
                        "/img.icons/**",
                        "/webjars/**",
                        "/doc.html").permitAll()
                .antMatchers("/register").permitAll()
                //只有匿名用户才能访问，其他都要登录
                // 所有加 AnonymousAccess 注解的请求都允许匿名访问
                .antMatchers(getAnonymousUrls()).anonymous()
                //所有请求必须被认证（登录）
                .anyRequest().authenticated();


        //退出登录
        http.logout().permitAll()
                //退出登录url
                .logoutUrl("/logout")
                //退出处理 删除token
                //.addLogoutHandler(MyLogoutHandler)
                //退出成功处理
                .logoutSuccessHandler(logoutSuccessHandler)
                .deleteCookies("JSESSIONID");





        //关闭csrf防护(防火墙)
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder ps(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取标有注解 AnonymousAccess 的访问路径
     */
    private String[] getAnonymousUrls() {
        // 获取所有的 RequestMapping
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        Set<String> allAnonymousAccess = new HashSet<>();
        // 循环 RequestMapping
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethods.entrySet()) {
            HandlerMethod value = infoEntry.getValue();
            // 获取方法上 AnonymousAccess 类型的注解
            AnonymousAccess methodAnnotation = value.getMethodAnnotation(AnonymousAccess.class);
            // 如果方法上标注了 AnonymousAccess 注解，就获取该方法的访问全路径
            if (methodAnnotation != null) {
                allAnonymousAccess.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
            }
        }
        return allAnonymousAccess.toArray(new String[0]);
    }
}
