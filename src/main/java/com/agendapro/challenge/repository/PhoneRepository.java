package com.agendapro.challenge.repository;

import com.agendapro.challenge.model.Phone;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
