<template>
  <nav>
    <ul>
      <li>
        <router-link to="/login">로그인</router-link>
        <router-view/>
      </li>
      <li>
        <router-link to="/register">회원가입</router-link>
        <router-view/>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "mainView"
}
</script>

<style scoped>

</style>