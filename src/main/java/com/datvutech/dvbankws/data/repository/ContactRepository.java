package com.datvutech.dvbankws.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
