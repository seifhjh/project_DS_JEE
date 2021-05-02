package net.seifhadjhassen.project.repositories;

import net.seifhadjhassen.project.models.MetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetRepository extends JpaRepository<MetEntity,String> {
}
