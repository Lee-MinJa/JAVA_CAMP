import React from 'react'
import Button from 'react-bootstrap/Button'
import Dropdown from 'react-bootstrap/Dropdown'
import Card from 'react-bootstrap/Card'


function PromotionPage() {
  return (
<div><h1>Hi. Camping</h1>
  홍보
<Button aria-label="Basic example">
  <Button variant="secondary">전체</Button>
  <Button variant="secondary">서울</Button>
  <Button variant="secondary">경기</Button>
  <Button variant="secondary">강원</Button>
  <Button variant="secondary">충청</Button>
  <Button variant="secondary">전라</Button>
  <Button variant="secondary">경상</Button>
  <Button variant="secondary">제주</Button>
</Button>

{/*--------------------- 정렬박스 ---------------------*/}
<Dropdown>
  <Dropdown.Toggle variant="success" id="dropdown-basic">
    정렬
  </Dropdown.Toggle>

  <Dropdown.Menu>
    <Dropdown.Item href="#/action-1">이름순</Dropdown.Item>
    <Dropdown.Item href="#/action-2">리뷰순</Dropdown.Item>
    <Dropdown.Item href="#/action-3">좋아요순</Dropdown.Item>
  </Dropdown.Menu>
</Dropdown>

{/*--------------------- card1 ---------------------*/}
<Card style={{ width: '18rem' }}>
<Card.Img variant="top" src="https://i.ibb.co/BPY95fs/3.jpg"
  border="0" width="200" height="200" />
  <Card.Body>
  <Button variant="primary">강원</Button>
  <Button variant="primary">#야경맛집</Button>
  <Button variant="primary">#계곡</Button>
    <Card.Title><h1>하늘빛 계곡</h1></Card.Title>
    <Card.Text>
      이용 후기 평점 ★ ★ ★ ★ ☆ <br/>
      맑은 물 줄기를 따라 별빛이 반짝이는 야경 맛집으로 초대합니다.
    </Card.Text>
  </Card.Body>
</Card>

{/*--------------------- card2 ---------------------*/}
<Card style={{ width: '18rem' }}>
  <Card.Img variant="top" src="https://i.ibb.co/KX1sYH9/Img.png"
    border="0" width="200" height="200"  />
  <Card.Body>
  <Button variant="primary">서울</Button>
  <Button variant="primary">#휴양림</Button>
  <Button variant="primary">#캠핑카</Button>
    <Card.Title><h1>남산 아래 쉼터</h1></Card.Title>
    <Card.Text>
      이용 후기 평점 ★ ★ ★ ☆ ☆
      서울에서 즐길 수 있는 자연의 숨결 ! 남산 아래 쉼터에서 도심 속의 여유를 찾아보세요.
    </Card.Text>
  </Card.Body>
</Card>

</div>
  )
};

window.addEventListener('scroll', () => { 
  console.log(window.scrollX, window.scrollY);
});
window.scrollTo({ top: 0, left: 0, behavior: 'smooth' });

export default PromotionPage;