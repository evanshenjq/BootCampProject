import AppHead from '@/common/Head'
import AppMenu from '@/common/Menu'
import ReserveCou from '@/common/ReserveCou'

import UserSignedInLesson from '@/components/UserSignedInLesson'



$(window).resize(function() {
   var pageHeight =  parseInt($(".page").height());
   $(".menu").css("height",pageHeight+"px");

  var windowHeight = window.screen.height;
  if(windowHeight < 1000  && windowHeight != 768){
    $(".menu").css("top",125+"px");}
  else {
    $(".menu").css("top", 74 + "px");
  }
});

$(function(){
  var windowHeight = window.screen.height;
  if(windowHeight < 1000 && windowHeight != 768){
   $(".menu").css("height","870px");
  }
  else
    $(".menu").css("height","510px");
});


window.addEventListener("scroll",function(e){
  var windowHeight = window.screen.height;
  var t =document.documentElement.scrollTop||document.body.scrollTop;
  if(t>128){
    $(".menu").css("top",(t)+"px");
  }else{
    if(windowHeight < 1000&& windowHeight != 768 )
      $(".menu").css("top","125px");
    else {
      $(".menu").css("height","510px");
      $(".menu").css("top", "74px");
    }
  }
});

export default {
  name: 'UserInfo',
  components: {
    'app-head': AppHead,
    'app-menu': AppMenu,
    'user-info':UserSignedInLesson,
    'reserve-cou':ReserveCou
  },
  mounted(){
     $("#userinfo").hide();
    if($.session.get('signin')==='1'){
      window.location.reload();
      $.session.remove('signin');
    };
    
  },
 data(){
 return {
   userName:"",

}
},

methods:{
 getUserName:function(){
var userName = sessionStorage.getItem("userName");
},

changeDivShow(index){
   if(index === 2) {
     $("#userinfo").show();
     $("#reserveCou").hide();
   }
   else if(index === 1) {
     $("#reserveCou").show();
     $("#userinfo").hide();
   }else if(index === 3) {
     this.$router.push("/schedule");
   }
   else {

   }
  }

}
}