package facades;

import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade()
    {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getFacadeExample(EntityManagerFactory _emf)
    {
        if (instance == null)
        {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    public List<Joke> getAllJokes()
    {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Joke.getAllJokes").getResultList();
    }

    public Joke getJokeById(long id)
    {

        return getEntityManager().find(Joke.class, id);

    }

    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public void populateJokes()
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(new Joke(1, "Hamad", "Green"));
            em.persist(new Joke(2, "Jabs", "green"));
            em.persist(new Joke(3, "Artin", "Yellow"));
            em.persist(new Joke(4, "Chris", "Yellow"));
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

    public Joke addJoke(Joke newJoke)
    {
        EntityManager em = getEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(newJoke);
            em.getTransaction().commit();
            return newJoke;
        } catch (IllegalArgumentException e)
        {
            em.getTransaction().rollback();
        } finally
        {
            em.close();
        }
        return null;
    }

}
