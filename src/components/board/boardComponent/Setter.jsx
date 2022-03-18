import React, { useEffect, useState } from 'react'
import axios from 'axios'

function Setter(props) {

  const boardNum = props.id
  const [viewCount, setViewCount] = useState({
    view : 0,
  })
  const [freeContent, setfreeContent] = useState([{
    free_num : 0,
    mem_num : 0,
    free_subject : '',
    free_title : '',
    free_contetn : '',
    free_views : 0,
    free_regdate : ''
  }
  ])

  useEffect(() => {
    axios.get('/api/freeGet').then((res) => {
      console.log(res)
      setfreeContent(res.data[boardNum])
      setViewCount({view : Number(res.data[boardNum].free_views)})
    })
    hitCount()
    console.log(boardNum)
    console.log(freeContent)
  }, [])

  const hitCount = () => {
    const url = '/api/freeView/' + boardNum
    const data = {
      countView : viewCount.view + 1,
      id : boardNum
    }
    axios.put(url, data).then((res) => {
      console.log("resData : " , res);
    })
  }

  return (
    <div></div>
  )
}

export default Setter;
