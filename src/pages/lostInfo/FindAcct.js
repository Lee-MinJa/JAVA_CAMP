import React, { useEffect, useRef, useState } from "react";
import { Button, Grid, Link, TextField, Box, Typography } from "@mui/material";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import axios from "axios";

const theme = createTheme({
  palette: {
    palette: {
      lb: "#8ecae6",
      nb: "#219ebc",
      db: "#023047",
      lo: "#ffb703",
      no: "#fb8500",
    },
  },
});
/* 외부 작성(작성자 미상) */

/* SignIn 함수 //////////////////////////////////////////////////////////////////////////// */
function SignIn(props) {
  /* 회원정보가 없는 경우 메시지 보이기 */
  // form과 submit이용하는 경우
  // const handleSubmit = (event) => {
  //   const signInData = new FormData(event.currentTarget);
  //   console.log({
  //     id: signInData.get('signinid')
  //     , pw: signInData.get('signinpw')
  //   });
  // }

  /* ref이용해서 데이터 전달하는 경우 */
  const signinId = useRef("");
  const signinPw = useRef("");
  const onClickSignIn = (e) => {
    e.preventDefault();
    const signinIdFin = signinId.current.value;
    const signinPwFin = signinPw.current.value;
    const signinInfo = {
      signinId: signinId.current.value,
      signinPw: signinPw.current.value,
    };
    /* 로한 작성중 */
    axios
      .get("/memberList", {
        params: {
          mem_id: signinIdFin,
          mem_pw: signinPwFin,
        },
      })
      .then((window.location.href = "/"))
      .catch();

    /* /// 외부 작성(작성자 미상) ///////////// */
    // axios.get(`http://localhost:8000/member/login?MEM_ID=${signinInfo.signinId}&MEM_PW=${signinInfo.signinPw}`)
    // .then(response => {
    //   console.log(response.data);
    //   alert(response.data[0].MEM_NICK);
    //   setCookie('MEM_NICK',response.data[0].MEM_NICK,3);
    //   window.location.href='/'
    // })
    /* ////외부작성 종료///////////////////// */
    /* 로그인시 입력된 정보 확인 */
    return alert(`ID: ${signinIdFin} / PW: ${signinPwFin}`);
  };
  
   /* 입력창 채워야 버튼 활성화 이벤트 */
   const [btnOff, setBtnOff] = useState(true);
 const btnAble = (e) => {
   e.preventDefault(); 
   const signinIdFin = signinId.current.value;
   const signinPwFin = signinPw.current.value;
   ( signinIdFin.length > 0 && signinPwFin.length > 0   
     ? setBtnOff(false)
     : setBtnOff(true)
   )
 return btnOff;
 }

  return (
    <div>
      <ThemeProvider theme={theme}>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            flexDirection: "column",
            mb: 8,
          }}
        >
          <Typography variant="h5" sx={{ mb: 2 }}>
            로그인
          </Typography>
          {/* 회원정보가 없는 경우에만 보이기 */}
          {/*
          <Typography variant='h6' sx={{color: 'palette.no'}}>
         존재하지 않는 계정입니다.
          </Typography> 
        */}
          <Box
            component="form"
            // onSubmit={handleSubmit}
            sx={{ width: 400 }}
          >
            <TextField
              required
              fullWidth
              autoFocus
              label="아이디"
              id="signinId"
              name="signinId"
              inputRef={signinId}
              sx={{ mt: 3, mb: 2 }}
            />
            <TextField
              required
              fullWidth
              type="password"
              label="비밀번호"
              id="signinPw"
              name="signinPw"
              inputRef={signinPw}
              onChange={btnAble}
            />
            <Button
              fullWidth
              type="submit"
              disabled={btnOff}
              onClick={onClickSignIn}
              variant="contained"
              sx={{
                mt: 3,
                mb: 2,
                bgcolor: "palette.lo",
              }}
            >
              로그인
            </Button>
            <Grid container spacing={2}>
              <Grid item xs style={{ display: "flex", alignItems: "center" }}>
                <Link href="./FindAcct">아이디/비밀번호찾기</Link>
              </Grid>
              <Grid item alignItems="center" justify="flex-end">
                <Link href="./Biz_info">가입하기</Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </ThemeProvider>
    </div>
  );
}

export default SignIn;
