import React, { useState, useEffect } from 'react'
import {
    Divider,
    List,
    ListItem,
    ListItemText,
    Typography
} from '@mui/material'
import { fCmtList, fBoardCm, pjPort } from '../MappingDB'
import axios from 'axios'

function BoardCommentSet(props) {

  const boardNum = props.boardNum
  const [valueEmpty, setValueEmpty] = useState('')
  const [boardComment, setBoardCommnet] = useState([{
    free_cmnt_num : 0,
    free_cmnt_content : '',
    free_cmnt_regdate : '',
    mem_num: 0,
    mem_nick : ''
  }])
  
  const fetchData = async () => {
    const url = 'http://localhost:' + pjPort + '/' + fBoardCm + '/' + fCmtList + '/' + boardNum
    const data = {
    free_num : boardNum
    }
    const dataAxios = await axios.get(url, data)
      setBoardCommnet(dataAxios.data)
      if(dataAxios.data[0].free_cmnt_content !== ''){
        setValueEmpty('true')
        setBoardCommnet(dataAxios.data)
      }
  }

  useEffect(() => {
    fetchData()
  }, [])

  if(valueEmpty !== 'true') {
    return(
      <>
        <h2>등록된 댓글이 없습니다.</h2>
      </>
    )
  } else {
    return (
      <div>
  {boardComment.map(element => (
            <List key={element.free_cmnt_num} sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
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
            width : '68vw',
            marginLeft : '12px',
            borderColor : '#FF9E00'
          }}
          variant="inset" 
          component="li" />
          </List>
          ))}
      </div>
    )
  }
  }

export default BoardCommentSet;
