package hello.repository;

import hello.domain.Greeting;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GreetingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Greeting> findAll() {
        return this.entityManager.createQuery("SELECT g FROM Greeting g", Greeting.class)
                .getResultList();
    }
}
