<template>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid row">
            <div class="navbar-header">
                <a class="navbar-brand" href="/index">Perficient</a>
            </div>
            <div class="navbar-text pull-right">
              <button  id="checkinbox" class="glyphicon glyphicon-check check-in btn-link" data-toggle="modal" data-target="#qrModal"></button>
              <button id="userInfo" @click="userinfo()" class="glyphicon btn-link">{{mes}}</button>
              <button id="LogOut" @click="logout()" class="glyphicon btn-link">Logout</button>
            </div>
        </div>
    </nav>
</template>

<script>
var self = this;
export default {
  name: "AppHeader",
  data() {
    return {
      mes: "",
    };
  },
  mounted() {
    self = this;
    var userName = sessionStorage.getItem("userName");
    if (userName != null){
      this.mes = "Hello," + userName;
      $("#LogOut").show();
    } 
    else this.mes = "Login";
    let role = sessionStorage.getItem("role");
    if(role==='3'){ 
        $("#checkinbox").show();
      };
    
  },
  methods: {
    logout() {
      $.session.clear();
      $("#checkinbox").hide();
      $("#LogOut").hide();
      this.mes = "Login";
      window.location.href="/index";
    },
    userinfo(){
      this.$router.push('/UserInfo');
    }
  }
};
</script>

<style>
.loginMes {
  cursor: pointer;
  color: white;
}
#checkinbox{
  cursor: pointer;
  display: none;
}
#LogOut{
  display: none;
}
#userInfo{
  font-size: 16px;
}
#LogOut{
  font-size: 16px;
}


</style>

