package com.ss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.model.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {

}
