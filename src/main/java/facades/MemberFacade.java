package facades;

import DTO.GroupMemberDTO;
import entities.GroupMember;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MemberFacade {

    private static MemberFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MemberFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MemberFacade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getMemberCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long memberCount = (long)em.createQuery("SELECT COUNT(m) FROM GroupMember m").getSingleResult();
            return memberCount;
        }finally{  
            em.close();
        }
    }
<<<<<<< Updated upstream
    
    public List<GroupMember> getAllMembers(){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("GroupMember.getAll").getResultList();
    }
=======

    public List<GroupMember> getAllMembers() {
            EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("GroupMember.getAll").getResultList();
    }
    

    public GroupMember getMemberName(String name) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT FROM GroupMember m WHERE m.name = :name", GroupMember.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Non found by that name");
        } finally {
            em.close();
        }

    }

    public GroupMember addMember(GroupMember gmember) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gmember);
            em.getTransaction().commit();
            return gmember;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return gmember;
    }

    public GroupMember getMemberId(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            GroupMember gmember = em.find(GroupMember.class, id);
            return gmember;
        } finally {
            em.close();
        }
    }

    public void populateMembers() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(new GroupMember("Hamad", 1, "Green"));
            em.persist(new GroupMember("Jabs", 2, "green"));
            em.persist(new GroupMember("Artin", 3, "Yellow"));
            em.persist(new GroupMember("Chris", 4, "Yellow"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

>>>>>>> Stashed changes
}
