import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { TablePagination, Box, Button, Pagination, PaginationItem } from '@mui/material';
import { useDispatch, useSelector } from 'react-redux';
import sampleData from './sampleData.json'

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
  '&:nth-of-type(odd)': {
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));


export default function CustomizedTables() {

  const navigate = useNavigate()
  const reduxValue = useSelector((state) => state.alignment)
  const [getSample, setGetSample] = useState([])
  const [page, setPage] = React.useState(0);
  const rowsPerPage = 10;
  const [boardData, setBoardData] = useState([{
    b_no : "",
    b_category : "",
    b_content : "",
    b_writer : "",
    b_date : "",
    b_title : "",
    b_view : 0,
  }])

/*

useEffect(() => {
  Axios.get('http://localhost:8000/api/BoardGet').then((res) => {
    setBoardData(res.data);
    //console.log(boardData);
  })
},[])

*/

useEffect(() => {
  setGetSample(sampleData.data)
  loadData()
  // console.log(reduxValue)
  // console.log(boardData)
},[reduxValue, getSample])

//[reduxValue] || [getSample]

const loadData = () => {
  if(reduxValue.alignment === 'question'){
    setBoardData(getSample.filter(data => data.b_category === '질문' ))
    setPage(0)
    console.log('질문')
  } else if (reduxValue.alignment === 'boast'){
    setBoardData(getSample.filter(data => data.b_category === '자랑하기' ))
    setPage(0)
    console.log('자랑')
  } else if (reduxValue.alignment === 'share'){
    setBoardData(getSample.filter(data => data.b_category === '무료나눔' ))
    setPage(0)
    console.log('무료나눔')
  } else {
    setBoardData(sampleData.data)
  }
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
        <TableBody>
          {boardData.sort((a,b) => b.b_no-a.b_no).slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => (
            <StyledTableRow
            key={row.b_no}
            style={{height: 48 }}
            sx={{
              cursor: 'pointer'
            }}
            hover
            onClick={()=> navigate('/BoardDetail/'+row.b_no ,{state:{
              boardNumber : row.b_no,
              boardTitle : row.b_title,
              boradContent : row.b_content,
              boardDate : row.b_date,
              boardView : row.b_view,
              boardCategory : row.b_category,
              boardWriter : row.b_writer
            }})}
            >
              <StyledTableCell align="center" component="th" scope="row">
                {row.b_no}
              </StyledTableCell>
              <StyledTableCell align="center">{row.b_category}</StyledTableCell>
              <StyledTableCell align="center">{row.b_title}</StyledTableCell>
              <StyledTableCell align="center">{row.b_date}</StyledTableCell>
              <StyledTableCell align="center">{row.b_view}</StyledTableCell>
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
          component={Link}
          to={`/BoardList${page === 1 ? '' : `?page=${CustomizedTables.page}`}`}
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
