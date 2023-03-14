package insper.times.Time;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer>{

    Time findByIdentifier(String identifier);
}
