package com.datvutech.dvbankws.api.model.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoticeResponse implements Serializable {
    private String noticeSummary;

    private String noticeDetails;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;
    
    private LocalDateTime updatedDate;
}
