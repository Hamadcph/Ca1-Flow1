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
    
            public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        GroupMember bc1 = new GroupMember("hamad", 1, "green");

        try {
            em.getTransaction().begin();
            em.persist(bc1);
            System.out.println("Member: " + bc1.toString());
            
            em.getTransaction().commit();
            System.out.println("Member: " + bc1.toString());
        } finally {

            em.close();
        }

    }
    
}
