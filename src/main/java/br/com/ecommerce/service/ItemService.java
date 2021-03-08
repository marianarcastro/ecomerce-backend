package br.com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.ecommerce.entity.Item;
import br.com.ecommerce.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	public List<Item> buscarTodos() {
		List<Item> listaItens = repository.findAll();
		return listaItens;
	}
}
