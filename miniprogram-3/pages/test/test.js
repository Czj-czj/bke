// // 在需要获取用户手机号的页面引入解密工具
// const WXBizDataCrypt = require('../../utils/WXBizDataCrypt')
// Page({
//   data: {
//     // 存储用户手机号
//     phoneNumber: ''
//   },
//   getPhoneNumber: function (e) {
//     // 获取用户手机号
//     wx.login({
//       success: res => {
//         // 发送 res.code 到后台换取 openId, sessionKey, unionId
//         wx.request({
//           url: 'http://192.168.1.111.com/decodeUserInfo',
//           data: {
//             code: res.code,
//             encryptedData: e.detail.encryptedData,
//             iv: e.detail.iv
//           },
//           success: res => {
//             // 解密用户信息
//             const pc = new WXBizDataCrypt('your appid', res.data.session_key)
//             const result = pc.decryptData(e.detail.encryptedData, e.detail.iv)

//             // 获取用户手机号并存储
//             const phoneNumber = result.phoneNumber
//             this.setData({
//               phoneNumber: phoneNumber
//             })

//             // 在此处执行其他操作，如将手机号发送到后端存储等
//           },
//           fail: err => {
//             console.error(err)
//           }
//         })
//       },
//       fail: err => {
//         console.error(err)
//       }
//     })
//   }
// })
