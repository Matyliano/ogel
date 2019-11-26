package marviq.ogel.repository;

import marviq.ogel.entity.Runtime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface RuntimeRepository extends JpaRepository<Runtime, Long> {
    Optional<Runtime> findById(Long id);

    Page<Runtime> findByIsRunning(Integer isRunning, Pageable pageable);

    Page<Runtime> findByIsRunningAndAndMachineName(Integer isRunning, String machineName, Pageable pageable);

    Page<Runtime> findByDateTime(Date dateTime, Pageable pageable);
}
