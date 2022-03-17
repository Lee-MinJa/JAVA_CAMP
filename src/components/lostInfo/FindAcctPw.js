import React, { useRef, useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import { Grid, TextField } from "@mui/material";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

export default function FindAcctPw() {
  /* ////// 찾기 Modal창 여닫기 ////// */
  const [openForm, setOpenForm] = React.useState(false);
  const handleOpenForm = () => setOpenForm(true);
  const handleCloseForm = () => setOpenForm(false);
  
  /* ////// 결과 Modal창 여닫기 ////// */
  const [openResult, setOpenResult] = React.useState(false);
  const handleOpenResult = () => setOpenResult(true);


  /* (임시)비번찾기시 입력한 정보 제출하기 */
  const handleSubmit = (event) => {
    const findInfo = new FormData(event.currentTarget);
    console.log({
      id: findInfo.get("id"),
      email: findInfo.get("email"),
      birthdate: findInfo.get("birthdate"),
      fullName: findInfo.get("fullName"),
      mobile: findInfo.get("mobile"),
    });
  };

  /* ////// 변경한 비밀번호 일치여부 확인 ////// */
  const updatedPw = useRef('')
  const updatedPwCk = useRef('')
  const onSubmit = (event) => {
    event.preventDefault()
    const updatedPwFin =updatedPw.current.value
    const updatedPwCkFin =updatedPwCk.current.value
    if(updatedPwFin !== updatedPwCkFin) {
      return alert("비밀번호가 일치하지 않습니다.")
    } else {
      return setOpenForm(false)
    }
}

  return (
    <div>
      <Box onClick={handleOpenForm}>
        <Typography align="center" variant="h5">
          비밀번호 찾기
        </Typography>
      </Box>
      <Modal open={openForm} onClose={handleCloseForm}>
        <Box sx={style} component="form" onSubmit={handleSubmit}>
          <Typography align="center" variant="h4">
            비밀번호 찾기
          </Typography>
          <Typography align="center" variant="h6">
            회원가입시 사용한 정보를 입력해 주세요.
          </Typography>
          <Grid container spacing={3} sx={{ pt: 4 }}>
            <Grid item xs={12}>
              <TextField
                autoFocus
                required
                fullWidth
                id="id"
                label="아이디"
                name="id"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="email"
                label="이메일"
                name="email"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="birthdate"
                label="생년월일"
                name="birthdate"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                name="fullName"
                required
                fullWidth
                id="fullName"
                label="성명"
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                name="mobile"
                required
                fullWidth
                id="mobile"
                label="연락처"
              />
            </Grid>
          </Grid>
          <Grid container>
            <Grid item xs>
              <Button
                type="submit"
                variant="contained"
                onClick={handleOpenResult}
                sx={{
                  mt: 3,
                  mb: 2,
                  color: "000",
                  bgcolor: "palette.lo",
                  "&:hover": { bgcolor: "palette.no" },
                }}
              >
                비밀번호 찾기
              </Button>
              {/* /// 결과있음: 비밀번호 수정 Modal  ////////////////////////*/}
              <Modal open={openResult} onClose={handleCloseForm}>
                <Box sx={style}>
                  <Box
                    component="form"
                    sx={{
                      display: "flex",
                      alignItems: "center",
                      flexDirection: "column",
                    }}
                  >
                    <Typography align="center">
                      비밀번호를 변경해주세요.
                    </Typography>
                    <Grid container spacing={3} sx={{ pt: 4 }}>
                      <Grid item xs={12}>
                        <TextField
                          required
                          fullWidth
                          type="password"
                          id="updatedPw"
                          inputRef={updatedPw}
                          label="새 비밀번호"
                        />
                      </Grid>
                      <Grid item xs={12}>
                        <TextField
                          required
                          fullWidth
                          type="password"
                          id="updatedPwCk"
                          inputRef={updatedPwCk}
                          label="비밀번호 확인"
                        />
                      </Grid>
                    </Grid>
                    {/* R: 비번과 비번확인 일치하는지 확인메시지 필요 */}
                    <Button
                      onClick={onSubmit}
                      href="/signin"
                      variant="contained"
                      sx={{
                        mt: 4,
                        bgcolor: "palette.lo",
                        "&:hover": { bgcolor: "palette.no" },
                      }}
                    >
                      변경
                    </Button>
                  </Box>
                </Box>
              </Modal>
              {/* /// 결과없음: 가입or아이디 찾기 modal: DB연결후 조건부로 수정 ////////////////////////*/}
              {/*           <Modal
              open={openResult}
              onClose={handleCloseForm}
              >
                 <Box sx={style} >
                   <Box sx={{display: 'flex', alignItems: 'center', flexDirection: 'column'}}>
                   <Typography align="center">존재하지 않는 계정입니다.</Typography>
                <Button  
                href='/findacct' 
                variant="contained"
                sx={{bgcolor:"palette.lo",'&:hover': {bgcolor: 'palette.no'}}}>
                  아이디 찾기</Button>
                   </Box>
                 </Box>
              </Modal> */}
            </Grid>
            <Grid item>
              <Button
                onClick={handleCloseForm}
                variant="contained"
                sx={{
                  mt: 3,
                  mb: 2,
                  bgcolor: "palette.lo",
                  "&:hover": { bgcolor: "palette.no" },
                }}
              >
                취소
              </Button>
            </Grid>
          </Grid>
        </Box>
      </Modal>
    </div>
  );
}
