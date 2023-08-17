package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Agency;


public interface AgencyRepository extends JpaRepository<Agency, Long> {
    
}
