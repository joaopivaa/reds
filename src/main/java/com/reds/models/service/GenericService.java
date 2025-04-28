package com.reds.models.service;

import java.util.List;

public interface GenericService<T, R, ID> { // T = Classe, R = objeto de resposta para aplicação (objeto persistido [salvo, alterado, listado, deletado])
	
	public List<R> listar();
	
	public R save(T entity); // (salva) Assinatura do "contrato"
	
	public R update(ID id, T entity); // (atualiza)
	
	public void deleteById(ID id); // exclusão, passa o ID
	
	public R findById(ID id); // busca, passa o ID
}
