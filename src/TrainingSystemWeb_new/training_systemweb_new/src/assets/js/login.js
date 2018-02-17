import Modal from "@/common/Modal";
export default {
  components: {
    Modal
  },
  mounted(){
   if(sessionStorage.getItem('userId')!=null){
     this.$router.push('/index');
   }
  },
  methods: {
    cilickLogin() {
      var mythis = this.$refs;
      var myself = this.$router;
      $('#input_Password').next("div").empty();
      $.ajax({
        url: "/perficient/loginUser",
        type: "POST",
        data: $('#login_form').serialize(),
        success: function (data) {
          if (data.code == 101) {
            mythis.myModal.showMyModal(
              false,
              true,
              true,
              true,
              false,
              "",
              "Login Successfully!",
              "OK",
              ""
            );
            mythis.myModal.confirm = function () {
              $.session.set('userId', data.data.userId);
              $.session.set('role', data.data.role);
              $.session.set('userName', $("#input_Username").val());
              $('#userInfo').text("Hello," + $("#input_Username").val());
              $("#LogOut").show();
              if (data.data.role == 1) myself.push("/ListComp");
              else if (data.data.role == 2) myself.push("/listCourses");
              else if (data.data.role == 3){ 
                $("#checkinbox").show();
                myself.push("/index");
              }
              $("#myModal").modal("hide");
            };
          } else {
            $('#input_Password').next("div").append("please input the right password");
          }
        }
      });

    },
    CourseOfCompany() {
      this.$router.push("/CourseOfCompany/艺分之捌社青年音乐(文艺会社)")
    },
    CourseDetails() {
      this.$router.push("/CourseDetails/尤克里里")
    }
  }
}