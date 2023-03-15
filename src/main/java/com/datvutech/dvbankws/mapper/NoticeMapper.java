package com.datvutech.dvbankws.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.datvutech.dvbankws.api.model.response.NoticeResponse;
import com.datvutech.dvbankws.data.entity.Notice;
import com.datvutech.dvbankws.shared.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
    NoticeMapper INSTANCE = Mappers.getMapper(NoticeMapper.class);

    NoticeResponse noticeDtoToNoticeResponse(NoticeDto noticeDto);

    NoticeDto noticeEntityToNoticeDto(Notice notice);

    List<NoticeDto> noticeEntityToNoticeDto(Iterable<Notice> notices);

    List<NoticeResponse> noticeDtoToNoticeResponse(Iterable<NoticeDto> noticeDtos);
}
