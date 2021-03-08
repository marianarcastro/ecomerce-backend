package br.com.ecommerce.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entity.Usuario;
import br.com.ecommerce.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioEndPoint {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> insert() {
		service.insert();
		return ResponseEntity.ok().body("");
	}
}
