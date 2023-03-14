package insper.times.Partida;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {

    Partida findByIdentifier(String identifier);
    
}
