package com.example.repository;

import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
    NewEntity findOneById(long id);
}
