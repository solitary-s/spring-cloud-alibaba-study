
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
        }
    }
}

export default user