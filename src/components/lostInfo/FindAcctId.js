import * as React from "react";
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

export default function FindAcctId() {
  const [openForm, setOpenForm] = React.useState(false);
  const handleOpenForm = () => setOpenForm(true);
  const handleCloseForm = () => setOpenForm(false);

  const [openResult, setOpenResult] = React.useState(false);
  const handleOpenResult = () => setOpenResult(true);
  const handleCloseResult = () => setOpenResult(false);

  const handleSubmit = (event) => {
    const findInfo = new FormData(event.currentTarget);
    console.log({
      email: findInfo.get("email"),
      birthdate: findInfo.get("birthdate"),
      fullName: findInfo.get("fullName"),
      mobile: findInfo.get("mobile"),
    });
  };

  return (
    <div>
      <Box onClick={handleOpenForm}>
        <Typography align="center" variant="h5">
          아이디 찾기
        </Typography>
      </Box>
      {/* 찾기 modal */}
      <Modal open={openForm} onClose={handleCloseForm}>
        <Box sx={style} component="form" onSubmit={handleSubmit}>
          <Typography align="center" variant="h4">
            아이디 찾기
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
                onClick={handleOpenResult}
                type="submit"
                variant="contained"
                sx={{
                  mt: 3,
                  mb: 2,
                  color: "000",
                  bgcolor: "palette.lo",
                  "&:hover": { bgcolor: "palette.no" },
                }}
              >
                아이디 찾기
              </Button>
              {/* //// 결과있음 modal  /////////////////// */}
              <Modal open={openResult} onClose={handleCloseForm}>
                <Box sx={style}>
                  <Box
                    sx={{
                      display: "flex",
                      alignItems: "center",
                      flexDirection: "column",
                    }}
                  >
                    <Typography align="center">
                      회원님의 아이디입니다.
                    </Typography>
                    <Typography align="center">Camper111</Typography>
                    <Button
                      href="/signin"
                      variant="contained"
                      sx={{
                        bgcolor: "palette.lo",
                        mt:3,
                        "&:hover": { bgcolor: "palette.no" },
                      }}
                    >
                      로그인하러 가기
                    </Button>
                  </Box>
                </Box>
              </Modal>
              {/* //// 결과없음 modal: DB연결후 조건부로 수정 ///////////////////////////////
              <Modal
              open={openResult}
              onClose={handleCloseResult}
              >
                 <Box sx={style} >
                   <Box sx={{display: 'flex', alignItems: 'center', flexDirection: 'column'}}>
                   <Typography align="center">존재하지 않는 계정입니다.</Typography>
                     <Button  
                href='/가입페이지' 
                variant="contained"
                sx={{bgcolor:"palette.lo",'&:hover': {bgcolor: 'palette.no'}}}>
                  가입하러 가기</Button>          
                   </Box>
                 </Box>
              </Modal> 
              ////////////////////////////////////////////////////////////////////////////*/}
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
