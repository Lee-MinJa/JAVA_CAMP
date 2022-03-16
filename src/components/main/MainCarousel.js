import React from 'react';
import Carousel from 'react-material-ui-carousel'
import { Button, Grid, Paper, Typography} from '@mui/material'
import { createTheme } from "@mui/material";


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

function MainCarousel(props)
{
    var items = [
        {
            name: "캠핑장명1",
            description: "캠핑장 한줄소개 1"
        },
        {
            name: "캠핑장명2",
            description: "캠핑장 한줄소개 2"
        },
        {
            name: "캠핑장명3",
            description: "캠핑장 한줄소개 3"
        }
    ]

    return (
        <Carousel indicators={false}>
            {
                items.map( (item, i) => <Item key={i} item={item} /> )
            }
        </Carousel>
    )
}

function Item(props)
{
    return ( 
        <Paper >
            <Grid container sx={{height:400}}>
                <Grid item xs={7} sx={{bgcolor:'palette.db'}}>
                <Typography sx={{color:'white'}}>(캠핑장 이미지 삽입)</Typography>    
                </Grid>
                <Grid item xs={5} align="left" sx={{bgcolor:'palette.lo'}}> 
            <Typography variant="h4" sx={{padding:4}}>{props.item.name}</Typography>
            <Typography variant="subtitle1" sx={{padding:4}}>{props.item.description}</Typography>
            <Button variant="outlined" sx={{margin:4}}>둘러보기</Button>
                </Grid>
            </Grid>
        </Paper>
    )
}

export default MainCarousel;

