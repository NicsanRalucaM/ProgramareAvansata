/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author raluc
 */
public class MyEntityManagerFactory {
    final private EntityManagerFactory managerFactory;
    public MyEntityManagerFactory() {
        managerFactory = Persistence.createEntityManagerFactory("MapPU");
    }
    public EntityManagerFactory getFactory() {
        return managerFactory;
    }

    public void closeFactory() {
        managerFactory.close();
    }
}
