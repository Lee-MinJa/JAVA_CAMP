import React from "react";
import {
  Box,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
} from "@mui/material";

function BestPlace(props) {
  var items = [
    {
      글링크: "",
      장소명: "단양",
      캠핑장명: "소선암 오토 캠핑장",
      별점: "★★★★☆",
    },
    {
      글링크: "",
      장소명: "홍천",
      캠핑장명: "보리울 캠핑장",
      별점: "★★★★☆",
    },
    {
      글링크: "",
      장소명: "충주",
      캠핑장명: "수주팔봉 캠핑장",
      별점: "★★★★☆",
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
            primary={`[${props.item.장소명}]${props.item.캠핑장명}${props.item.별점}`}
          />
        </ListItemButton>
      </ListItem>
    </List>
  );
}

export default BestPlace;
