<template>
  <section id="menu">

    <p class="user" title="" v-model="userName">{{userName}}</p>
    <ul class="aside list-group">
      <!--&lt;!&ndash;&lt;!&ndash;<li><router-link to= '/UserInfo/UserSignedInLesson'> 个人信息</router-link></li>&ndash;&gt;&ndash;&gt;-->
       <!--&lt;!&ndash;<li><router-link to= '/UserSignedInLesson'> 已预约课程</router-link></li>&ndash;&gt;-->
       <!--<li><router-link to= '/UserSignedInLesson'> 已签到课程</router-link></li>-->
    <div class="clas">
      <li v-for='(m,index) in menus' class="list-group-it" @click="changeShowDiv(index)" :class="index">
        <span :id = "index"><u>{{m}}</u></span>
      </li>
    </div>
    </ul>
  </section>
</template>

<script src="@/assets/js/Menu.js"></script>

<style>
#menu {
  position: absolute;
// top: 72px; right: 0;
  color: #fff;
  width: 120px;
  background: #3C3C3D;
  z-index: 9;
}
  #menu .user {
    height: 60px;
    line-height: 60px;
    background: #000;
    text-align: center;
    width: 100%;
    padding: 0 20%;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  }

  #menu .aside {
    width: 100%;
    height: 200px;
    margin-top:81px;

  }

  .aside li {
    width:120%;
    margin-left:10%;
    height:50px;
    padding:20px 0;
    cursor: pointer;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    text-align:center;


    a {
      height: 100%;
      color: #FFFFFF;
      line-height: 50px;
      display: inline-block;
    }
  }

  .aside li:hover {
    background-color: #3E90E3;
  }
  .clas{
    margin-top:-40%;
    margin-left:-30%;
  }



</style>
