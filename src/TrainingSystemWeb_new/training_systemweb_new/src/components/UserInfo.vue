<template>
  <div id="UserInfo" class="row">
    <div class="page">
      <app-head></app-head>
      

      <reserve-cou id="reserveCou" ref="cou"></reserve-cou>
      <user-info id="userinfo" ref="info"></user-info>
    </div>

    <app-menu class="menu" ref="menus"></app-menu>
  </div>
</template>

<script src="@/assets/js/UserInfo.js"></script>

<style>
#UserInfo{
  overflow: hidden;
  background-color:#fff;

}
.page{
  position: absolute;
  z-index: 99;
  transition: all 0.5s;
 // border:1px red solid;
  background-color:#fff;

}

.toggle{
  transform: translateX(-120px);
}
.content{
    margin-top: -20px;
    background-color:antiquewhite;
}
.class-a{
  display:none
}

</style>
