package org.example;


import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileReader;

public class DataSeeder {

    private static EntityManagerFactory factory;

    public static void seedData() throws Exception {
        factory = Persistence.createEntityManagerFactory("Ingredients-persistenceUnit");
        seedIngredients();
    }

    private static void seedIngredients() throws Exception {
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        try (BufferedReader br = new BufferedReader(new FileReader("seed_data/Ingredients.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columnValues = line.split("\\|");
                int id = Integer.parseInt(columnValues[0]);
                String name = columnValues[1];

                try {
                    Ingredient ingredient = new Ingredient();
                    ingredient.id = id;
                    ingredient.name = name;

                    entityManager.persist(ingredient);
                } catch (HibernateException e) {
                    e.printStackTrace();
                }
            }
        }
        entityManager.getTransaction().commit();
    }

}