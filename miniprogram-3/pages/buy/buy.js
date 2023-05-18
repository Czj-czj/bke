// pages/home/buy/buy.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    book: {
      title: "书名",
      author: "作者",
      publisher: "出版社",
      publishDate: "出版日期",
      description: "简介",
    },
    isEditable: false // 是否可编辑标志位
  },
  toggleEditable() {
    const isEditable = this.data.book.isEditable;
    this.setData({
      "book.isEditable": !isEditable
    });
  },
  updateBookInfo() {
    // 提交表单给后台进行数据修改
    const book = this.data.book;
    // 执行数据修改的操作...
    // 操作成功后进行提示或其他逻辑处理...
  },
  editBook(){
    this.setData({
      isEditable:true
    })
  },
  handleInputChange(e) {
    const field = e.currentTarget.dataset.field;
    const value = e.detail.value;
    this.setData({
      [`book.${field}`]: value
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const book = JSON.parse(options.book);
    this.setData({
      book,
    });
    if(this.data.book.publishDate==null){
      this.data.book.publishDate="2001-08-27"
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

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})