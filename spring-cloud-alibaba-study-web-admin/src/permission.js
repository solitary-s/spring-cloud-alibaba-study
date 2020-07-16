import router from "./router";
import store from "./store";


router.beforeEach((to, from, next) => {
    let token = window.localStorage.getItem("well-token")

    if (to.name == "Callback") {
        next()
    } else if (token) {
        store.dispatch("login", token)
        // 获取数据
        if (store.getters.user) {
            store.dispatch("getUser").then(res => {
                if (res) {
                    next()
                } else {
                    window.location.href = process.env.VUE_APP_SSO_URL + '?url=' + process.env.VUE_APP_WEB_ADMIN_URL
                }
            })
        } else {
            next()
        }
    } else {
        window.location.href = process.env.VUE_APP_SSO_URL + '?url=' + process.env.VUE_APP_WEB_ADMIN_URL
    }
})