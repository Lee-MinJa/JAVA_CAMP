import React from "react";
import {
  Box,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
} from "@mui/material";

function BestPosting(props) {
  var items = [
    {
      글링크: "",
      글제목: "꼭 가세요 두 번 가세요!",
      댓글수: "221",
      이미지여부: "🎦",
    },
    {
      글링크: "",
      글제목: "전기사용이 안돼서 고...",
      댓글수: "189",
      이미지여부: "",
    },
    {
      글링크: "",
      글제목: "좋았어요!",
      댓글수: "128",
      이미지여부: "",
    },
  ];

  return (
    <Box>
      {items.map((item, i) => (
        <Item key={i} item={item} />
      ))}
    </Box>
  );
}
function Item(props) {
  return (
    <List>
      <ListItem disablePadding>
        <ListItemButton
          component="a"
          /* href={'/promo/'+글링크} */
        >
          <ListItemText
            primary={`${props.item.글제목}[${props.item.댓글수}]${props.item.이미지여부}`}
          />
        </ListItemButton>
      </ListItem>
    </List>
  );
}

export default BestPosting;
