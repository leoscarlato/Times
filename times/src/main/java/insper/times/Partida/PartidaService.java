package insper.times.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
import insper.times.Time.*;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeService timeService;

    public Partida postPartida(Partida partida) {

        partida.setCasa(timeService.getTimeByIdentifier(partida.getCasa().getIdentifier()));
        partida.setVisitante(timeService.getTimeByIdentifier(partida.getVisitante().getIdentifier()));

        partida.setData(LocalDateTime.now());
        String identifier = UUID.randomUUID().toString();
        partida.setIdentifier(identifier);

        partida.setGols_casa(0);
        partida.setGols_visitante(0);
        
        partidaRepository.save(partida);
        return partida;
    }

    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    public Partida getPartidaByIdentifier(String identifier) {
        return partidaRepository.findByIdentifier(identifier);
    }
    
}
