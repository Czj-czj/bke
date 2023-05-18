// pages/index/index.js
const MAX_LIMIT = 20;
// 定义Book类
// class Book {
//   constructor(bookId, author, provider, price) {
//     this.bookId = bookId;
//     this.author = author;
//     this.provider = provider;
//     this.price = price;
//   }
// }

// // 初始化几个Book对象
// const book1 = new Book("JavaScript高级程序设计", "Nicholas C. Zakas", "A出版社", 59.9);
// const book2 = new Book("算法导论", "Thomas H. Cormen", "B出版社", 78.0);
// const book3 = new Book("设计模式", "Erich Gamma", "C出版社", 42.0);

// 将Book对象存入数组中
//const bookList = [book1, book2, book3];
const app=getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    url:app.globalData.url,
    bookList: [
      {
        bookId: 1,
        bookName: '默认书籍1',
        author: '默认作者1',
        provider: '默认提供者1',
        price: '￥0.00',
        coverImg: '../../images/defaultUser.png'
      },
      {
        bookId: 2,
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

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    wx.request({
  
      url: app.globalData.url+'/book/getBook', // 后端接口地址
      data: {
        start: 0, 
        count: 5
      },
      success: res => {
        if (res.statusCode === 200) {
          if(res.data.length==0){
            wx.showToast({
              title: '没有书籍',
              icon:'error'
            })
          }
          this.setData({
            bookList: res.data
          })
        } 
        else {
          wx.showToast({
            title: '加载失败，请重试',
            icon: 'none'
          })
        }
      }
    })
  },
  

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    this.setData({
      bookList: [],
      lastLoadTime: 0
    })
    this.getBookList()
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    this.getBookList()
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
// 获取图书列表
getBookList: function () {
  wx.showLoading({
    title: '正在加载...'
  })
  wx.request({

    url: app.globalData.url+'/book/getBook', // 后端接口地址
    data: {
      start: this.data.bookList[this.data.bookList.length - 1].book_ID, // 当前列表中最后一本书的编号加1作为起始数量
      count: 20 // 数量为20
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
},
  buy:function(event){
    const book = event.currentTarget.dataset.book;
    wx.navigateTo({
      url: '../buy/buy?book=' + JSON.stringify(book),
    })
  }
})
