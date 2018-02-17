var userId;
var pageModel;
var allCourses;
var self;
var pageSize = 5;
import ListPage from "@/common/ListPage";
import Modal from '@/common/Modal'
export default {
    components:{
     ListPage,
     Modal
    },
    data() {
        return {
            allCourses:[],
            courses: [],
        };
    },
    mounted() {
        self = this; 
        pageModel = this.$refs.page;        
        userId = sessionStorage.getItem("userId");
        resetListPage();
        this.ListPage();
    },
    methods:{
        ListPage(){
            var url="/perficient/user/getCourse?userId="+userId;
            fetch(url)
                .then(function(response){
                    return response.json();
                })
                .then(res => {
                    this.allCourses = res;
                    resetListPage();
                    getCourese(1);
                    pageModel.flushPageButton();
                }).catch(e => { })
        },
        turnToDetail(courseName){
            var compName = "  ";
            this.$router.push("/CourseDetails/"+compName+"/"+ courseName);
        }
    }
};
function getCourese(p) {
    p--;
    self.courses = self.allCourses.slice(p * pageSize, p * pageSize + pageSize);
}
function resetListPage() {
  pageModel.flushPageButton = function() {
    var arr = [];
    console.log(self.allCourses.length);
    var pageNum = parseInt(self.allCourses.length / pageSize);
    self.allCourses.length%pageSize==0?pageModel.tPage=pageNum:pageModel.tPage=pageNum+1;
    if (pageModel.tPage > 5)
      arr = [1, 2, 3, 4, 5];
    else
      for (var i = 1; i <= pageModel.tPage; i++)
        arr.push(i);
    pageModel.pButton = arr;
  };


  pageModel.selPage = function(event) {
    var p = $(event.target).text();
    if(p<=pageModel.tPage&&p>0){
        pageModel.nPage = p;
        getCourese(p);
    }
  };

  pageModel.goPage = function() {
    var p =parseInt($("#inputPageNum").val());
    if(p>pageModel.tPage||p<=0){
    }else{
        pageModel.nPage = p;
        getCourese(p);
    }
  };
}