package com.bianca.Lista.model;

import jakarta.validation.constraints.NotEmpty;

public class ListaDto {
    @NotEmpty(message = "Introduceti ID Produs")
    private static Long id;

    @NotEmpty(message = "Introduceti Numele Produsului")
    private static String NumeProdus;

    @NotEmpty(message = "Introduceti Pretul Produsului")
    private static float PretProdus;

    @NotEmpty(message = "Introduceti Cantitatea Produsului")
    private static int CantitateProdus;

    public Long getId() {
        return id;
    }

    public static void setId(Long ID) {
        ID = id;
    }

    public String getNumeProdus() {
        return NumeProdus;
    }

    public static void setNumeProdus(String numeProdus) {
        NumeProdus = numeProdus;
    }

    public float getPretProdus() {
        return PretProdus;
    }

    public static void setPretProdus(float pretProdus) {
        PretProdus = pretProdus;
    }

    public int getCantitateProdus() {
        return CantitateProdus;
    }

    public static void setCantitateProdus(int cantitateProdus) {
        CantitateProdus = cantitateProdus;
    }
}