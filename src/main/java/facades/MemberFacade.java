package facades;

import entities.GroupMember;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    public List<GroupMember> getAllMembers(){
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

}
