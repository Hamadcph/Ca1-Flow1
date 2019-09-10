package facades;

import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    List<Joke> getAllJokes() {

        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("SELECT r?? FROM Joke r")
            .getResultList();
        } finally {
            em.close();
        }
    }

    Joke getJokeById(int id) {
     
        return getEntityManager().find(Joke.class, id);

    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getRenameMeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM Joke r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

}
