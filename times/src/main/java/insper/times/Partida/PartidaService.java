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

        partida.setMandante(timeService.getTimeByIdentifier(partida.getMandante().getIdentifier()));
        partida.setVisitante(timeService.getTimeByIdentifier(partida.getVisitante().getIdentifier()));

        partida.setEstadio(partida.getMandante().getEstadio());

        partida.setData(LocalDateTime.now());
        String identifier = UUID.randomUUID().toString();
        partida.setIdentifier(identifier);

        partida.setGols_mandante(0);
        partida.setGols_visitante(0);

        partida.setPublico(0);
        
        partidaRepository.save(partida);
        return partida;
    }

    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    public Partida getPartidaByIdentifier(String identifier) {
        return partidaRepository.findByIdentifier(identifier);
    }

    public Partida atualizaPartida(Partida partida){
        Partida partidaAtualizada = partidaRepository.findByIdentifier(partida.getIdentifier());
        partidaAtualizada.setGols_mandante(partida.getGols_mandante());
        partidaAtualizada.setGols_visitante(partida.getGols_visitante());
        partidaAtualizada.setPublico(partida.getPublico());
        partidaRepository.save(partidaAtualizada);

        return partidaAtualizada;
    }
    
}
