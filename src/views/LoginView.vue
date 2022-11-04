<template>
  <div>
    <div>
      <nav>로그인</nav>
    </div>
    <div>
      <LoginForm/>
    </div>
  </div>
</template>

<script>
import LoginForm from "@/components/LoginForm";

export default {
  name: "LoginView",
  components: {LoginForm}
}
</script>

<style scoped>

</style>