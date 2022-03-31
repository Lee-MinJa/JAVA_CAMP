import React from 'react';
import {
  Box,
  Link,
  Typography,
} from "@mui/material";

function Header(props) {
  return (
    <div>
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
    </div>
  );
}

export default Header;