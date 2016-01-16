package hello.repository;

import hello.domain.Greeting;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import java.util.List;

@Repository
public class GreetingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Greeting> findAll() {
        return this.entityManager.createQuery("SELECT g FROM Greeting g", Greeting.class)
                .getResultList();
    }

    public Greeting find(Long id) {
        return entityManager.find(Greeting.class,id);
    }

    public Long save(String content){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Greeting g = new Greeting();
        g.setContent(content);
        entityManager.persist(g);
        tx.commit();
        
        return g.getId();
    }

}
