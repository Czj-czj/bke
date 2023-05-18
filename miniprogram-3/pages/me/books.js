// pages/me/books.js
const app=getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:app.globalData.userInfo
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      user:app.globalData.userInfo
    });
    if(this.data.user==null){
      wx.navigateTo({
        url: '../index/index',
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {
    this.getBookList()
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },
  getBookList: function () {
    wx.showLoading({
      title: '正在加载...'
    })
    wx.request({
  
      url: app.globalData.url+'/book/getBookbyUID', // 后端接口地址
      data: {
        start: this.data.bookList[this.data.bookList.length - 1].book_ID, // 当前列表中最后一本书的编号加1作为起始数量
        count: 20, // 数量为20,
        uid:this.data.userInfo.user_ID
      },
      success: res => {
        if (res.statusCode === 200) {
          if(res.data.length==0){
            wx.showToast({
              title: '没有了哦',
              icon:'error'
            })
          }
          this.setData({
            bookList: this.data.bookList.concat(res.data) // 将新的书籍信息添加到已有书籍列表中
          })
        } else {
          wx.showToast({
            title: '加载失败，请重试',
            icon: 'none'
          })
        }
      },
      fail: err => {
        wx.showToast({
          title: '加载失败，请重试',
          icon: 'none'
        })
        console.error('[后端接口] [获取数据] 失败：', err)
      },
      complete: () => {
        wx.hideLoading()
      }
    })
  }
})