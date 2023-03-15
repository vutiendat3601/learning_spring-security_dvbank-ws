package com.datvutech.dvbankws.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datvutech.dvbankws.data.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, String> {
    @Query("FROM Notice n WHERE curdate() BETWEEN noticeBeginDate AND noticeEndDate")
    List<Notice> findAllActiveNotices();
}
