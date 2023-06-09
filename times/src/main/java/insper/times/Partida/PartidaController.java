package insper.times.Partida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public List<Partida> getAllPartidas() {
        return partidaService.getAllPartidas();
    }

    @PostMapping
    public Partida postPartida(@RequestBody Partida partida) {
        return partidaService.postPartida(partida);
    }

    @PostMapping("/{identifier}")
    public Partida atualizaPartida(@PathVariable String identifier, @RequestBody Partida partida) {
        return partidaService.atualizaPartida(partida);
    }
    
}
