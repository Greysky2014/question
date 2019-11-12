module.exports = {
  configureWebpack: {
    devServer: {
      proxy: {
        "/api": {
          target: "http://192.168.0.131:8888/",
          changeOrigin: true, //是否跨域
          pathRewrite: {
            "^/api": "" //规定请求地址以什么作为开头
          }
        }
      }
    }
  }
};
