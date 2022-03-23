//포트
export const pjPort = "9000" //포트번호

//게시판
export const fBoardMain = "freeboard" //free_board 테이블분류
export const fBoardGet = "jsonFreeBoarList" //free_board select *

export const memberGet = "memberGet" //회원정보(글상세-닉네임)

export const freeImg = "freeImg" //이미지 업로드
export const fBoardInsert = "fBoardInsert" //insert
export const fviewCount = "fviewCount" //조회수 업데이트

//댓글
export const fBoardCm = "freecmnt" //free_cmnt 테이블분류
export const fCmtList = "jsonFreeCmntList" //free_cmnt select *

/* 사용된 컬럼(쿼리문에 select 되어야 하는 컬럼)
1. 자유게시판 리스트화면
  free_num : 0,
  free_subject : "",
  free_content : "",
  mem_num : 0,
  free_regdate : "",
  free_title : "",
  free_views : 0,
*/

/*
2. 회원정보
  mem_nick
*/