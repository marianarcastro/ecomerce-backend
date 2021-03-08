package br.com.ecommerce.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entity.Usuario;
import br.com.ecommerce.repository.UsuarioRepository;
import br.com.ecommerce.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario u = repo.findByEmail(email);
		
		if(u == null) {
			throw new UsernameNotFoundException(email);
		}
		
		Collection<? extends GrantedAuthority> lista = new ArrayList<>();
		return new UserSS(u.getId(), u.getEmail(), u.getSenha(), lista);
	}

}
