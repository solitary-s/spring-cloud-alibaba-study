import request from '@/utils/request'

export function getUserInfo() {
    return request({
        url: '/login',
        method: 'get'
    })
}

export function hello(name) {
    return request({
        url: '/hello/' + name,
        method: 'get'
    })
}