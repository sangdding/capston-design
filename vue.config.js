const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  devServer: {
    // 3000 포트에서 vue 개발 서버를 실행합니다.
    port:3000
  }
}