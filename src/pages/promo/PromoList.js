import React from 'react';
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

function promoList(props) {
  return (
    <div>
       <ThemeProvider>
        <Box>
          <Typography
            align="left"
            variant="h2"
            gutterBottom
            sx={{ mb: 4, ml: 4 }}
          >
            <Link href="/" underline="none" color="inherit">
              <br />
              Hi, Camping
            </Link>
          </Typography>
        </Box>
        <Typography>홍보페이지</Typography>
        </ThemeProvider>
    </div>
  );
}

export default promoList;