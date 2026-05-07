package cadastroee.controller;

import cadastroee.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Guilherme Wille
 */
@Stateless
@LocalBean
public class ProdutoFacade {
    
    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;
    
    public void create(Produto produto){
       em.persist(produto);
    }
    public void edit(Produto produto) {
        em.merge(produto);
    }

    public void remove(Produto produto) {
        em.remove(em.merge(produto));
    }

    public Produto find(Object id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createNamedQuery("Produto.findAll", Produto.class).getResultList();
    }
}
