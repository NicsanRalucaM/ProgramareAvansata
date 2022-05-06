/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.laborator9;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author raluc
 */
public class Laborator9 {

    public static void main(String[] args) {
       EntityManagerFactory emf =
 Persistence.createEntityManagerFactory("MapPU");
 EntityManager em = emf.createEntityManager();

 em.getTransaction().begin();
 Continent continent = new Continent("Europe");
 em.persist(continent);

 Continent c = (Continent)em.createQuery(
 "select e from Continent e where e.name='Europe'")
 .getSingleResult();
 c.setName("Africa");
 em.getTransaction().commit();
 em.close();
 emf.close();
    }
}
