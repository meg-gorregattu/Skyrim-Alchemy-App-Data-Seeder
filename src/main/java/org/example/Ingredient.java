package org.example;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

    @Id
    @Column(name = "id")
    public int id;

    @Column
    public String name;

    Ingredient() {

    }


    // ---------------------------------


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
