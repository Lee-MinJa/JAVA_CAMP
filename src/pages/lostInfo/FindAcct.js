import React from 'react';
import { Box, Button, createTheme, Grid, ThemeProvider, Typography, Modal, Link } from '@mui/material';
import FindAcctId from '../../components/lostInfo/FindAcctId';
import FindAcctPw from '../../components/lostInfo/FindAcctPw';


const theme = createTheme({
  palette: {
    palette: {
      lb: '#8ecae6'
      ,nb: '#219ebc'
      ,db: '#023047'
      ,lo: '#ffb703'
      ,no: '#fb8500',
    },
  },
});


function FindAcct(props) {
 return (
<div>
<ThemeProvider theme={theme}>
      <Box sx={{display: 'flex', alignItems: 'center', flexDirection: 'column'}}>
        <Typography variant='h2' sx={{mt:8}}>
        <Link href="/" underline="none" color="inherit">
         Hi, Camping
         </Link>
        </Typography>
        <Typography align="center" variant='h6' sx={{mt: 4, mb: 4}}>
            아이디/비밀번호 찾기
        </Typography>
        <Typography align="center" variant='h5' sx={{mt: 4, mb: 4}}>
        찾고싶은 항목을 선택해 주세요
        </Typography>
        <Button
          variant="contained" 
          sx={{width: 400, height: 70,  m:4, bgcolor: "palette.lb",'&:hover': {bgcolor: 'palette.nb'} }}>
        <FindAcctId />
        </Button>
        <Button
          variant="contained" 
          sx={{width: 400, height: 70, m:4,  bgcolor: "palette.lb",'&:hover': {bgcolor: 'palette.nb'} }}>
        <FindAcctPw />
        </Button>
      </Box>    
</ThemeProvider>
</div>
  );
}

export default FindAcct;