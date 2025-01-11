package com.eazybytes.eazyschool.eazyschool.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="holidays")
public class Holiday {

    @Id
    public final String day;
    public final String reason;
    @Enumerated(EnumType.STRING)
    public final Type type;

    public  enum Type {
        FESTIVAL,FEDERAL
    }
}


