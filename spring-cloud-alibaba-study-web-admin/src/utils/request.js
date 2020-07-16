import axios from 'axios'
import store from "../store";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

// 创建axios实例
const service = axios.create({
    // 公共部分
    baseURL: process.env.VUE_APP_SERVICE_ADMIN_URL,
    // 超时
    timeout: 10000
})

// request拦截器
service.interceptors.request.use(
    config => {
        let token = store.getters.token
        if (token) {
            config.headers[process.env.VUE_APP_SSO_HEADER_TOKEN] = token
        }
        return config
    },
    error => {
        console.log(error)
        Promise.reject(error)
    }
)

export default service