import React, { useState } from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { useRecoilState } from 'recoil'
import { emailState } from '../board/RecoilAtom'

function CertificationConfirm() {

  const [state, setState] = useRecoilState(emailState)
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  

  return (
    <div>
      <Button variant="outlined" onClick={handleClickOpen}>
        이메일 인증하기
      </Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>이메일 인증</DialogTitle>
        <DialogContent>
          <DialogContentText>
          {state} 주소로 메일이 발송되었습니다.<br/>
            인증번호를 입력해주세요.
          </DialogContentText>
          <TextField
            autoFocus
            autoComplete='off'
            margin="dense"
            label="인증번호"
            type="email"
            fullWidth
            variant="standard"
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>확인</Button>
          <Button onClick={handleClose}>취소</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default CertificationConfirm
