<template>
  <div>
    <b-form v-on:submit.prevent="LoginForm">
      <b-form-group
          id="userId"
          label="ID:"
          label-for="userId"
      >
        <b-form-input
            id="userId"
            type="text"
            v-model="userId"
            placeholder="Enter ID"
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="password"
          label="password:"
          label-for="password"
      >
        <b-form-input
            id="password"
            type="text"
            v-model="password"
            placeholder="Enter password"
        ></b-form-input>
      </b-form-group>
      <div class="row">
        <div id="login-button" class="col-3">
          <b-button type="submit" variant="primary">로그인</b-button>
        </div>
        <div id="register-button" class="col-3">
          <router-link to="/register">
            <b-button variant="outline-primary">
              회원가입
            </b-button>
          </router-link>
          <router-view/>
        </div>
      </div>
    </b-form>
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