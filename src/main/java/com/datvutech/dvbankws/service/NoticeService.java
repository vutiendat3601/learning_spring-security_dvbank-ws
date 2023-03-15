package com.datvutech.dvbankws.service;

import org.springframework.data.domain.Page;

import com.datvutech.dvbankws.shared.dto.NoticeDto;

public interface NoticeService {
    Page<NoticeDto> getNotices(int page, int size);
}
