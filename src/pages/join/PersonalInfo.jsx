import React, { useState, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
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
import { emailState } from '../../components/board/RecoilAtom'
import { idOverlap, nickOverlap, userRegist } from '../../components/board/MappingDB'
import axios from 'axios'

function PersonalInfo() {

  const navigate = useNavigate()
  const [email, setEmail] = useRecoilState(emailState)
  const [userIdMsg, setUserIdMsg] = useState('')
  const [userPassMsg, setUserPassMsg] = useState('')
  const [userPassConfirmMsg, setUserPassConfirmMsg] = useState('')
  const [userPhoneNumberMsg, setUserPhoneNumberMsg] = useState('')
  const [userNameMsg, setUserNameMsg] = useState('')
  const [userNickMsg, setUserNickMsg] = useState('')

  const [isUserId, setIsUserId] = useState(false)
  const [isUserPass, setIsUserPass] = useState(false)
  const [isPasswordConfirm, setIsPasswordConfirm] = useState(false)
  const [isUserPhoneNumber, setIsUserPhoneNumber] = useState(false)
  const [isUserName, setIsUserName] = useState(false)
  const [isUserNick, setIsUserNick] = useState(false)

  const [resultColor, setResultColor] = useState('black')
  const [userId, setUserId] = useState('')
  const [userPass, setUserPass] = useState('')
  const [userPassConfirm, setUserPassConfirm] = useState('')
  const [userPhoneNumber, setUserPhoneNumber] = useState('')
  const [userName, setUserName] = useState('')
  const [userNick, setUSerNick] = useState('')

  const handleChangeUserId = useCallback((e) => {
    setUserId(e.target.value)
    if (e.target.value.length < 4 || e.target.value.length > 10) {
      setUserIdMsg('4??? ?????? 10??? ???????????? ??????????????????.')
      setIsUserId(false)
      setResultColor('red')
    } else {
      setUserIdMsg('????????? ????????? ???????????????.')
      setIsUserId(true)
      setResultColor('blue')
    }
  }, [])

  const handleCheckId = () => {
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setUserNameMsg('')
    const url = idOverlap + userId
    if(isUserId !== false) {
    axios.get(url).then((res) => {
        if(res.data[0].MEM_ID == 'undefined'){
          setUserIdMsg('????????? ????????? ???????????????.')
          setResultColor('blue')
        }
        else {
          setUserIdMsg('?????? ????????? ???????????? ?????????.')
          setIsUserId(false)
        setResultColor('red')
      }
    })}else{
      setUserIdMsg('4??? ?????? 10??? ???????????? ??????????????????.')
      setIsUserId(false)
      setResultColor('red')
    }
  }

  const handleChangePassword = useCallback((e) => {
    const pwMixture = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/
    const passwordCurrent = e.target.value
    setUserPass(passwordCurrent)
    setUserIdMsg('')
    setResultColor('red')

    if (!pwMixture.test(passwordCurrent)) {
      setUserPassMsg('??????+?????????+???????????? ?????? 8?????? ?????? ??????????????????.')
      setIsUserPass(false)
    } else {
      setUserPassMsg('????????? ??????????????????.')
      setIsUserPass(true)
      setResultColor('blue')
    }
  }, [])

  const handleChangePasswordConfirm = useCallback((e) => {
      const passwordConfirmCurrent = e.target.value
      setUserPassConfirm(passwordConfirmCurrent)

      if (userPass === passwordConfirmCurrent) {
        setUserPassConfirmMsg('??????????????? ????????????.')
        setIsPasswordConfirm(true)
        setResultColor('blue')
      } else {
        setUserPassConfirmMsg('????????? ??????????????? ?????????.')
        setIsPasswordConfirm(false)
        setResultColor('red')
      }
    },
    [userPass]
  )

  const handleChangeUserName = useCallback((e) => {
    const pattern = /[???-???|???-???|???-???]/;
    const userNameCurrent = e.target.value
    setUserName(userNameCurrent)
    setUserIdMsg('')
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setResultColor('red')

    if(!pattern.test(userNameCurrent)) {
      setUserNameMsg('????????? ????????? ????????????.')
      setIsUserName(false)
    }else {
      setUserNameMsg('?????? ????????? ????????????.')
      setIsUserName(true)
      setResultColor('blue')
    }
  } , [])

  const handleChangeUserPhoneNumber = useCallback((e) => {
    const pattern = /[0-9].{9,12}$/;
    const userPhoneNumber = e.target.value
    setUserPhoneNumber(userPhoneNumber)
    setUserIdMsg('')
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setUserNameMsg('')
    setResultColor('red')

    if(!pattern.test(userPhoneNumber)) {
      setUserPhoneNumberMsg('10~11??? ????????? ????????? ????????????. ?????????(-)??? ???????????? ????????????.')
      setIsUserPhoneNumber(false)
    }else {
      setUserPhoneNumberMsg('????????? ????????? ????????????.')
      setResultColor('blue')
      setIsUserPhoneNumber(true)
      if (userPhoneNumber.length === 10) {
        setUserPhoneNumber(userPhoneNumber.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3'));
      }
      if (userPhoneNumber.length === 13) {
        setUserPhoneNumber(userPhoneNumber.replace(/-/g, '').replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3'));
      }
    }
  }, [])


  const handleChangeUserNick = useCallback((e) => {
    setUserIdMsg('')
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setUserNameMsg('')
    setUserPhoneNumberMsg('')
    setResultColor('red')
    setUSerNick(e.target.value)
    if(e.target.value.length < 3 || e.target.value.length > 8){
      setUserNickMsg('3??? ?????? 8??? ???????????? ??????????????????.')
      setIsUserNick(false)
      setResultColor('red')
    } else {
      setUserNickMsg('????????? ????????? ???????????????.')
      setIsUserNick(true)
      setResultColor('blue')
    }

  }, [])

  const handleCheckNick = () => {
    setUserIdMsg('')
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setUserNameMsg('')
    setUserPhoneNumberMsg('')
    const url = nickOverlap + userNick
    if(isUserNick !== false) {
    axios.get(url).then((res) => {
        if(res.data[0].MEM_NICK == 'undefined'){
          setUserNickMsg('????????? ????????? ??????????????????.')
          setIsUserNick(true)
          setResultColor('blue')
        }
        else {
          setUserNickMsg('?????? ????????? ???????????? ?????????.')
          setIsUserNick(false)
        setResultColor('red')
      }
    })}else{
      setUserIdMsg('4??? ?????? 10??? ???????????? ??????????????????.')
      setIsUserNick(false)
      setResultColor('red')
    }
  }

  const handleSubmit = () => {
    setUserIdMsg('')
    setUserPassMsg('')
    setUserPassConfirmMsg('')
    setUserNameMsg('')
    setUserPhoneNumberMsg('')
    setUserNickMsg('')
      
  if(isUserId !== false 
    && isUserPass !== false
    && isUserName !== false 
    && isUserPhoneNumber !== false
    && isUserNick !== false)
  {
      const url = userRegist
      const data = {
        mem_code : 1,
        mem_id : userId,
        mem_pw : userPass,
        mem_nick : userNick,
        mem_name : userName,
        mem_email : email,
        mem_tel : userPhoneNumber,
      }
      
      // axios.post(url, data).then((res) => {
      //   alert(email);
        
      //   console.log(res.data)
      //   navigate('/signin')
      //   setEmail('')
      // })
      axios.post(url+`?mem_code=${data.mem_code}&mem_id=${data.mem_id}&mem_pw=${data.mem_pw}&mem_nick=${data.mem_nick}&mem_email=${email}
      &mem_tel=${data.mem_tel}&mem_name=${data.mem_name}`)
      .then((res) => {
        console.log(res.data)
        navigate('/signin')
        setEmail('')
      })
  } else { console.log('????????????' , isUserId, isUserPass, isUserName, isUserPhoneNumber, isUserNick)}
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
            marginTop: 6,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            ?????? ?????? ??????
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid marginBottom={1} item xs={12} sm={10}>
                <TextField
                  value={userId}
                  autoComplete="off"
                  spellCheck="false"
                  name="userId"
                  required
                  fullWidth
                  label="?????????"
                  autoFocus
                  onChange={handleChangeUserId}
                />
                <Box position={'absolute'}>
                <Typography 
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userIdMsg}
                </Typography>
                </Box>
              </Grid>
              <Grid marginBottom={1} item xs={12} sm={2}>
                <Button
                onClick={handleCheckId}
                sx={{height : '56px'}} 
                variant='outlined'>????????????</Button>
              </Grid>
              <Grid marginBottom={1} item xs={6}>
                <TextField
                  value={userPass}
                  required
                  fullWidth
                  id='userPw'
                  name="userPw"
                  label="????????????"
                  type="password"
                  onChange={handleChangePassword}
                />
                <Box position={'absolute'}>
                <Typography
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userPassMsg}
                </Typography>
                </Box>
              </Grid>
              <Grid item xs={6}>
                <TextField
                value={userPassConfirm}
                required
                fullWidth
                name="passwordConfirm"
                label="???????????? ??????"
                type="password"
                onChange={handleChangePasswordConfirm}
              />
              <Box position={'absolute'}>
                <Typography 
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userPassConfirmMsg}
                </Typography>
                </Box>
              </Grid>
              <Grid marginBottom={1} item xs={12}>
                <TextField
                  value={userName}
                  required
                  fullWidth
                  label="??????"
                  name="userName"
                  autoComplete="off"
                  onChange={handleChangeUserName}
                />
                <Box position={'absolute'}>
                <Typography 
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userNameMsg}
                </Typography>
                </Box>
              </Grid>
              {/* <Grid marginBottom={1} item xs={12}>
                <TextField
                  value={userState.birth}
                  required
                  fullWidth
                  label="????????????(YYYYMMDD)"
                  name="birth"
                  autoComplete="off"
                  onChange={handleChange}
                />
              </Grid> */}
              <Grid marginBottom={1} item xs={12}>
                <TextField
                  value={userPhoneNumber}
                  required
                  fullWidth
                  label="?????????"
                  name="phoneNumber"
                  autoComplete="off"
                  onChange={handleChangeUserPhoneNumber}
                />
                                <Box position={'absolute'}>
                <Typography 
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userPhoneNumberMsg}
                </Typography>
                </Box>
              </Grid>
              <Grid item xs={10}>
                <TextField
                  value={userNick}
                  required
                  fullWidth
                  label="?????????"
                  name="userNick"
                  autoComplete="off"
                  onChange={handleChangeUserNick}
                />
                <Box position={'absolute'}>
                <Typography 
                sx={{color : resultColor}} 
                variant="caption" 
                display="block" 
                gutterBottom>
                  {userNickMsg}
                </Typography>
                </Box>
              </Grid>
              <Grid item xs={2}>
              <Button
              onClick={handleCheckNick}
              sx={{height : '56px'}} 
              variant='outlined'>????????????</Button>
              </Grid>
              <Grid item xs={12}>
                <FormControlLabel
                  control={<Checkbox color="primary" />}
                  label="????????? ?????? ???????????? ??? ?????? ????????? ???????????????."
                />
              </Grid>
            </Grid>
            <Button
              onClick={handleSubmit}
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
              ????????????
            </Button>
          </Box>
        </Box>
      </Box>
      </Stack>
  );
}

export default PersonalInfo;
