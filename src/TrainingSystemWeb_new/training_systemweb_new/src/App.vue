<template>
  <div id="app">
    <app-header ref="appHeader"></app-header>
    <qr-code></qr-code>
    <router-view/>
  </div>
</template>

<script> 
  import AppHeader from '@/common/AppHeader'
  import QrCode from '@/common/QrCode'
  export default {
    name: 'app',
    components: {
      AppHeader,
      QrCode
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }
</style>
