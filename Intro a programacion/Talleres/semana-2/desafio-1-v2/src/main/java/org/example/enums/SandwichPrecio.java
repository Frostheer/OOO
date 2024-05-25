package org.example.enums;

import org.example.enums.comportamientos.IValorar;

public enum SandwichPrecio implements IValorar {
    PRECIO_NINO,
    PRECIO_NORMAL,
    PRECIO_XL;


    @Override
    public float tomarValor() {
        return switch (this) {
            case PRECIO_NINO -> 2000;
            case PRECIO_NORMAL -> 4000;
            case PRECIO_XL -> 8000;
        };
    }
}
