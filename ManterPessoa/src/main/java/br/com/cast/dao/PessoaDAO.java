package br.com.cast.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.cast.models.Pessoa;

public class PessoaDAO {

	EntityManagerFactory emf;
	EntityManager em;

	public PessoaDAO() {
		this.emf = Persistence.createEntityManagerFactory("puManterPessoa");
		this.em = emf.createEntityManager();
	}

	public void inserirPessoa(Pessoa pessoa) {
		this.em.getTransaction().begin();
		try {
			this.em.persist(pessoa);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

	public List<Pessoa> buscaTodos() {
		Query query = this.em.createQuery("from Pessoa");
		return query.getResultList();
	}

	public void excluir(String cpf) {
		this.em.getTransaction().begin();
		try {
			this.em.remove(this.em.find(Pessoa.class, cpf));
			this.em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}
	}

}
