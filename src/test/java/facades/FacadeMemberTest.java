package facades;

import utils.EMF_Creator;
import entities.GroupMember;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeMemberTest {

    private static EntityManagerFactory emf;
    private static MemberFacade facade;
    private GroupMember member1 = new GroupMember("jabs", 1, "red");
    private GroupMember member2 = new GroupMember("hamad", 2, "red");

    public FacadeMemberTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/member_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = MemberFacade.getMemberFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = MemberFacade.getMemberFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("GroupMember.deleteAllRows").executeUpdate();
            em.persist(member1);
            em.persist(member2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getMemberCount(), "Expects two rows in the database");
    }
    
    @Test
    public void testGetMemberCount() {
        long result = facade.getMemberCount(); 
        long expected = 2; 
        assertEquals(2,result); 
    }
    
    @Test
    public void testGetAllMembers() {
        List<GroupMember> result = facade.getAllMembers(); 
        List<GroupMember> expected = new ArrayList<>(); 
        expected.add(member1); 
        expected.add(member2); 
        assertEquals(result.contains(member1), true); 
        assertEquals(result.contains(member2), true); 
    }
    
    @Test
    public void testGetMemberName() {
        try {
            GroupMember result = facade.getMemberName("jabs");
            GroupMember expected = member1; 
            assertEquals(expected, result);
        } catch (Exception ex) {
            Logger.getLogger(FacadeMemberTest.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    @Test 
    public void testAddMember() {
        GroupMember m1 = new GroupMember("Hazem", 10, "black");
        GroupMember m2 = new GroupMember("test", 12, "red");
         
        assertEquals(facade.addMember(m1), m1);
        assertEquals(facade.addMember(m2), m2); 
    }
    

}
