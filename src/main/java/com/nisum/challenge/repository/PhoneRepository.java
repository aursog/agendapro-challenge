package com.nisum.challenge.repository;

import com.nisum.challenge.model.Phone;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
