//package facades;
//
//import utils.EMF_Creator;
//import entities.Member;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.Settings;
//import utils.EMF_Creator.DbSelector;
//import utils.EMF_Creator.Strategy;
//
////Uncomment the line below, to temporarily disable this test
////@Disabled
//public class FacadeMemberTest {
//
//    private static EntityManagerFactory emf;
//    private static MemberFacade facade;
//    private Member member1 = new Member("hans", 3, "red");
//    private Member member2 = new Member("hsa", 2, "red");
//
//    public FacadeMemberTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactory(
//                "pu",
//                "jdbc:mysql://localhost:3307/member_test",
//                "dev",
//                "ax2",
//                EMF_Creator.Strategy.CREATE);
//        facade = MemberFacade.getMemberFacade(emf);
//    }
//
//    /*   **** HINT **** 
//        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
//        ONE COMMON place accessible from anywhere.
//        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
//        See below for how to use these files. This is our RECOMENDED strategy
//     */
//    @BeforeAll
//    public static void setUpClassV2() {
//       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
//       facade = MemberFacade.getMemberFacade(emf);
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//
////     Setup the DataBase in a known state BEFORE EACH TEST
////    TODO -- Make sure to change the script below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            //em.createNamedQuery("Member.deleteAllRows").executeUpdate();
//            em.persist(member1);
//            em.persist(member2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
//        //Remove any data after each test was run
//    }
//
//     //TODO: Delete or change this method 
//    @Test
//    public void testAFacadeMethod() {
//        assertEquals(2, facade.getMemberCount(), "Expects two rows in the database");
//    }
//
//}
