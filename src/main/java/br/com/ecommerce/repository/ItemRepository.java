package br.com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
