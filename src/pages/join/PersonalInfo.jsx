import React, { useEffect, useState } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { Stack } from '@mui/material'
import { useRecoilState } from 'recoil';
import { regUserState } from '../../components/board/RecoilAtom'

function PersonalInfo() {

  const [userState, setUserState] = useRecoilState(regUserState)
  const [pwMatch, setPwMatch] = useState(false)

  const handleChange = (e) => {
    setUserState({
      ...userState,
      [e.target.name] : e.target.value
    })
    console.log(userState)
  }

  const checkPw = () => {

  }

  const handleSubmit = (event) => {
    event.preventDefault();
    if(userState.userPw !== userState.passwordConfirm){
      alert('비밀번호가 일치하지 않습니다.')
    document.getElementById('userPw').focus()
    }else{
      const data = new FormData(event.currentTarget);
      console.log(userState.userId);
    }
  };

  return (
    <Stack 
    justifyContent={'center'}
    alignItems={'center'}
    textAlign={'center'}
    >
      <Box
      width={'580px'}
      justifyContent={'center'}
      alignItems={'center'}
      textAlign={'center'}>
      <Box>
          <h2>Hi Camping</h2>
        </Box>
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            회원 정보 입력
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12} sm={10}>
                <TextField
                  value={userState.userId}
                  autoComplete="off"
                  name="userId"
                  required
                  fullWidth
                  label="아이디"
                  autoFocus
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12} sm={2}>
                <Button sx={{height : '56px'}} variant='outlined'>중복확인</Button>
              </Grid>
              <Grid item xs={6}>
                <TextField
                  value={userState.userPw}
                  required
                  fullWidth
                  id='userPw'
                  name="userPw"
                  label="비밀번호"
                  type="password"
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={6}>
                <TextField
                value={userState.passwordConfirm}
                required
                fullWidth
                name="passwordConfirm"
                label="비밀번호 확인"
                type="password"
                onChange={handleChange}
              />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  value={userState.birth}
                  required
                  fullWidth
                  label="생년월일"
                  name="birth"
                  autoComplete="off"
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  value={userState.userName}
                  required
                  fullWidth
                  label="성명"
                  name="userName"
                  autoComplete="off"
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  value={userState.phoneNumber}
                  required
                  fullWidth
                  label="연락처"
                  name="phoneNumber"
                  autoComplete="off"
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={10}>
                <TextField
                  value={userState.nickName}
                  required
                  fullWidth
                  label="닉네임"
                  name="nickName"
                  autoComplete="off"
                  onChange={handleChange}
                />
              </Grid>
              <Grid item xs={2}>
              <Button sx={{height : '56px'}} variant='outlined'>중복확인</Button>
              </Grid>
              <Grid item xs={12}>
                <FormControlLabel
                  control={<Checkbox value="allowExtraEmails" color="primary" />}
                  label="캠핑장 특가 프로모션 및 할인 쿠폰을 받겠습니다."
                />
              </Grid>
            </Grid>
            <Button
              type="submit"
              variant="contained"
              sx={{
                mt: 3,
                mb: 2,
                color : 'white',
                width : '180px',
                ":hover" : {
                  backgroundColor : 'white',
                  color : 'black',
                  borderColor : '#FF8500'
                }
              }}
            >
              가입하기
            </Button>
          </Box>
        </Box>
      </Box>
      </Stack>
  );
}

export default PersonalInfo;
