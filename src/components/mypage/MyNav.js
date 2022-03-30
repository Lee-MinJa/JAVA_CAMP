import { List, ListItem, ListItemButton, ListItemText } from '@mui/material';
import { Box } from '@mui/system';
import React from 'react';

function MyNav(props) {
  return (
    <div>
      <Box sx={{bgcolor: '#f0f8ff' }}>
        <List>
          <ListItem>
            <ListItemButton component="a" href="./mypage">
              <ListItemText align="center" primary="내가 쓴 글" />
            </ListItemButton>
          </ListItem>
          <ListItem>
            <ListItemButton component="a" href="./mypage">
              <ListItemText align="center" primary="캠핑장 리뷰" />
            </ListItemButton>
          </ListItem>
          <ListItem>
            <ListItemButton component="a" href="./promolist">
              <ListItemText align="center" primary="위시캠핑장" />
            </ListItemButton>
          </ListItem>
          <ListItem>
            <ListItemButton component="a" href="/BoardList" >
              <ListItemText align="center" primary="내정보 수정" />
            </ListItemButton>
          </ListItem>
        </List>
      </Box>
    </div>
  );
}

export default MyNav;