import React, { useState } from "react";
import { createTheme } from "@mui/material/styles";
import {
  Box,
  Button,
  Drawer,
  Grid,
  IconButton,
  ListItemText,
  List,
  ListItem,
  Divider,
  ListItemButton,
  Typography,
  TextField,
} from "@mui/material";
import DarkModeIcon from "@mui/icons-material/DarkMode";
import MenuIcon from "@mui/icons-material/Menu";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import { useNavigate } from "react-router-dom";

const theme = createTheme({
  palette: {
    palette: {
      lb: "#8ecae6",
      nb: "#219ebc",
      db: "#023047",
      lo: "#ffb703",
      no: "#fb8500",
      mode: "dark",
    },
  },
});

function NavBar(props) {
  const navigate = useNavigate();
  // 사용자가 입력한 로그인 정보 상태 관리
  // const [loginForm, setLoginForm] = useState({
  //   mem_id: '',
  //   mem_pw: '',
  // });
  // // cookie에 값이 풀릴 때를 대비하고 화면렌더링 변화가 요구될 떄 
  // const [cmemname, setMemName] = useState('');
  // const [cmemUId, setMemId] = useState('');
  // // 로그인/로그아웃에 대한 화념전환을 위한 조건부 랜더링 변수 
  // const [isLoggedIn, setIsLoggedIn] = useState(false); 
  // // 사용자가 입력한 값에 대한 변화가 감지될 때마다 useState 초기화


  // 로그아웃 이벤트
  // const logout = () => {
  //   // 1. cookie에 저장된 값 삭제하기
  //   deleteCookie('cmem_name');
  //   deleteCookie('cmem_id');
  //   // 2. cookie연결이 풀렸을 때를 대비해 ustState 초기화하기
  //   setMemId('');
  //   setMemName('');
  //   // 3. 조건부 랜더링 옵션을 false(logout)로 초기화
  //   isLoggedIn(false);
  //   // 4. 로그인에 입력된 사용자 정보 초기화
  //   setLoginForm({mem_id: '', mem_pw:''});
  //   // 5. Main페이지로 이동
  //   navigate("/");
  // }
  // 사용자가 입력한 값의 변화에 따라 감지 
  // const handleChange = (e) => {
  //   const {name, value} = e.target; // 위에서 지정한 name(mem_id, mem_pw)에 접근
  //   // 기존에 받은 값(prevFormData)이 있다면 남겨두고 새정보 추가하기
  //   setLoginForm(prevFormDate => {
  //     return {
  //       ...prevFormDate,
  //       [name]: value
  //     }
  //   }) 
  // }

  // const handleSubmit = (e) => {
  //   e.preventDefault();
  //   // Oracle서버에 사용자가 입력한 데이터(id, pw) 넘겨서 응답 받기
  //   // axios대신 fetch로 사용
  //   fetch(`http://localhost:8000/loginAction2?mem_id=${loginForm.mem_id}&mem_pw=${loginForm.mem_pw}`)
  //   .then(res => res.json())
  //   .then(result => {
  //     setCookie('cmem_id', result[0].MEM_ID);
  //     setCookie('cmem_name', result[0].MEM_NAME);
  //     // Cookie가 풀리는 경우 대비
  //     setMemId(result[0].MEM_ID);
  //     setMemName(result[0].MEM_NAME);
  //     // 로그인 성공시 조건부 랜더링 실행
  //     setIsLoggedIn(true);
  //   })

  // }

  // 조건부 랜더링: 로그인/로그아웃 버튼
  // const LoginBefore = (props) => {
  //   return (
  //     <>
  //     <Box> 
  //         <Typography align="center" sx={{ mt: 2, mb: 2 }}>
  //           로그인을 해주세요.
  //         </Typography>
  //         <Box component="form" >
  //         <TextField label="아이디" name="mem_id" onChange={handleChange} />
  //         <TextField label="비밀번호" name="mem_pw" onChange={handleChange} />
  //         <Button variant="primary" type="submit" onClick={handleSubmit}>Login</Button>
  //         </Box>
  //     </Box>
  //     </>
  //   )
  // }
  // const LoginAfter = (props) => {
  //   return (
  //     <>
  //      <Box> 
  //         <Typography align="center" sx={{ mt: 2, mb: 2 }}>
  //           {signinNick}님 환영합니다
  //         </Typography>
  //         <Button variant="primary" onClick={logout}>logout</Button>
  //     </Box>
  //     </>
  //   )
  // }
  // // 조건부 랜더링: 화면 구현
  // const LogFormRender = (props) => {
  //   const isLoggedIn = props.isLoggedIn;
  //   if(isLoggedIn){
  //     return <LoginAfter />;
  //   } 
  //   return <LoginBefore />;
  // }

  const [state, setState] = React.useState({
    right: false,
  });

  const toggleDrawer = (anchor, open) => (event) => {
    setState({ ...state, [anchor]: open });
  };

  /* 로그인 후 닉네임 보여주기 */
  var signinNick = "";

  const list = (anchor) => (
    <Box
      sx={{ width: anchor === "top" || anchor === "bottom" ? "auto" : 250 }}
      role="presentation"
      onClick={toggleDrawer(anchor, false)}
    >
      {/* <LogFormRender isLoggedIn={isLoggedIn}/> */}
      {/* <Box> 
        {signinNick === "" ? (
          <Typography align="center" sx={{ mt: 2, mb: 2 }}>
            로그인을 해주세요.
          </Typography>
        ) : (
          <Typography align="center" sx={{ mt: 2, mb: 2 }}>
            {signinNick}님 환영합니다
          </Typography>
        )}
      </Box> */}

      <Divider />
      <Grid container spaxing={2} align="center" sx={{ padding: 2 }}>
        <Grid item xs={6}>
          <IconButton component="a" 
           onClick={() => navigate("/signin")}>
            <AccountCircleIcon fontSize="large" /> {/* 조건부 버튼 */}
          </IconButton>
        </Grid>
        <Grid item xs={6}>
          <IconButton>
            <DarkModeIcon fontSize="large" />
          </IconButton>
        </Grid>
      </Grid>
      <Divider />
      <Box sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}>
        <List>
          <ListItem>
            <ListItemButton component="a" 
            onClick={() => navigate("/mypage")}
            >
              <ListItemText align="center" primary="마이페이지" />
            </ListItemButton>
          </ListItem>
          <ListItem>
            <ListItemButton
              component="a"
              onClick={() => navigate("/BoardList")}
            >
              <ListItemText align="center" primary="자유게시판" />
            </ListItemButton>
          </ListItem>
          <ListItem>
            <ListItemButton 
            component="a" 
            onClick={() => navigate("/promolist")}>
              <ListItemText align="center" primary="홍보게시판" />
            </ListItemButton>
          </ListItem>
        </List>
      </Box>
      <Box sx={{ bottom: 10, position: "absolute" }}>
        <Typography align="center">Copyright © Team JavaCamp</Typography>
      </Box>
    </Box>
  );

  return (
    <div>
      {["right"].map((anchor) => (
        <React.Fragment key={anchor}>
          <Grid
            container
            justifyContent="flex-end"
            position="fixed"
            sx={{ zIndex: "tooltip" }}
          >
            <IconButton onClick={toggleDrawer(anchor, true)}>
              <MenuIcon fontSize="large" />
            </IconButton>
          </Grid>
          <Drawer
            sx={{ zIndex: "tooltip" }}
            anchor={anchor}
            open={state[anchor]}
            onClose={toggleDrawer(anchor, false)}
          >
            {list(anchor)}
          </Drawer>
        </React.Fragment>
      ))}
    </div>
  );
}

export default NavBar;
