<template>
  <h5>채팅방 생성</h5>
  <form>
    <div>
      <label for="name">이름</label>
      <input id="name" type="text" v-model="name">
    </div>
    <div>
      <label for="password">비밀번호</label>
      <input id="password" type="text" v-model="password">
    </div>
    <div>
      <button type="submit" @click="closePopup">뒤로가기</button>
      <button type="submit" @click="closePopup">생성</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "makeRoomView",
  methods: {
    closePopup: function() {
      this.$emit('close-popup')
    }
  }
}
</script>

<style scoped>

</style>