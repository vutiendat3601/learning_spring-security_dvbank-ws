package com.datvutech.dvbankws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.datvutech.dvbankws.data.entity.Notice;
import com.datvutech.dvbankws.data.repository.NoticeRepository;
import com.datvutech.dvbankws.mapper.NoticeMapper;
import com.datvutech.dvbankws.service.NoticeService;
import com.datvutech.dvbankws.shared.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepo;

    @Override
    public Page<NoticeDto> getNotices(int page, int size) {
        Pageable pageReq = PageRequest.of(page - 1, size);
        Page<Notice> notices = noticeRepo.findAll(pageReq);
        Page<NoticeDto> noticeDtos = notices.map(NoticeMapper.INSTANCE::noticeEntityToNoticeDto);
        return noticeDtos;
    }
}
