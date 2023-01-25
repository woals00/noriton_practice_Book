package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.Lend;
import com.example.demo.model.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
