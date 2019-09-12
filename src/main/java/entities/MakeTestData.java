/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hamad
 */
public class MakeTestData {
<<<<<<< Updated upstream
    
            public static void main(String[] args) {
=======

    public static void main(String[] args) {
>>>>>>> Stashed changes
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        GroupMember bc1 = new GroupMember("hamad", 1, "green");

        try {
<<<<<<< Updated upstream
            em.getTransaction().begin();
            em.persist(bc1);
            System.out.println("Member: " + bc1.toString());
            
            em.getTransaction().commit();
            System.out.println("Member: " + bc1.toString());
=======
            GroupMember m1 = new GroupMember("jabs", 1, "green");
            GroupMember m2 = new GroupMember("hamad", 2, "green");
            GroupMember m3 = new GroupMember("artin", 3, "red");
            GroupMember m4 = new GroupMember("chris", 4, "red");

            em.getTransaction().begin(); //begin transaction
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);
            em.persist(m4);
            em.getTransaction().commit(); //commit transactions
>>>>>>> Stashed changes
        } finally {

            em.close();
        }

    }

}
