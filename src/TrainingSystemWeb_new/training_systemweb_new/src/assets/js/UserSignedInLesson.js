var pageModel;
var self;
var ONEPAGESHOWNUMBER = 9;
import ListPage from "@/common/ListPage";


export default {
  name: "UserSignedInLesson",
  components:{
     ListPage
  },

  data: function() {
    return {
      signedInLessonList:[],
      currentSindedInRecordList: [],
      currentPage: 1,
      totalPage: 1
    };
  },
  mounted() {
    self = this;
    if (sessionStorage.getItem("role") !== '3') this.$router.push("/");
    pageModel = this.$refs.page;
    var userId = sessionStorage.getItem("userId");
    resetListPage();
    this.getAllFixedLessons(userId);

  },
  methods: {

    getAllFixedLessons: function(userId) {
      var url = "perficient/user/signedInLessons?userId=" + userId;
      fetch(url)
        .then(function(response) {

          return response.json();
        })
        .then(res => {

          this.signedInLessonList = res;
          //pagination
          resetListPage();
          getCurrentLessons(1);
          pageModel.flushPageButton();

        })
        .catch(e => {});

    }
  }
};
function getCurrentLessons(p) {

  p--;
  self.currentSindedInRecordList = self.signedInLessonList.slice(
    p * ONEPAGESHOWNUMBER,
    p * ONEPAGESHOWNUMBER + ONEPAGESHOWNUMBER
  );

  self.$parent.$refs.menus.changeDivHeight((40*(self.currentSindedInRecordList.length)+140)+"px");
//

}




function resetListPage() {
  pageModel.flushPageButton = function() {


    var arr = [];
    pageModel.tPage = parseInt(self.signedInLessonList.length / ONEPAGESHOWNUMBER) + 1;
    if (pageModel.tPage > 5)
      arr = [1, 2, 3, 4, 5];
    else
      for (var i = 1; i <= pageModel.tPage; i++)
        arr.push(i);
    pageModel.pButton = arr;
  };


  pageModel.selPage = function(event) {
    var p = $(event.target).text();
    pageModel.nPage = p;
    getCurrentLessons(p);
  };

  pageModel.goPage = function() {
    var p =parseInt($("#inputPageNum").val());

    pageModel.nPage = p;

    getCurrentLessons(p);
  };
}