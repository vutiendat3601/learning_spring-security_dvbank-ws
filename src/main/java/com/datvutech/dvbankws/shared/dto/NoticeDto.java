package com.datvutech.dvbankws.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeDto implements Serializable {
    private Long noticeId;

    private String noticeSummary;

    private String noticeDetails;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
