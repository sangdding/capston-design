<template>
  <div>
    <header>
      아고라
    </header>
    <nav>
      <main-nav/>
    </nav>
    <b-container>
      <div class="row">
        <div class="col-2">
          광고
        </div>
        <div class="col-7">
          게시판
        </div>
        <div class="col-3">
          <login-form/>
        </div>
      </div>
    </b-container>
  </div>
</template>

<script>
import loginForm from './LoginView';
import mainNav from '/src/components/MainNavComponent'

export default {
  name: "mainView",
  components: {
    loginForm,
    mainNav
  }
}
</script>

<style scoped>

</style>