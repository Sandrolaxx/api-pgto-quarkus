package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKT_TOKEN")
public class Token extends PanacheEntityBase {
    
    @Id
    @SequenceGenerator(name = "ID_TOKEN", sequenceName = "GEN_ID_TOKEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_TOKEN")
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "TOKEN", length = 700)
    private String token;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
