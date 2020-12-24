package com.example.jaso72859;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //  ハッシュアルゴリズム
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

//       http.httpBasic().disable();

        // 認可の設定
        http.authorizeRequests()
                .antMatchers("/loginForm").permitAll() // loginFormは全ユーザーからアクセス可能
                .antMatchers("/admin").hasAnyAuthority("ADMIN") //ADMINユーザーのみ
                .anyRequest().authenticated(); // 許可した項目以外は認証を求める

        //  ログイン処理
        http.formLogin()
                .loginProcessingUrl("/login") //ログイン処理のパス
                .loginPage("/loginForm") //ログインページの指定
                .usernameParameter("email") //ログインページのメールアドレス
                .passwordParameter("password") //ログインページのパスワード
                .defaultSuccessUrl("/home", true) //ログイン成功時のパス
                .failureUrl("/loginForm?error"); //ログイン失敗時のパス
    }
}
