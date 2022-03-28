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

export default function CustomizedTables() {

  const navigate = useNavigate()
  const reduxValue = useSelector((state) => state.alignment)
  const [page, setPage] = useState(0);
  const rowsPerPage = 10;
  const [boardData, setBoardData] = useState([{
    FREE_NUM : 0,
    FREE_SUBJECT : "",
    FREE_CONTENT : "",
    MEM_NUM : 0,
    FREE_REGDATE : "",
    FREE_TITLE : "",
    FREE_VIEWS : 0,
  }])

useEffect(() => {
  axios.get(`http://localhost:${pjPort}/${fBoardMain}/${fBoardGet}`).then((res) => {
    if(reduxValue.alignment === 'question'){
      setBoardData(res.data.filter(data => data.FREE_SUBJECT === '질문' ))
      setPage(0)
      // console.log('질문')
    } else if (reduxValue.alignment === 'boast'){
      setBoardData(res.data.filter(data => data.FREE_SUBJECT === '자랑하기' ))
      setPage(0)
      // console.log('자랑')
    } else if (reduxValue.alignment === 'share'){
      setBoardData(res.data.filter(data => data.FREE_SUBJECT === '무료나눔' ))
      setPage(0)
      // console.log('무료나눔')
    } else {
      setBoardData(res.data)
    }
    // console.log(res.data)
    
    console.log(boardData);
  })
},[reduxValue])

  const handleChangePage = (event, newPage) => {
    setPage(newPage - 1);
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
          {boardData
          .sort((a,b) => b.FREE_NUM-a.FREE_NUM)
          .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
          .map((row, i) => (
            <StyledTableRow
            key={i}
            sx={{
              cursor: 'pointer',
            }}
            hover
            onClick={()=> navigate('/BoardDetail/'+row.FREE_NUM ,{state:{
              boardNumber : row.FREE_NUM,
              boardTitle : row.FREE_TITLE,
              boradContent : row.FREE_CONTENT,
              boardDate : row.FREE_REGDATE,
              boardView : row.FREE_VIEWS,
              boardCategory : row.FREE_SUBJECT,
              boardWriter : row.MEM_NUM
            }})}
            >
              <StyledTableCell align="center" component="th" scope="row">
                {row.FREE_NUM}
              </StyledTableCell>
              <StyledTableCell align="center">{row.FREE_SUBJECT}</StyledTableCell>
              <StyledTableCell align="center">{row.FREE_TITLE}</StyledTableCell>
              <StyledTableCell align="center">{row.FREE_REGDATE}</StyledTableCell>
              <StyledTableCell align="center">{row.FREE_VIEWS}</StyledTableCell>
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
      height : '36px',
      ":hover" : {
        backgroundColor : 'white',
        color : 'black',
        borderColor : 'crimson'
      }
    }}
    onClick={() => navigate('/BoardInsert')}
    >글쓰기</Button>
    {/* </Box> */}
    </Box>
    </>
  );
}
