package com.schoolintegrated.system.repositories;

import java.util.List;

import com.schoolintegrated.system.models.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer>{

    List<JournalEntry> findByCategory(String category);
    List<JournalEntry> findByIdGreaterThan(int id);

    @Query("from JournalEntry where category=?1 order by title")
    List<JournalEntry> findByCategorySorted(String category);

}