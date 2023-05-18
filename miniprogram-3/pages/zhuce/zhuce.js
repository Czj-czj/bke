// pages/zhuce/zhuce.js
// register.js
const app=getApp();
Page({
  data: {
    username: '',
    password: '',
    email: '',
    envId:'book-exchange-1gxf0d3r1913cd9c'
  },

  onSubmit: function (e) {
    var username = e.detail.value.username;
    var password1 = e.detail.value.password1;
    var password2 = e.detail.value.password2
    var email = e.detail.value.email;
    if (password1 === password2) {
      wx.request({
        url: app.globalData.url+'/updateUser',
        method: 'GET',
        data: {
          username: username,
          password: password1,
          email: email
        },
        success: function (res) {
          wx.showToast({
              title: '注册成功',
              icon: 'success'
            }),
            wx.navigateTo({
              url: '../index/index'
            })
        }
      })
    } else {
      wx.showToast({
        title: '两次密码输入不一致，请检查您的输入',
      })
    }
  },
  uploadImg() {
    wx.showLoading({
      title: '',
    });
    // 让用户选择一张图片
    wx.chooseImage({
      count: 1,
      success: chooseResult => {
        // 将图片上传至云存储空间
        wx.cloud.uploadFile({
          // 指定上传到的云路径
          cloudPath: 'my-photo.png',
          // 指定要上传的文件的小程序临时文件路径
          filePath: chooseResult.tempFilePaths[0],
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
  }

})