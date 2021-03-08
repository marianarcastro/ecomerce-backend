package br.com.ecommerce.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entity.Item;
import br.com.ecommerce.service.ItemService;

@RestController
@RequestMapping(value="/itens")
@CrossOrigin(origins="http://localhost:4200")
public class ItemEndPoint {

	@Autowired
	private ItemService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Item> listaItens = service.buscarTodos();
		return ResponseEntity.ok(listaItens);
	}
}
