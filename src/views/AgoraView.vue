<template>
 <div>
   <h1>아고라</h1>
 </div>
  <div>
    <makeRoomForm/>
  </div>
</template>

<script>
import makeRoomForm from "@/components/makeRoomForm";
export default {
  name: "makeRoom",
  components: {
    makeRoomForm,
  }
};
</script>

<style scoped>

</style>