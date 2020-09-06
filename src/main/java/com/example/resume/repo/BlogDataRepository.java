package com.example.resume.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.resume.modal.BlogData;


@Repository
public interface BlogDataRepository extends JpaRepository<BlogData, Integer>{

	
}
