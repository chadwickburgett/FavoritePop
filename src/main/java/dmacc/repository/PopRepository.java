package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Pop;

@Repository
public interface PopRepository extends JpaRepository<Pop, Long> { }
