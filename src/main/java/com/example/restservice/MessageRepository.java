package com.example.restservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Franck ANGBA
 */

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public Message findByLang(String language);
}
