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
@NoArgsConstructor
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identifier;
    private LocalDateTime data;
    private Integer gols_mandante;
    private Integer gols_visitante;
    private Integer publico;
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "time_mandante_id")
    private Time mandante;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time visitante;
}
