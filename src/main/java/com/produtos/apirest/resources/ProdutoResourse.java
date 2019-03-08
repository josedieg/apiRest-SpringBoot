package com.produtos.apirest.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
//anotação para deploy 
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")// libera para qualquer aplicação acessar a api
public class ProdutoResourse {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@ApiOperation(value="retorna uma lista de produtos")
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value="retorna um produto unico")
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@ApiOperation(value="salva um produto")
	@PostMapping("/produto")
	public Produto SalvaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	
	@ApiOperation(value="deleta produto")
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@ApiOperation(value="atualiza produto")
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
}
