<template>
  <div>
    <form v-on:submit.prevent="LoginForm">
      <div>
        <label for="userId"></label>
        <input id="userId" type="text" v-model="userId">
      </div>
      <div>
        <label for="password"></label>
        <input id="password" type="text" v-model="password">
      </div>
      <button type="submit">로그인</button>
    </form>
  </div>
</template>

<script>
export default {
  data: function () {
    return {
      userId: '',
      password: '',
    }
  },
  methods: {
    LoginForm: function () {
      this.axios.post("/login")
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          })
    }
  }
}
</script>

<style scoped>

</style>