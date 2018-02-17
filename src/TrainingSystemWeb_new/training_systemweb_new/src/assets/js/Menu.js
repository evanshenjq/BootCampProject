function pageScroll() {
    var t =document.documentElement.scrollTop||document.body.scrollTop;
    window.scrollBy(0,0-t);
  }
  export default {
  name: "menu",
  data() {
    return {
      menus: ["UserInformation", "ReservedCourses", "AttendedCourses","Schedule"],
      userName:''
    };
  },
  mounted(){

    this.userName = sessionStorage.getItem("userName");
  },
  methods:{
    changeShowDiv:function(index) {
      this.$parent.changeDivShow(index);
      pageScroll();

    },
    changeDivHeight:function(index){
       $(".menu").css("height",index);
    }
  }
};