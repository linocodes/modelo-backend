package br.gov.mg.meioambiente.configuracao;

import java.util.Arrays;
import java.util.Collection;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.gov.mg.meioambiente.persistence.entity.model.Usuario;


public class CustomUserDetails extends Usuario implements UserDetails {

	private static final long serialVersionUID = 7714544738667392722L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_GERAL"));
	}

	
	//public CustomUserDetails(Usuario usuario) {
	//	super(usuario);
	//}

	@Override
	public String getPassword() {
		return super.getSenha();
	}

	@Override
	public String getUsername() {
		return super.getCpf();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

