package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	
	private Data replyDate;
	private Data updateDate;
}
