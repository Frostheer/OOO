package org.example.enums;

import org.example.enums.comportamientos.IDescribir;

public enum SandwichTamano implements IDescribir {
    PARA_NINO,
    NORMAL,
    XL;


    @Override
    public String tomarDescripcion() {
        return switch (this) {
            case PARA_NINO -> "Para niño";
            case NORMAL -> "Normal";
            case XL -> "XL";
        };
    }
}
