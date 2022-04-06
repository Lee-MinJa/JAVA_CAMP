// const nodemailer = require('nodemailer');
// import { pass } from './Config'

// router.post('/sendEmail', async function (req, res) {

//let user_email = req.body.email;
//     console.log(user_email);

//     // 메일발송 함수

//let transporter = nodemailer.createTransport({
//   service: 'gmail'              //사용하고자 하는 서비스
//   , prot: 587
//   , host: 'smtp.gmlail.com'
//   , secure: false
//   , requireTLS: true
//   , auth: {
//     user: 'testcamp2022@gmail.com'           //gmail주소입력
//   , pass: pass                //gmail패스워드 입력
//         }
//     });

//     let info = await transporter.sendMail({   
//         from: 'testcamp2022@gmail.com',             //보내는 주소 입력
//         to: 'testcamp2022@gmail.com',                    //위에서 선언해준 받는사람 이메일
//         subject: '테스트',                  //메일 제목
//         text: '테스트',                       //내용
//       });


// })