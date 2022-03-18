import { 
    Container,
    Center,
    Stack,
    Box,
    Radio,
    RadioGroup,
    FormControl,
    FormControlLabel,
    FormHelperText,
    FormLabel,
    Button,
    TextField
  } from '@mui/material';
import React, { useState } from 'react'
import BoardEditor from '../../components/board/boardComponent/BoardEditor';

const BoardInsert = () => {

  const [categoryValue, setCategoryValue] = useState('');
  const [error, setError] = useState(false);
  const [helperText, setHelperText] = useState('');

  const handleRadioChange = (event) => {
    setCategoryValue(event.target.value)
    setError(false);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (categoryValue === '') {
      setHelperText('카테고리를 선택해주세요');
      setError(true);
    } else {
      setError(false);
    }
  };


return (
  <>
  <Box
      className='boardHeader'
      sx={{
        height: '7vh',
      }}>
  </Box>
  <Stack
  alignItems={'center'}
  justifyContent={'center'}
  >
  <h2>글쓰기</h2>
  <Box>
    <form onSubmit={handleSubmit}>
      <FormControl sx={{ m: 3 }} error={error} variant="standard">
        <FormLabel
        sx={{color : 'black'}}>카테고리</FormLabel>
        <RadioGroup
          row
          value={categoryValue}
          onChange={handleRadioChange}
        >
          <FormControlLabel
          value="질문" 
          control={<Radio />} 
          label="질문하기"/>
          <FormControlLabel 
          value="자랑" 
          control={<Radio />} 
          label="자랑하기"/>
          <FormControlLabel 
          value="무료나눔" 
          control={<Radio />} 
          label="무료나눔" />
        </RadioGroup>
        <FormHelperText>{helperText}</FormHelperText>
        <Box
        marginBottom={'20px'}
        >
        <TextField
          sx={{
            width : '400px',
            color : 'none'
          }}
          label="제목"
          type="search"
          variant="standard"
        />
        </Box>
        <Box>
        <BoardEditor />
        </Box>
        <Box
        display={'flex'}>
        <Button
        sx={{
          mt: 1,
          mr: 1,
          width : '120px'
          }} 
        type="submit" 
        variant="outlined">
          등록
        </Button>
        <Button
        sx={{
          mt: 1,
          mr: 1,
          width : '120px',
          }} 
        color={'secondary'}
        variant="outlined">
          돌아가기
        </Button>
        </Box>
      </FormControl>
    </form>
  </Box>
  </Stack>
  </>

)
}
export default BoardInsert;