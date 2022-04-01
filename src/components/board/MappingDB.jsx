//포트
export const pjPort = "9000" //포트번호

//게시판
export const fBoardMain = "freeboard" //free_board 테이블분류
export const fBoardGet = "jsonFreeBoarList" //free_board select *

export const memberGet = "memberGet" //회원정보(글상세-닉네임)

export const fSearchGet = "searchGet" //검색

export const freeImg = "freeImg" //이미지 업로드
export const fBoardInsert = "fBoardInsert" //insert
export const fviewCount = "fviewCount" //조회수 업데이트
export const fBoardEdit = "fBoardEdit" //게시글 수정
export const fBoardDelete = "fBoardDelete" //게시글 삭제

//댓글
export const fBoardCm = "freecmnt" //free_cmnt 테이블분류
export const fCmtList = "jsonFreeCmntList" //free_cmnt select *
export const fCmtWrite = "freeCmntWrite" //free_cmnt insert
export const fCmtDelete = "freeCmntDelete" //free_cmnt delete

//inSpring

const inSpring = ""

//paramiter
const free_num = inSpring+"free_num"
const free_cmnt_num = inSpring+"free_cmnt_num"


//request url =============================================================

//BoardList get
export const boardListUrl = 
`http://localhost:${pjPort}/${fBoardMain}/${fBoardGet}`


//BoardList Search
export const searchUrl =
`http://localhost:${pjPort}/${fBoardMain}/${fSearchGet}/`

//viewCount update
export const viewCountUrl = 
"http://localhost:" + pjPort + "/" + fBoardMain + "/" + fviewCount + "/" + free_num +"/"// + boardNum

//BoardInsert - Image upload
export const imgInsertUrl =
`http://localhost:${pjPort}/${fBoardMain}/${freeImg}`

//BoardInsert
export const boardInsertUrl =
'http://localhost:'+ pjPort +'/' + fBoardMain + '/'+ fBoardInsert


//BoardUpdate
export const boardUpdateUrl =
'http://localhost:'+ pjPort +'/' + fBoardMain + '/'+ fBoardEdit + '/' + free_num + '/' //+ boardNum


//BoardDelete
export const boardDeleteUrl =
'http://localhost:'+pjPort+'/'+fBoardMain+'/'+fBoardDelete+'/'+ free_num +'/'


//commentList get
export const commentGetUrl =
'http://localhost:' + pjPort + '/' + fBoardCm + '/' + fCmtList + '/' + free_num +'/'


//commentWrite
export const commentWriteUrl =
'http://localhost:'+ pjPort +'/' + fBoardCm + '/'+ fCmtWrite

//commentDelete
export const commentDeleteUrl =
'http://localhost:'+ pjPort +'/' + fBoardCm + '/'+ fCmtDelete + '/' + free_cmnt_num +'/'













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