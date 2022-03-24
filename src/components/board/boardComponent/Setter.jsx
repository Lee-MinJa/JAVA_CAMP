import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { memberGet } from '../MappingDB'

function Setter(props) {

  const boardNum = props.id
  const boardWriter = props.writer
  const [viewCount, setViewCount] = useState({
    view : 0,
  })
  const [writer, setWriter] = useState('')

  // const [freeContent, setfreeContent] = useState([{
  //   free_num : 0,
  //   mem_num : 0,
  //   free_subject : '',
  //   free_title : '',
  //   free_contetn : '',
  //   free_views : 0,
  //   free_regdate : ''
  // }
  // ])

  //axios.get(`http://localhost:8000/api/${memberGet}/${boardWriter}`).then((res) => {
    //console.log('writer : ' ,res)
    // setWriter(res.data[mem_nick])
  //})

  useEffect(() => {
    nickGet()
    // hitCount()
    console.log('writer : ', writer)
  })

  const nickGet = () => {
    const url = 'http://localhost:8000/api/' + memberGet + '/' + boardWriter
    axios.get(url).then((res) => {
      console.log('resData : ', res)
    })
  }
  // setViewCount({view : Number(res.data[boardNum].free_views)})

  // const hitCount = () => {
  //   const url = '/api/freeView/' + boardNum
  //   const data = {
  //     countView : viewCount.view + 1,
  //     id : boardNum
  //   }
  //   axios.put(url, data).then((res) => {
  //     console.log("resData : " , res);
  //   })
  // }

  return (
    <div></div>
  )
}

export default Setter;
