<template>
<div class="modal">
  <div class="overlay"></div>
  <div class="modal-card">
    <slot/>
  </div>
</div>
</template>

<script>
export default {
  name: "ModalView"
}
</script>

<style scoped>
.modal,
.overlay{
  width:100%;
  height: 100%;
  position: fixed;
  left: 0;
  right: 0;
}
.overlay{
  opacity: 0.5;
  background-color:black;
}
.modal-card{
  position:relative;
  max-width:80%;
  margin: 30px auto auto;
  padding:20px;
  background-color:white;
  min-height:500px;
  z-index:10;
  opacity:1;

}
</style>