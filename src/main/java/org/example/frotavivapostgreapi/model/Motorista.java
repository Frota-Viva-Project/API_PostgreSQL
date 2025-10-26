package org.example.frotavivapostgreapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "motorista")
public class Motorista {

    @Id
    private Long id;

}
