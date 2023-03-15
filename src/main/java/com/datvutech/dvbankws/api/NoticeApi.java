package com.datvutech.dvbankws.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datvutech.dvbankws.api.model.response.NoticeResponse;
import com.datvutech.dvbankws.mapper.NoticeMapper;
import com.datvutech.dvbankws.service.NoticeService;
import com.datvutech.dvbankws.shared.dto.NoticeDto;

@RestController
public class NoticeApi {
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeResponse>> getNotices(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<NoticeDto> noticeDtos = noticeService.getNotices(page, size);
        List<NoticeResponse> noticeResps = NoticeMapper.INSTANCE
                .noticeDtoToNoticeResponse(noticeDtos);

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticeResps);
    }
}
