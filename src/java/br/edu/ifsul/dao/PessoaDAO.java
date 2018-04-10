package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateless
public class PessoaDAO implements Serializable {

    private List<Pessoa> lista;
    @PersistenceContext(unitName = "ServicoPessoaBDPU")
    private EntityManager em;

    public PessoaDAO() {

    }

    public Pessoa inserir(Pessoa obj) {
        obj.setId(null);
        em.persist(obj);
        return obj;
    }

    public Pessoa alterar(Pessoa obj) {
        em.merge(obj);
        return obj;
    }

    public boolean remover(Integer id) {
        try {
            Pessoa obj = em.find(Pessoa.class, id);
            em.remove(obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Pessoa> getLista() {
        return em.createQuery("from Pessoa order by id").getResultList();
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }
}
