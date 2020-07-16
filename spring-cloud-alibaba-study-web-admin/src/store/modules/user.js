import { getUserInfo } from "@/api/login";

const user = {
    state: {
        token: "",
        user: {}
    },

    mutations: {
        setToken(state, token) {
            state.token = token
        },
        setUser(state, token) {
            state.user = user
        }
    },

    actions: {
        login({ commit }, token) {
            commit('setToken', token);
            window.localStorage.setItem("well-token", token);
        },

        getUser({ commit }) {
            return new Promise((resolve, reject) => {
                getUserInfo().then(res => {
                    if (res.data) {
                        commit("setUser", res.data)
                    }
                    resolve(res.data)
                }).catch(error => {
                    reject(error)
                })
            })
        }
    }
}

export default user