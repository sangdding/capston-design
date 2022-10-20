<template>
 <div>
   <h1>아고라</h1>
 </div>
  <div>
    <api-get/>
  </div>
</template>

<script>
import apiGet from "@/components/script/apiGet";
export default {
  name: "agoraRoom",
  components: {
    apiGet,
  }
};
</script>

<style scoped>

</style>