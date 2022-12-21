<template>
  <b-container>
    <div id="login-button">
      <router-link to="/login">
        <b-button variant="primary">
          로그인
        </b-button>
      </router-link>
      <router-view/>
    </div>
    <div id="register-button">
      <router-link to="/register">
        <b-button variant="outline-primary">
          회원가입
        </b-button>
      </router-link>
      <router-view/>
    </div>
  </b-container>
</template>

<script>
export default {
  name: "mainView"
}
</script>

<style scoped>

</style>