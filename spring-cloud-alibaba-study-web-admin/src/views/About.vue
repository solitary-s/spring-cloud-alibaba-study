<template>
  <div class="about">
    <h1>This is an about page</h1>
    <el-button @click="hello">click</el-button>
    <div>{{ say }}</div>
  </div>
</template>

<script>
  import { hello } from '@/api/login'

  export default {
    name: "index",
    data() {
      return {
        say: ""
      }
    },
    methods: {
      hello() {
        hello("vue").then(res => {
          this.say = res.data;
        })
      }
    }
  }
</script>

<style scoped>

</style>