import Modal from "@/common/Modal";
var self ;
export default {
    name:'CourseDetails',
    data(){
        return{
            logo:'',
            name:'',
            introduction:'',
            price:'',
            designfor:'',
            type:'',
            lessons:'',
            teacher:'',
            type:'',
            time:'',
            courseID:'',
            compName:'',
            courseStartTime:'',
            courseTimes:[]
        }
    },
    components: {
      Modal
    },
    mounted(){
        self = this;
        this.getCourseDetails();
    },
    methods: {
        getCourseDetails()
        {
            name = this.$route.params.name;
	        this.compName = this.$route.params.compName;
            var formData = new FormData();
            formData.append("oldName", name);
            var url = "/perficient/editCourse";
            fetch(url,{
                method: 'post',
                body: formData
            }).then(function(response) {
                return response.json();
                })
                .then((res) => {    
                this.logo = "/perficient" + res.logo;
                console.log(this.logo);
                if(this.logo == "/perficient/wahaha/")
                    this.logo = "/perficient/wahaha/logo.png";
                this.name = res.courseName;
                this.designfor = res.suitableCrowd;
                this.price = res.price;
                this.type = res.type;
                this.lessons = res.classHouers;
                this.teacher = res.teacher;
                this.introduction = res.description;
                this.time= res.time;
                this.courseID = res.id;    
                this.courseStartTime = res.courseStartTime;
                this.getTimeArray(this.time);
                }).catch(e => {})
        },
        reserveCourse()
        {   
              this.$refs.myModal.confirm = this.postform
              this.$refs.myModal.showMyModal(
                true,
                true,
                true,
                true,
                true,
                "Confirm",
                "Are you sure to reserve?",
                "Yes",
                "No"
              );
        },
        postform()
        {
            let formData= new FormData();
            formData.append("courseId",this.courseID)
            formData.append("userId",sessionStorage.getItem("userId"))
            
            let url = '/perficient/user/reserveCourse'
            fetch(url,{method: 'post',
                body: formData}).then(function (response) {
                return response.json();
                }).then(res => {
                   
                    if (res.code == 0) {
                        this.$refs.myModal.showMyModal(
                        true,
                        true,
                        false,
                        true,
                        true,
                        res.msg,
                        "You'll turn to the list of company after 3sec.",
                        "",
                        ""
                        );
                    setTimeout(turnToList, 3000);
                    } else {
                        this.$refs.myModal.showMyModal(
                        true,
                        true,
                        true,
                        false,
                        true,
                        "Warning",
                        res.msg,
                        "",
                        "OK"
                    );
                }
              })
              .catch(e => { });            
        },
        getTimeArray(time){
            this.courseTimes = time.split(",");
            console.log(this.courseTime);
        }
    }
}
function turnToList() {
    self.$router.push("/UserInfo");
    $("#myModal").modal("hide");
  }
