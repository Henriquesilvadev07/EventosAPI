package com.estudos.Eventos.Repository;

import com.estudos.Eventos.Model.EventoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<EventoModel, Long> {
}
