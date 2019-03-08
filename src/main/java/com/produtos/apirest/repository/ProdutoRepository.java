package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

//jpaRository ja contem metodos como salve,finbyId,etc
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
