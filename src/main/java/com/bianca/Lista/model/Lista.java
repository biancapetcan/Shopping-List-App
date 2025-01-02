/**
 * Clasa entitate pentru reprezentarea unui produs în baza de date.
 * @author Petcan Bianca-Andreea
 * @version 1 Ianuarie 2025
 */

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

    // Noua coloană pentru starea cumpărat/necumpărat
    private boolean cumparat = false;

    // Getters și Setters
    public boolean isCumparat() {
        return cumparat;
    }

    public void setCumparat(boolean cumparat) {
        this.cumparat = cumparat;
    }
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
