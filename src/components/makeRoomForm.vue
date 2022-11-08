<template>
<div>
  <form v-on:submit.prevent="makeRoomForm">
    <div>
      <label for="name"></label>
      <input id="name" type="text" v-model="name">
    </div>
    <button type="submit">생성하기</button>
  </form>
</div>
</template>

<script>
export default {
  data: function() {
    return {
      username: '',
      password: '',
    }
  },
  methods: {
    makeRoomForm: function() {
      this.axios.post("/chat/room")
      .then(function(response) {
        console.log(response);
      })
      .catch(function(error) {
        console.log(error);
      })
    }
  }
}
</script>

<style scoped>

</style>