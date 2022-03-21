import * as React from 'react';
import { Button } from 'react-native';
import { useNavigation } from '@react-navigation/native';

function PromotionWriting() {
  
  const navigation = useNavigation();
  const boardClick = () => {
    navigation('/PromotionWriting')
  }

  return (

    <div>
      <h1>Promotion Page</h1>
        <Button
          variant='contained'
          color='primary'
          onClick={boardClick}
        >글쓰기
        </Button>
    </div>
  )
}

export default PromotionWriting;