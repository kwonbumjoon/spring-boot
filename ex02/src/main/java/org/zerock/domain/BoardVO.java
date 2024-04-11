package org.zerock.domain;

import java.util.Date;

import lombok.Data;

//create table tbl_board(
//	    bno number(10,0),
//	    title varchar2(200) not null,
//	    content varchar2(2000) not null,
//	    writer varchar2(50) not null,
//	    regdate date default sysdate,   -- 작성일
//	    updatedate date default sysdate -- 수정일
//	);

@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	
	private Date regdate;
	private Date updateDate;
}
