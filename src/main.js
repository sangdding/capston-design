import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import axios from "axios"

createApp(App).use(router).mount('#app')
axios.defaults.baseURL = "http://localhost:8080"
const app = createApp(App);
app.config.globalProperties.axios = axios;
app.mount('#app')
