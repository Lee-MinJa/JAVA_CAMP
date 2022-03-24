import React, { useState, useEffect } from 'react'
import {
    Box,
    Divider,
    List,
    Stack,
    ListItem,
    ListItemText,
    Typography
} from '@mui/material'
import BoardCommentWrite from '../../components/board/BoardCommentWrite'
import BoardCommentSet from './boardComponent/BoardCommentSet'
import { fCmtList, fBoardCm, pjPort } from '../board/MappingDB'
import axios from 'axios'

function BoardCommentList( props ) {

  const boardNum = props.boardNum
  const [boardComment, setBoardCommnet] = useState([{
    free_cmnt_num : 0,
    free_cmnt_content : '',
    free_cmnt_regdate : '',
    mem_num: 0,
    mem_nick : ''
  }])
  
  useEffect(() => {
    const url = 'http://localhost:' + pjPort + '/' + fBoardCm + '/' + fCmtList + '/' + boardNum
    const data = {
      free_num : boardNum
    }
    axios.get(url, data).then((res) => {
      setBoardCommnet(res.data)
    })
  }, [])

  return (
    <>
      <Box
      sx={{
        width : '80vw'
      }}
      >
      <Stack
      alignItems={'center'}
      direction={'row'}>
      <h3>전체댓글</h3>
      <Box
      marginLeft={'10px'}
      >
      <BoardCommentWrite />
      </Box>
      </Stack>
      <Box
      sx={{
        marginTop : '-6px',
        width : '70vw',
        height : '300px',
      }}
      >
        <Divider 
        sx={{        
        borderColor : '#00B4D8',
        color : 'black'}}
        />
      <BoardCommentSet boardNum={boardNum}/>
      </Box>
      </Box>
      <>
      </>
      </>
  )
}

export default BoardCommentList;