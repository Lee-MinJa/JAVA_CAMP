import React, {useState, useEffect} from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import BoardCommentList from '../../components/board/BoardCommentList'
import { memberGet, fviewCount, pjPort } from '../../components/board/MappingDB'
import {
  Box,
  Divider,
  Stack,
  Chip,
  Button,
  Container,
} from '@mui/material'
// import Setter from '../../components/board/boardComponent/Setter';
import axios from 'axios'

function BoardDetail() {
  const location = useLocation();
  const navigate = useNavigate();
  const [nickName, setNickName] = useState([{
    mem_nick : '',
  }])

  const {
    boardNumber,
    boardTitle,
    boradContent,
    boardDate,
    boardView,
    boardCategory,
    boardWriter
  } = location.state

  const [viewState, setViewState] = useState(Number(boardView + 1))

  const viewCount = () => {
    const url = "http://localhost:" + pjPort + "/api/" + fviewCount + "/" + boardNumber
    const data = {
      countViews : viewState,
      free_num : boardNumber
    }
    axios.put(url, data).then((res) => {
      console.log('view : ', viewState)
    })
  }

  useEffect(() => {
    axios.get(`http://localhost:${pjPort}/api/${memberGet}/${boardWriter}`).then((res) => {
      setNickName(res.data)
      console.log('nick : ',nickName)
    })
    viewCount()
  }, [])

  return (
      <Container sx={{width : '90vw'}} maxWidth="lg">
    <Box
      className='boardHeader'
      sx={{height: '7vh',}}>
    </Box>
    <h2>자유게시판</h2>
    <Divider variant="inset"
      sx={{
        marginLeft : '-0px',
        marginTop : '-8px',
        width : '70vw',
        borderColor : '#00B4D8'
      }}
      />
      <Box
      marginTop={'-6px'}
      >
      <Stack 
      alignItems={'center'}
      direction={'row'}>
      <Chip
      sx={{
        color : 'white',
      }}
      color='primary'
      label={boardCategory}/>
      <Box
      marginLeft={'5px'}
      >
      <h3>{boardTitle}</h3>
      </Box>
      </Stack>
      <Stack
      sx={{
        width : '68vw',
        marginTop : '-40px',
        padding : '10px'
      }}
      justifyContent={'space-between'}
      direction={'row'}>
        <Stack 
        divider={<Divider
          sx={{
          marginLeft : '15px',
          marginTop : '23px',
          height : '20px'
          }}
          orientation='vertical' 
          flexItem/>}
        direction={'row'}>

    {nickName.map((row, i) =>
    <Box key={i}>
    <h4>{row.mem_nick}</h4>
    </Box>
    )}
        <Box
        marginLeft={'15px'}
        >
      <h4>{boardDate}</h4>
      </Box>
      </Stack>
      <Stack direction={'row'}>
      <Box>
        <h5>조회수 { boardView + 1}</h5>
      </Box>
      <Box marginLeft={'10px'}>
        <h5>댓글 {2}</h5>
      </Box>
      </Stack>
      </Stack>
      <Divider variant="inset"
      sx={{
        marginLeft : '0px',
        marginTop : '-18px',
        width : '70vw',
        borderColor : '#00B4D8'
      }}
      />
      <Box
      padding={'10px'}
      width={'70vw'}
      minHeight={'200px'}
      display={'flex'}
      >
      <Box dangerouslySetInnerHTML={{__html:boradContent}}></Box>
      </Box>
      <Stack
      sx={{
        width : '70vw'
      }}
      justifyContent={'space-between'}
      direction={'row'}>
      <Box></Box>
      <Box 
      top={'50px'}
      position={'relative'}>
      <Button onClick={() => navigate(-1)}>목록으로</Button>
    </Box>
    </Stack>
    <BoardCommentList boardNum={boardNumber} />


    </Box>
    </Container>
  )
};

export default BoardDetail;
