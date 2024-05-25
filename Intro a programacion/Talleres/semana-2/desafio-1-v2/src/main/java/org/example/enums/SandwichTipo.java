package org.example.enums;

import org.example.enums.comportamientos.IDescribir;

public enum SandwichTipo implements IDescribir {
    DELICIOSO,
    EXQUISITO,
    SABROSO;


    @Override
    public String tomarDescripcion() {
        return switch (this) {
            case DELICIOSO -> "Delicioso";
            case EXQUISITO -> "Exquisito";
            case SABROSO -> "Sabroso";
        };
    }

    }
