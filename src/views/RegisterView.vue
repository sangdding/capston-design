<template>
  <div>
    <form v-on:submit.prevent="RegisterForm">
      <div>
        <label for="userId"></label>
        <input id="userId" type="text" v-model="userId">
      </div>
      <div>
        <label for="email"></label>
        <input id="email" type="email" v-model="email">
      </div>
      <div>
        <label for="password"></label>
        <input id="password" type="text" v-model="password">
      </div>
      <div>
        <label for="nickname"></label>
        <input id="nickname" type="text" v-model="nickname">
      </div>
      <button type="submit">회원가입</button>
    </form>
  </div>

</template>

<script>
export default {
  data: function () {
    return {
      userId: '',
      email: '',
      password: '',
      nickname: ''
    }
  },
  methods: {
    RegisterForm: function () {
      this.axios.post("/register")
          .then(function (response){
            console.log(response);
          })
          .then(function (error){
            console.log(error);
          })
    }
  }
}
</script>

<style scoped>

</style>