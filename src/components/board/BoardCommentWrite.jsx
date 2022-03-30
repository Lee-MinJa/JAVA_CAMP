import React, { useEffect, useState } from 'react'
import {
  Box,
  Button,
  Typography,
  Modal,
  TextField
} from '@mui/material'
import {pjPort, fBoardCm, fCmtWrite} from './MappingDB'
import axios from 'axios';
import { useRecoilValue } from 'recoil'
import { userInfoState } from './RecoilAtom'
import { useRecoilState } from 'recoil'
import { commentCount } from './RecoilAtom'

function BoardCommentWrite(props) {

    const [commentInput, setCommentInput] = useState('')
    const [dateValue, setDateValue] = useState('')
    const [commentCountValue, setCommentCountValue] = useRecoilState(commentCount)
    const userInfo = useRecoilValue(userInfoState)

  const boardNum = props.boardNum
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 600,
    height : 220,
    bgcolor: 'background.paper',
    border: '2px solid #0096C7',
    boxShadow: 24,
    p: 4,
  };

  const dateSet = () => {
    const today = new Date();
    const yyyy = today.getFullYear();
    const mm = ('0' + (today.getMonth() + 1)).slice(-2);
    const dd = ('0' + today.getDate()).slice(-2);
    const dateString = yyyy + '-' + mm + '-' + dd
    setDateValue(dateString)
    // console.log('date : ', dateString, 'free_num : ' ,boardNum)
  }

  useEffect(() => {
    dateSet()
  }, [])

    const [open, setOpen] = useState(false);

    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false); 
    
    const handleInputChange = (e) => {
      setCommentInput(e.target.value)
      // console.log(commentInput)
    }
    const handleSubmit = () => {
      if(commentInput === '') {
        alert('입력된 값이 없습니다.')
      }else {
        const url = 'http://localhost:'+ pjPort +'/' + fBoardCm + '/'+ fCmtWrite
        const data = {
          free_num : boardNum,
          commentValue : commentInput,
          dateValue : dateValue,
          writer : userInfo[0].mem_num,
        }
        // console.log("input : " + commentInput)
        handleClose()
        axios.post(url, data).then((res) => {
          // console.log(res)
          props.modalState('true')
        })
      }
    }
    return (
      <Box>
        <Button 
        variant='outlined'

        onClick={handleOpen}>댓글쓰기</Button>
        <Modal
          open={open}
          onClose={handleClose}
        >
          <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
              댓글 쓰기
            </Typography>
            <form onSubmit={handleSubmit}>
              <Box>
            <TextField
              sx={{
                marginTop : '20px',
                width : '600px'
              }}
              multiline
              rows={4}
              id="filled-search"
              name='commentInput'
              label="댓글내용"
              variant="outlined"
              onChange={handleInputChange}
            />
            </Box>
            <Box
            position={'absolute'}
            right={'20px'}
            bottom={'15px'}
            >
            <Button type='submit' onClick={handleSubmit}>확인</Button>
            <Button onClick={handleClose}>취소</Button>
            </Box>
            </form>
          </Box>
        </Modal>
      </Box>
    );
};

export default BoardCommentWrite;
