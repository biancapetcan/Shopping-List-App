/**
 * Clasa DTO pentru transferul datelor unui produs.
 * @author Petcan Bianca-Andreea
 * @version 1 Ianuarie 2025
 */

package com.bianca.Lista.model;
import jakarta.validation.constraints.*;

public class ListaDto {

    @NotNull(message = "Introduceti ID Produs")
    private Long id;

    @NotNull(message = "Introduceti Numele Produsului")
    private String numeProdus;

    @NotNull(message = "Introduceti Pretul Produsului")
    private float pretProdus;

    @NotNull(message = "Introduceti Cantitatea Produsului")
    private int cantitateProdus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public float getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(float pretProdus) {
        this.pretProdus = pretProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }
}
