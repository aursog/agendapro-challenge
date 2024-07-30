package com.agendapro.challenge.repository;

import com.agendapro.challenge.model.Unidad;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, UUID> {

}
