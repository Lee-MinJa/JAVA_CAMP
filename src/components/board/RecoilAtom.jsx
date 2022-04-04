import { atom, selector } from 'recoil';

export const btnState = atom({
  key : 'btnState',
  default : 'all'
})

export const fBoardState = atom({
  key : 'fBoardState',
  default : [{
    free_num : 0,
    free_subject : "",
    // free_content : "",
    free_regdate : "",
    free_title : "",
    free_views : 0,
    mem_nick : "",
  }]
})

export const fBoardInsertContent = atom({
  key : "fBoardInsertContent",
  default : {value : null}
})

export const fBoardDetailState = atom({
  key : 'fBoardDetailState',
  default : {
    boardNumber : 0,
    boardTitle : "",
    boardDate : "",
    boardView : 0,
    boardCategory : "",
    boardWriter : "",
  }
})

export const fBoardDetailContent = atom({
  key : "fBoardDetailContent",
  default : {value : null}
})

export const pageState = atom({
  key : 'pageState',
  default : 0,
})

export const searchPageState = atom({
  key : 'searchPageState',
  default : 0,
})

export const commentCount = atom({
  key : 'commentCount',
  default : 0
})

export const searchValue = atom({
  key : 'searchValue',
  default : ''
})

export const searchState = atom({
  key : 'searchState',
  default : [{
    free_num : 0,
    free_subject : "",
    free_content : "",
    free_regdate : "",
    free_title : "",
    free_views : 0,
    mem_nick : "",
  }]
})

export const userInfoState = atom({
  key : 'userInfoState',
  default : [{
    mem_num : 1,
    mem_code : 1,
    mem_nick : '걱정이많은자',
  }]
})

export const alertState = atom({
  key : 'alertState',
  default : false
})

export const alertMessegeState = atom({
  key : 'alertMessegeState',
  default : ""
})

export const conditionsAcceptState = atom({
  key : 'ConditionsAcceptState',
  default : false
})

export const emailInputState = atom({
  key : 'emailInputState',
  default : ''
})

export const domainSelectState = atom({
  key : 'domainSelectState',
  default : ''
})

export const domainDirectState = atom({
  key : 'domainDirectState',
  default : ''
})

export const emailState = atom({
  key : 'emailState',
  default : ''
})