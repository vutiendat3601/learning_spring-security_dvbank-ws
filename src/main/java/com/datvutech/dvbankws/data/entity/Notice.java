package com.datvutech.dvbankws.data.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "notices")
@Entity
public class Notice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    private String noticeSummary;

    private String noticeDetails;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
