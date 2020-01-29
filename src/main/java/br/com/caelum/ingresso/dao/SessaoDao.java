package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {

	    @PersistenceContext
	    private EntityManager manager;
	    
	    public void save(Sessao sessao) {
	    	manager.persist(sessao);
	    }
	    
	    public List<Sessao> buscaSesoesDaSala(Sala sala){
	    	return manager.createQuery("Select s from Sessao s where s.sala = :sala",Sessao.class)
	    			.setParameter("sala", sala)
	    			.getResultList();
	    }

}
