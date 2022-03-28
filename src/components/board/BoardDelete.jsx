import React from 'react'
import { 
        Button,
        Dialog,
        DialogActions,
        DialogContent,
        DialogContentText,
        DialogTitle
        } from '@mui/material'
import axios from 'axios';
import { useNavigate } from 'react-router-dom'
import {pjPort, fBoardMain, fBoardDelete} from './MappingDB'

function BoardDelete(props) {

  const boardNum = props.boardNum
  const navigate = useNavigate()
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleDelete = () => {
    const url = 'http://localhost:'+pjPort+'/'+fBoardMain+'/'+fBoardDelete+'/'+boardNum
    axios.delete(url).then(() => {
      setOpen(false)
      navigate('/BoardList')
    });
  }

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Button 
      sx={{
        backgroundColor : 'crimson',
        color : 'white',
        ":hover" : {
          backgroundColor : 'white',
          color : 'black',
          borderColor : 'crimson'
        }
      }}
      variant="contained"
      onClick={handleClickOpen}>
        삭제
      </Button>
      <Dialog
        fullWidth={true}
        maxWidth={'xs'}
        open={open}
        onClose={handleClose}
      >
        <DialogTitle color='crimson'>
          {"삭제하기"}
        </DialogTitle>
        <DialogContent>
          <DialogContentText>
            삭제하면 되돌릴 수 없어요.<br/>
            정말 삭제 하시겠어요?
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button
          sx={{
            borderColor : 'crimson',
            color : 'red',
            ":hover": {
              backgroundColor : 'red',
              color : 'white'
            }
          }}
          variant='outlined'
          onClick={handleDelete}>삭제</Button>
          <Button 
          sx={{
            borderColor : '#023E8A',
            color : 'Black',
            ":hover": {
              borderColor : '#023E8A',
              backgroundColor : '#023E8A',
              color : 'white'
            }
          }}
          variant='outlined'
          onClick={handleClose} autoFocus>
            취소
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  )
}

export default BoardDelete;
