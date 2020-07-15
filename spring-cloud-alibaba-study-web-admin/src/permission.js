import router from "./router";


router.beforeEach((to, from, next) => {
    let token = window.localStorage.getItem("well-token")

    // debugger
    if (to.name == "Callback") {
        next()
    } else if (token) {
        console.log(token)
    } else {
        window.location.href = process.env.VUE_APP_SSO_URL + '?url=' + process.env.VUE_APP_WEB_ADMIN_URL
    }
})