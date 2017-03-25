package app.web.mu.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.mu.api.business.model.Marker;

public interface MarkerRepository extends JpaRepository<Marker, Long> { }
