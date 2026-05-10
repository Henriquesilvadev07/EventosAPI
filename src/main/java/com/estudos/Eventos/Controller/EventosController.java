package com.estudos.Eventos.Controller;


import com.estudos.Eventos.Dto.EventoDto;
import com.estudos.Eventos.Model.EventoModel;
import com.estudos.Eventos.Service.EventosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    private final EventosService eventosService;

    public EventosController(EventosService eventosService){
        this.eventosService = eventosService;
    }

    @PostMapping
    public ResponseEntity<EventoModel> salvar(@RequestBody EventoDto dto) {
        return ResponseEntity.ok(eventosService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> acharPorId(@PathVariable Long id){
        return ResponseEntity.ok(eventosService.acharPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EventoModel>> listar(){
        return ResponseEntity.ok(eventosService.listar());
    }

    @PostMapping("/{id}")
    public ResponseEntity<EventoModel> atualizarPorId(@PathVariable Long id, @RequestBody EventoDto dto){
        return ResponseEntity.ok(eventosService.atualizarPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
