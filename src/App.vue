<template>
  <div id = "app">
    <div id="nav">
      <router-link to="/agora">AgoraView</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
}
</script>

<style>
</style>
