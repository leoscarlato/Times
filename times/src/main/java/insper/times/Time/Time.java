package insper.times.Time;

// import partidas.Partida;
import insper.times.Partida.Partida;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String identifier;
    private String estadio;

    @JsonIgnore
    @OneToMany(mappedBy = "mandante")
    private List<Partida> partidas_mandante;

    @JsonIgnore
    @OneToMany(mappedBy = "visitante")
    private List<Partida> partidas_visitante;

    public Time(String nome, String identifier, String estadio) {
        this.nome = nome;
        this.identifier = identifier;
        this.estadio = estadio;
    }
    
}
