// pages/me/me.js
const app = getApp();
Page({
  data: {
    appp: app,
    userInfo: app.globalData.userInfo,
    orders: [],
    hasUserInfo: false,
    logintext: ""
  },
  toIndex(e) {
    wx.navigateTo({
      url: '../index/index'
    })

  },
  showDetail() {
    wx.navigateTo({
      url: 'userDetail'
    })
  },
  refresh() {
    this.setData({
      userInfo: app.globalData.userInfo
    });
    this.data.hasUserInfo = !(this.data.userInfo == null);
    let logintext = this.data.hasUserInfo ? "切换用户" : "登录";
    this.setData({
      logintext: logintext
    });
  },

  onLoad: function () {
    // 调用后台接口获取用户信息和订单列表
    // 将用户信息和订单列表绑定到对应的数据变量上
    if (this.data.userInfo == null) {
      this.setData({
        userInfo: {
          avatarUrl: '../../images/defaultUser.png',
          nikeName: 'default User',
          email: '00000000000'
        },
        orders: [{
          id: 1,
          name: '红楼梦',
          price: 98.8
        },
        {
          id: 2,
          name: '三体',
          price: 200
        },
        {
          id: 3,
          name: '追风筝的人',
          price: 300
        },
        ]
      })
    }
    this.setData({
      logintext: this.data.hasUserInfo ? "切换用户" : "登录",
      orders: [{
        id: 1,
        name: '红楼梦',
        price: 98.8
      },
      {
        id: 2,
        name: '三体',
        price: 200
      },
      {
        id: 3,
        name: '追风筝的人',
        price: 300
      },
      ]
    })
  },
  toGetBooks(){
    wx.navigateTo({
      url: 'books',
    })
  },
  onShow: function () {
    this.refresh();
    if (this.data.userInfo == null) {
      this.setData({
        userInfo: {
          avatarUrl: '../../images/defaultUser.png',
          nikeName: 'default User',
          email: '00000000000'
        },
        logintext: this.data.hasUserInfo ? "切换用户" : "登录"
      })
    }
  },
  toGetUser(){
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
          app.globalData.userInfo=res.userInfo;
          this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
          })
      }
      })
  }
})