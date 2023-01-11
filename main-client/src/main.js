import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios"
import BootstrapVue from "bootstrap-vue";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false
Vue.prototype.axios = axios;
axios.defaults.baseURL = "http://localhost:8000"
Vue.use(BootstrapVue)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

