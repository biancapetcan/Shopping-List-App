package com.bianca.Lista.model;

import jakarta.persistence.*;

@Entity
@Table
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String NumeProdus;
    private float PretProdus;
    private int CantitateProdus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeProdus() {
        return NumeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        NumeProdus = numeProdus;
    }

    public float getPretProdus() {
        return PretProdus;
    }

    public void setPretProdus(float pretProdus) {
        PretProdus = pretProdus;
    }

    public int getCantitateProdus() {
        return CantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        CantitateProdus = cantitateProdus;
    }
}
