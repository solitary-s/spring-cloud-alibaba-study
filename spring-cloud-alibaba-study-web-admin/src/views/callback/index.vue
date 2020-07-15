<template>
    <div>loading</div>
</template>

<script>
    import qs from "qs";
    import store from "@/store";

    export default {
        name: "index",
        beforeRouteEnter(to, from, next) {
            const {token, model} = qs.parse(window.location.href.split('?')[1]);
            store.dispatch("login", token)
            console.log(to)
            next()
        },
        created() {
        },
        mounted() {
            this.$router.push("/")
        }
    }
</script>

<style scoped>

</style>