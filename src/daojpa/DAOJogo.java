package daojpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.TypedQuery;
import modelo.Jogo;

public class DAOJogo extends DAO<Jogo> {
	public Jogo read (Object chave) {
		int id = (int) chave;
		try {
			TypedQuery<Jogo> q = manager.createQuery("select j from Jogo j where j.id=:x", Jogo.class);
			q.setParameter("x",id);
			return q.getSingleResult();

		}
		catch(Exception e) {
			return null;
		}
	}
	
	
	public List<Jogo> jogoPorData(String data) {
			TypedQuery<Jogo> q = manager.createQuery("select j from Jogo j where j.data=:x", Jogo.class);
			q.setParameter("x",data);
			return q.getResultList();
		
	}
	public List<Jogo> jogosPorTime(String time) {
					
			TypedQuery<Jogo> q = manager.createQuery("select j from Jogo j join j.times t where t.nome=:x", Jogo.class);
			q.setParameter("x", time);
			return q.getResultList();
		

    }
	
	@Override
	public List<Jogo> readAll() {
		TypedQuery<Jogo> q = manager.createQuery("select j from Jogo j", Jogo.class);	
		return q.getResultList();
	}
	
}
