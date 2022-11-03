<template>
  <div>
    <form v-on:submit.prevent="RegisterForm">
      <div>
        <label for="name"></label>
      </div>
    </form>
  </div>

</template>

<script>
export default {
  data: function () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    RegisterForm: function() {
      this.axios.post("")
    }
  }
}
</script>

<style scoped>

</style>