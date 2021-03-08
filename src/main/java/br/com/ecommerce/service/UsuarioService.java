package br.com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.conciliator.services.exceptions.ObjectNotFoundException;

import br.com.ecommerce.entity.Usuario;
import br.com.ecommerce.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado usuário com esse id: " + id));
	}
	
	public void insert() {
		Usuario u = new Usuario(null, "admin", "admin@admin.com", pe.encode("123"));
		repository.save(u);
	}
	
}
