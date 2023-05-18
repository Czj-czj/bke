// index.js
const app=getApp();
Page({
  data: {
    username: '',
    password: ''
  },
  formSubmit: function(e) {
    const that=this;
    var username = e.detail.value.username;
    var password = e.detail.value.password;
    wx.request({
      url: app.globalData.url+'/user',
      method: 'GET',
      data: {
        openid:username,
        password:password
      },
      success: function(res) {
        if (res.data.user_ID!=null) {
          wx.showToast({
            title: '登录成功',
            icon: 'none'   
        }),
        that.setData({
          hasUserInfo: true,
          userInfo: res.data
          });
          app.updateUserInfo(res.data);
          wx.switchTab({
            url: '../me/me'
          })
        } else {
          wx.showToast({
            title: '登录失败',
            icon: 'none'
          })
        }
        }
  })
  },
  regist:function(e){
    wx.navigateTo({
      url: '../zhuce/zhuce'
    })
  },
  getPhoneNumber (e) {
    console.log(e.detail.code)
  }
})

