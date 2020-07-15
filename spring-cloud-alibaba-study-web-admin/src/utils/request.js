import axios from 'axios'

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

// 创建axios实例
const service = axios.create({
    // 公共部分
    baseURL: process.env.VUE_APP_SERVICE_ADMIN_URL,
    // 超时
    timeout: 10000
})

export default service