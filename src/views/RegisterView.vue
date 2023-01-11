<template>
  <div>
    <b-form v-on:submit.prevent="RegisterForm">
      <b-form-group
          id="userId"
          label="ID:"
          label-for="userId"
      >
        <b-form-input
            id="userId"
            type="text"
            v-model="userId"
            placeholder="사용할 ID를 입력하세요"
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="password"
          label="password:"
          label-for="password"
      >
        <b-form-input
            id="password"
            type="text"
            v-model="password"
            placeholder="사용할 비밀번호를 입력하세요"
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="email"
          label="Email:"
          label-for="email"
      >
        <b-form-input
            id="email"
            type="email"
            v-model="email"
            placeholder="이메일 주소를 입력해 주세요"
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="nickname"
          label="닉네임:"
          label-for="nickname"
      >
        <b-form-input
            id="nickname"
            type="text"
            v-model="nickname"
            placeholder="사용할 닉네임을 입력하세요"
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">회원가입</b-button>
    </b-form>
  </div>

</template>

<script>
export default {
  data: function () {
    return {
      userId: '',
      email: '',
      password: '',
      nickname: ''
    }
  },
  methods: {
    RegisterForm: function () {
      var data = {
        userId: this.userId,
        eamil: this.email,
        password: this.password,
        nickname: this.nickname
      }
      this.axios.post("main/register", data)
          .then((response) => {
            let result = response.data.resultCode
            let message = response.data.message
            if (result === 'success') {
              alert("회원가입이 완료되었습니다!");
              this.$router.push({path: '/login'});
            } else {
              alert(message)
              this.$router.go(this.$router.currentRoute)
            }
          })
          .then(function (error) {
            console.log(error);
          })
    }
  }
}
</script>

<style scoped>

</style>