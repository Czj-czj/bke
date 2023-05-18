// pages/product/updateBook.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: app.globalData.userInfo,
    date: '2022-04-18',
    envId: 'book-exchange-1gxf0d3r1913cd9c',
    haveGetImgSrc: false,
    imgSrc: ''
  },
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  onSubmit: function (e) {
    if (this.data.user == null) {
      wx.navigateTo({
        url: '../index/index',
      })
      return;
    }
    var bookname = e.detail.value.bookname;
    var author = e.detail.value.author;
    var publisher = e.detail.value.publisher;
    var publishdate = this.data.date;
    var description = e.detail.value.description;
    var price = e.detail.value.price;
    const book = {
      user_ID: this.data.user.user_ID,
      title: bookname,
      author: author,
      publisher: publisher,
      publishDate: publishdate,
      description: description,
      price: price,
      image: this.data.imgSrc
    }
    console.log(book);
    // const bookstr = JSON.stringify(book)
    wx.request({
      url: app.globalData.url + '/book/addBook',
      method: 'GET',
      data: {
        user_ID: this.data.user.user_ID,
        title: bookname,
        author: author,
        publisher: publisher,
        publishDate: publishdate,
        description: description,
        price: price,
        image: this.data.imgSrc
      },
      success: function (res) {
        wx.showToast({
          title: '添加成功',
          icon: 'success'
        })
        // wx.switchTab({
        //   url: '../product/product',
        // })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.setData({
      user: app.globalData.userInfo
    });
    if (this.data.user == null) {
      wx.showToast({
        title: '请先登录',
        icon: "error"
      })
      wx.navigateTo({
        url: '../index/index',
      });

    }
  },
  uploadImg() {
    wx.showLoading({
      title: '',
    });
    // 让用户选择一张图片
    wx.chooseMedia({
      count: 1,
      success: chooseResult => {
        // 将图片上传至云存储空间
        //const cloudPath = `/${fileName}`;
        console.log(chooseResult)
        wx.cloud.uploadFile({
          // 指定上传到的云路径
          cloudPath: chooseResult.tempFiles[0].tempFilePath.slice(-14),
          // 指定要上传的文件的小程序临时文件路径
          filePath: chooseResult.tempFiles[0].tempFilePath,
          config: {
            env: this.data.envId
          }
        }).then(res => {
          console.log('上传成功', res);
          this.setData({
            haveGetImgSrc: true,
            imgSrc: res.fileID
          });
          wx.hideLoading();
        }).catch((e) => {
          console.log(e);
          wx.hideLoading();
        });
      },
    });
  },
  clearImgSrc() {
    this.setData({
      haveGetImgSrc: false,
      imgSrc: ''
    });
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

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})