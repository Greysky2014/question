import Vue from "vue";
import App from "./App.vue";
import axios from "axios";
import router from "./router";
import store from "./store";
import jquery from "jquery";
// element-ui
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
Vue.use(ElementUI);
Vue.use(jquery);
Vue.config.productionTip = false;
//将axios挂载在Vue扩展上
Vue.prototype.$http = axios;
//在其他地方使用只需使用 this.$http来代替axios;
//配置baseUrl
axios.defaults.baseURL = "/api";

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
