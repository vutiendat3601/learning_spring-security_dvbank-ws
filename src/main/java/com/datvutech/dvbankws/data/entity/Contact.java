package com.datvutech.dvbankws.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "contacts")
@Entity
public class Contact implements Serializable {

    @Id
    private String contactId;

    private String contactName;

    private String contactEmail;

    private String subject;

    private String message;

}
