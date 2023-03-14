package insper.times.Partida;


import insper.times.Time.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identifier;
    private LocalDateTime data;
    private Integer gols_casa;
    private Integer gols_visitante;
    private Integer publico;

    @ManyToOne
    @JoinColumn(name = "time_casa_id")
    private Time casa;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time visitante;
}
