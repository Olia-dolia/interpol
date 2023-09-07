package com.example.interpol.repositories;

import com.example.interpol.entities.Criminal;
import com.example.interpol.entities.Language;
import com.example.interpol.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CriminalRepository extends JpaRepository<Criminal, Long> {
    @Query("select c from Criminal c where c.status.status not like ?1")
    List<Criminal> findCriminalByStatusIsNot(String status);

    List<Criminal> findCriminalsByStatusId(Long statusId);

    Set<Criminal> findCriminalByCriminalGroupId(Long id);

    @Query("select c from Criminal c where lower(c.firstName) like ?1 OR lower(c.lastName) like ?1 OR lower(c.alias) like ?1")
    List<Criminal> findAllByFirstNameOrLastNameOrAliasLike(String name);

    List<Criminal> findCriminalByProfessionId(Long id);

    List<Criminal> findCriminalByLastCaseId(Long id);
}