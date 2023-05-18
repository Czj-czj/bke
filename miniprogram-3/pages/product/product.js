// pages/product/product.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    bookList: [{
        book_ID: 1,
        bookName: '默认书籍1',
        author: '默认作者1',
        provider: '默认提供者1',
        price: '￥0.00',
        coverImg: '../../images/defaultUser.png'
      },
      {
        book_ID: 2,
        bookName: '默认书籍2',
        author: '默认作者2',
        provider: '默认提供者2',
        price: '￥0.00',
        coverImg: '../../images/defaultUser.png'
      }
    ],
    lastLoadTime: 0,
    isLoading: false
  },

  // 在小程序页面中定义chooseImage事件
  chooseImage: function () {
    let that = this;
    wx.chooseImage({
      count: 1, // 最多可选1张图片
      sizeType: ['compressed'], // 压缩图片
      sourceType: ['album', 'camera'], // 图片来源，可以相册、相机选择
      success: function (res) {
        // 上传图片到微信服务器
        wx.uploadFile({
          url: 'https://api.weixin.qq.com/cgi-bin/media/upload?access_token=' + that.globalData.accessToken + '&type=image',
          filePath: res.tempFilePaths[0], // 图片路径
          name: 'media', // 媒体文件的key，固定值为'media'
          success: function (res) {
            // 解析服务器返回的数据，获取图片URL
            let data = JSON.parse(res.data);
            let imageUrl = data.url; // 获取图片URL
            console.log('上传成功，图片URL为：', imageUrl);
          },
          fail: function (res) {
            console.log('上传图片失败：', res.errMsg);
          }
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    wx.showLoading({
      title: '正在加载...'
    })
    wx.request({
      url: app.globalData.url + '/book/getBook', // 后端接口地址
      data: {
        start: 0, // 当前列表中最后一本书的编号加1作为起始数量
        count: 10 // 数量为20
      },
      success: res => {
        if (res.statusCode === 200) {
          if (res.data.length == 0) {
            wx.showToast({
              title: '没有了哦',
              icon: 'error'
            })
          }
          this.setData({
            bookList: res.data // 将新的书籍信息添加到已有书籍列表中
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
  },
  getBookList: function () {
    wx.showLoading({
      title: '正在加载...'
    })
    wx.request({
      url: app.globalData.url + '/book/getBook', // 后端接口地址
      data: {
        start: this.data.bookList[this.data.bookList.length - 1].book_ID, // 当前列表中最后一本书的编号加1作为起始数量
        count: 20 // 数量为20
      },
      success: res => {
        if (res.statusCode === 200) {
          if (res.data.length == 0) {
            wx.showToast({
              title: '没有了哦',
              icon: 'error'
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
  },
  buy: function (event) {
    const book = event.currentTarget.dataset.book;
    wx.navigateTo({
      url: '../buy/buy?book=' + JSON.stringify(book),
    })
  },
  upBook() {
    wx.navigateTo({
      url: 'updateBook'
    })
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

  }
})