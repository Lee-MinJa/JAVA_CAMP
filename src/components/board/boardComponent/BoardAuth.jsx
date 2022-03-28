import axios from 'axios'
import React, { useEffect } from 'react'
import {
      Box,
      Button
        } from '@mui/material'
import BoardDelete from '../BoardDelete'
import BoardUpdate from '../../../pages/board/BoardUpdate'
import { useNavigate } from 'react-router-dom'

function BoardAuth(props) {

  const writerAuth = props.auth
  const boardNum = props.boardNum
  useEffect(() => {
    
  })
  const navigate = useNavigate()
  if(writerAuth === 1){
  return (
    <div>
      <Box display={'flex'}>
    <Button
      sx={{
      marginRight : '6px',
      backgroundColor : '#023E8A',
      color : 'white',
      ":hover" : {
        backgroundColor : 'white',
        color : 'black',
        borderColor : 'crimson'
      }
        }}
        onClick={()=> navigate('/BoardDetail/'+row.FREE_NUM ,{state:{
          boardNumber : row.FREE_NUM,
          boardTitle : row.FREE_TITLE,
          boradContent : row.FREE_CONTENT,
          boardDate : row.FREE_REGDATE,
          boardView : row.FREE_VIEWS,
          boardCategory : row.FREE_SUBJECT,
          boardWriter : row.MEM_NUM
        }})}
    variant="contained"
    >수정</Button>
      <BoardDelete boardNum={boardNum} />
      </Box>
    </div>
  )
} else {
  return(
    <>
    </>
  )
}
}

export default BoardAuth;
