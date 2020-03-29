import babelpolyfill from 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
//import './assets/theme/theme-green/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
//import NProgress from 'nprogress'
//import 'nprogress/nprogress.css'
import routes from './routes'
// import Mock from './mock'
// Mock.bootstrap();
import 'font-awesome/css/font-awesome.min.css'

// 引入axios
import axios from 'axios'
//配置axios的全局基本路径
axios.defaults.baseURL='http://localhost:8080'
//全局属性配置，在任意组件内可以使用this.$http获取axios对象
Vue.prototype.$http = axios

Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(Vuex);

//NProgress.configure({ showSpinner: false });

const router = new VueRouter({
  routes
})

/*
// 每次路由之前都会执行,每次请求都要经过路由
router.beforeEach((to, from, next) => {
  //NProgress.start();
  if (to.path == '/login') {
    // 移除原来的session
    sessionStorage.removeItem('user');
  }
  // 从session中获取用户
  let user = JSON.parse(sessionStorage.getItem('user'));
  if (!user && to.path != '/login') {
    next({ path: '/login' })
  } else {
    next()
  }
})

 */
//router.afterEach(transition => {
//NProgress.done();
//});

new Vue({
  //el: '#app',
  //template: '<App/>',
  router,
  store,
  //components: { App }
  render: h => h(App)  // 在index.html id 为app的div标签下使用<APP/> 和//template: '<App/>'效果一样
}).$mount('#app');   //和el:"#app" 效果一样,都是挂载到index.html id为app的标签上

