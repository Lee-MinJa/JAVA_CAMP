import React, { useState } from 'react'
import { 
        Autocomplete,
        TextField,
        } from '@mui/material'
import { useRecoilState } from 'recoil'
import { domainSelectState, domainDirectState } from '../board/RecoilAtom'

function DomainSelect() {

  const [value, setValue] = useRecoilState(domainSelectState)
  const [inputValue, setInputValue] = useRecoilState(domainDirectState);
  const options = ['daum.net', 'naver.com', 'kakao.net', 'gmail.com']


  return (
    <div>
      <Autocomplete
        freeSolo
        value={value}
        onChange={(event, newValue) => {
          setValue('')
          setValue(newValue);
        }}
        inputValue={inputValue}
        onInputChange={(event, newInputValue) => {
          setInputValue('');
          setInputValue(newInputValue);
        }}
        id="controllable-states-demo"
        options={options}
        sx={{ width: 300 }}
        renderInput={(params) => <TextField {...params} label="도메인(직접입력가능)" />}
      />
    </div>
  )
}

export default DomainSelect;