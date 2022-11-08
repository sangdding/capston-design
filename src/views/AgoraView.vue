<template>
  <div>
    <div>
      <h1>아고라</h1>
    </div>
    <ModalView v-if="isModalViewed" @close-modal="isModalViewed=false">
      <MakeRoomView/>
    </ModalView>
    <button @click="isModalViewed=true">토론방 개설하기</button>
  </div>
</template>

<script>
import MakeRoomView from "@/components/MakeRoomView";
import ModalView from "@/components/ModalView";
export default {
  name: 'AgoraView',
  components: {
    MakeRoomView,
    ModalView
  },
  data() {
    return {
      isModalViewed: false,
    }
  }
};
</script>

<style scoped>
.background {
  background-color: black;
  opacity: 0.5;
}
</style>