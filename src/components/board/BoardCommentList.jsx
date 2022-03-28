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
import { fCmtList, fBoardCm, pjPort } from '../board/MappingDB'
import axios from 'axios'

function BoardCommentList( props ) {

  const boardNum = props.boardNum
  const [valueEmpty, setValueEmpty] = useState('')
  const [boardComment, setBoardCommnet] = useState([{
    free_cmnt_num : 0,
    free_cmnt_content : '',
    free_cmnt_regdate : '',
    mem_num: 0,
    mem_nick : ''
  }])

  const modalState = (value) => {
    setValueEmpty(value)
    console.log(valueEmpty)
    fetchData()
  }

  const fetchData = () => {
    const url = 'http://localhost:' + pjPort + '/' + fBoardCm + '/' + fCmtList + '/' + boardNum
    const data = {
    free_num : boardNum
    }
    axios.get(url, data).then((res) => {
      setBoardCommnet(res.data)
      const str = res.data[0]
      if(str === [] || typeof str !== 'undefined'){
        setValueEmpty('true')
        console.log(str)
      }else{
        setValueEmpty('false')
      }
    })
  }

  useEffect(() => {
    fetchData()
  }, [valueEmpty])
  
    return (
      <Box
          sx={{
            width : '80vw',
            minHeight : '200px',
            paddingBottom : '50px'
          }}
          >
          <Stack
          alignItems={'center'}
          direction={'row'}>
          <h3>전체댓글</h3>
          <Box
          marginLeft={'10px'}
          >
          <BoardCommentWrite boardNum={boardNum} modalState={modalState}/>
          </Box>
          </Stack>
          <Box
          sx={{
            marginTop : '-6px',
            width : '70vw',
          }}
          >
            <Divider 
            sx={{       
            width : '80vw', 
            borderColor : '#00B4D8',
            color : 'black'}}
            />
        </Box>
  {boardComment.map(element => (
            <List key={element.free_cmnt_num} 
            sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
          <ListItem alignItems="flex-start">
            <ListItemText
            sx={{
              marginTop : '-6px'
              }}
              primary={`${element.mem_nick} / ${element.free_cmnt_regdate}`}
              secondary={
                <React.Fragment>
                  <Typography
                    sx={{ display: 'inline' }}
                    width={'80vw'}
                    component="span"
                    fontSize={'16px'}
                    variant="body2"
                    color="text.primary"
                  >
                    {element.free_cmnt_content} <br/>
                  </Typography>
                </React.Fragment>
              }
            />
          </ListItem>
          <Divider
          sx={{
            width : '78vw',
            marginLeft : '12px',
            borderColor : '#FF9E00'
          }}
          variant="inset" 
          component="li" />
          </List>
          ))}
      </Box>
    )
}

export default BoardCommentList;