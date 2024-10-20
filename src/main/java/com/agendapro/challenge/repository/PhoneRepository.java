package com.agendapro.challenge.repository;

import com.agendapro.challenge.model.Phone;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
