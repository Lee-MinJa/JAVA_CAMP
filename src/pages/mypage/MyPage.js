import React from "react";
import {
  Box,
  Card,
  CardContent,
  createTheme,
  Divider,
  Grid,
  Link,
  ThemeProvider,
  Typography,
} from "@mui/material";
import MyNav from "../../components/mypage/MyNav";

function MyPage(props) {
  return (
    <div>
      <ThemeProvider>
        <Grid container>
          {/* 마이페이지 네비게이션 */}
          <Grid item xs={2}>
            <MyNav />
          </Grid>
          {/* 마이페이지 화면 */}
          <Grid item xs={10}></Grid>
        </Grid>
      </ThemeProvider>
    </div>
  );
}

export default MyPage;
