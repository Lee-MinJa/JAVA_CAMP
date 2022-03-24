import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { Box, Button, Pagination, PaginationItem, Stack } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import { fBoardGet, fBoardMain, pjPort } from '../MappingDB'
import axios from 'axios';

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: '#00B4D8',
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  root: {
    height: 30,
    maxHeight : 30
  }
}));

// const options: Options = {
//   ...
//   rowStyle: {height: 50},
//   ...
// }

// const StyledTableRow = withStyles((theme) => ({
//   root: {
//     height: 30
//   }
// }))(TableRow);


export default function CustomizedTables() {

  const navigate = useNavigate()
  const reduxValue = useSelector((state) => state.alignment)
  // const [getSample, setGetSample] = useState([])
  const [page, setPage] = React.useState(0);
  const rowsPerPage = 10;
  const [boardData, setBoardData] = useState([{
    free_num : 0,
    free_subject : "",
    free_content : "",
    mem_num : 0,
    free_regdate : "",
    free_title : "",
    free_views : 0,
  }])

//setGetSample(res.data)

useEffect(() => {
  axios.get(`http://localhost:${pjPort}/${fBoardMain}/${fBoardGet}`).then((res) => {
    if(reduxValue.alignment === 'question'){
      setBoardData(res.data.filter(data => data.free_subject === '질문' ))
      setPage(0)
      console.log('질문')
    } else if (reduxValue.alignment === 'boast'){
      setBoardData(res.data.filter(data => data.free_subject === '자랑하기' ))
      setPage(0)
      console.log('자랑')
    } else if (reduxValue.alignment === 'share'){
      setBoardData(res.data.filter(data => data.free_subject === '무료나눔' ))
      setPage(0)
      console.log('무료나눔')
    } else {
      setBoardData(res.data)
    }
    // console.log(res.data)
    
    //console.log(boardData);
  })
},[reduxValue])



// useEffect(() => {
//   setGetSample(sampleData.data)
//   loadData()
//   // console.log(reduxValue)
//   // console.log(boardData)
// },[reduxValue, getSample])

//[reduxValue] || [getSample]

const loadData = () => {
  
}

  const handleChangePage = (event, newPage) => {
    setPage(newPage -1);
  };

  return (
    <>
    <TableContainer component={Paper}>
      <Table sx={{ maxHeight: '80vh', minHeight: 600, minWidth: 700 }}>
        <TableHead>
          <TableRow>
            <StyledTableCell align="center">번호</StyledTableCell>
            <StyledTableCell align="center">주제</StyledTableCell>
            <StyledTableCell align="center">제목</StyledTableCell>
            <StyledTableCell align="center">작성일</StyledTableCell>
            <StyledTableCell align="center">조회수</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody >
          {boardData.sort((a,b) => b.free_num-a.free_num).slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => (
            <StyledTableRow
            key={row.free_num}
            sx={{
              cursor: 'pointer',
            }}
            hover
            onClick={()=> navigate('/BoardDetail/'+row.free_num ,{state:{
              boardNumber : row.free_num,
              boardTitle : row.free_title,
              boradContent : row.free_content,
              boardDate : row.free_regdate,
              boardView : row.free_views,
              boardCategory : row.free_subject,
              boardWriter : row.mem_num
            }})}
            >
              <StyledTableCell align="center" component="th" scope="row">
                {row.free_num}
              </StyledTableCell>
              <StyledTableCell align="center">{row.free_subject}</StyledTableCell>
              <StyledTableCell align="center">{row.free_title}</StyledTableCell>
              <StyledTableCell align="center">{row.free_regdate}</StyledTableCell>
              <StyledTableCell align="center">{row.free_views}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    <Box
    marginTop={'10px'}
    sx={{
      display: 'flex',
      justifyContent: 'space-between',
      p: 1,
      bgcolor: 'background.paper',
      borderRadius: 1,
    }}
    >
    <Box>
      
    </Box>
    <Box>
    <Pagination
      color={'primary'}
      page={page + 1}
      count={Math.ceil(boardData.length/10)} //총 데이터수 /10
      onChange={handleChangePage}
      renderItem={(CustomizedTables) => (
        <PaginationItem
        // component={Link} 현업에서 사용하는 방식으로 교체시 사용.
        // to={`/BoardList${page === 1 ? '' : `?page=${CustomizedTables.page}`}`}
          {...CustomizedTables}
        />
      )}
    />
    </Box>
    <Button
    variant='contained'
    sx={{
      color : 'white',
      height : '36px'
    }}
    onClick={() => navigate('/BoardInsert')}
    >글쓰기</Button>
    {/* </Box> */}
    </Box>
    </>
  );
}
