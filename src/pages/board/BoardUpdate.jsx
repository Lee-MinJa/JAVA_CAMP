import { Button } from '@mui/material';
import { useLocation } from 'react-router-dom';
import React from 'react'

function BoardUpdate() {

  const location = useLocation();
  const {
    boardNumber,
    boardTitle,
    boradContent,
    boardDate,
    boardView,
    boardCategory,
    boardWriter
  } = location.state

  return (
    <>
    updatePage
    </>
  )
}

export default BoardUpdate;
