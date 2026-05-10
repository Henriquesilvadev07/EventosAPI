package com.estudos.Eventos.Service;

import com.estudos.Eventos.Dto.EventoDto;
import com.estudos.Eventos.Model.EventoModel;
import com.estudos.Eventos.Repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosService {


    private final EventoRepository eventoRepository;

    public EventosService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public EventoModel salvar(EventoDto dto) {
        EventoModel evento = new EventoModel();

        evento.setNome(dto.nome());
        evento.setCapacidade(dto.capacidade());
        evento.setDescricao(dto.descricao());
        evento.setLocal(dto.local());
        evento.setStatus(dto.status());

        return eventoRepository.save(evento);
    }

    public EventoModel acharPorId(Long id) {
        return eventoRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Id nao existente"));
    }

    public List<EventoModel> listar() {
        return eventoRepository.findAll();
    }

    public EventoModel atualizarPorId(Long id, EventoDto dto){
        EventoModel evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id nao encontrado"));

        evento.setNome(dto.nome());
        evento.setCapacidade(dto.capacidade());
        evento.setDescricao(dto.descricao());
        evento.setLocal(dto.local());
        evento.setStatus(dto.status());

        return eventoRepository.saveAndFlush(evento);
    }

    public void deletarPorId(Long id){
        if (eventoRepository.existsById(id)){
            eventoRepository.deleteById(id);
        }
    }

}
