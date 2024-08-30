package com.example.backend.repo;

import com.example.backend.modal.Huser;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserRepo extends JpaRepository<Huser, Integer> {
    Huser findById(int id);

//    @Transactional
//    @Modifying
//    @Query("select count(*) from Huser where id=:id")
//    public int existById(int id);

        @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM Huser u WHERE u.id = :id")
        boolean existsById(@Param("id") int id);
}

