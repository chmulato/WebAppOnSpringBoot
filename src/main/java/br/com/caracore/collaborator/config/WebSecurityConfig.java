package br.com.caracore.collaborator.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.caracore.collaborator.model.Login;
import br.com.caracore.collaborator.service.LoginService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginService loginService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/colaboradores").hasAnyRole("ADMINISTRADOR","OPERADOR","VISITANTE")
				.antMatchers("/colaboradores/**").hasAnyRole("ADMINISTRADOR","OPERADOR")
				.antMatchers("/contatos").hasAnyRole("ADMINISTRADOR","OPERADOR","VISITANTE")
				.antMatchers("/contatos/**").hasAnyRole("ADMINISTRADOR","OPERADOR")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		List<Login> listar = loginService.buscarTodos();
		
		if (listar != null && listar.size() > 0) {
			
			for (Login LOGIN : listar) {
				
				String usr = LOGIN.getUsername(); 
				String pwd = LOGIN.getPassword(); 
				String roles = LOGIN.getPerfil().toString(); 
				
				if (roles.equals("ADMINISTRADOR")) {
					auth.inMemoryAuthentication().withUser(usr).password(pwd).roles("ADMINISTRADOR","OPERADOR","VISITANTE");
				} else if (roles.equals("OPERADOR")) {
					auth.inMemoryAuthentication().withUser(usr).password(pwd).roles("OPERADOR", "VISITANTE");
				} else if (roles.equals("VISITANTE")) {
					auth.inMemoryAuthentication().withUser(usr).password(pwd).roles("VISITANTE");
				}
				
			}

		}
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.debug(true);
		web.ignoring().antMatchers("/**");
	}

}
