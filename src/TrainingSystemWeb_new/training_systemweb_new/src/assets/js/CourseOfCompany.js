import store from '@/vuex/store.js'
var self;
export default {
    name: 'CourseOfCompany',
    data() {
        return {
            compName: "",
            logo: "",
            type: "",
            address: "",
            phone: "",
            courseNum: 0,
            courses: [],
            introduce: "",
            introPhoto: [],
            score: 0,
            stars: []
        };
    },
    mounted() {
        self = this;
        this.compName = this.$route.params.name;
        getCompInfo();
        getCouInfo();
        self.courses = JSON.parse(sessionStorage.getItem("courses"));
        if (self.courses[0] == null) {
            self.courseNum = 0;
        } else {
            self.courseNum = self.courses.length;
        }
    },
    methods: {
        buyCourse(compName,courseName) {
            this.$router.push("/CourseDetails/" +compName+"/"+ courseName);
        }
    }


}

function getCompInfo() {
    fetch("/perficient/editCompany/oldName/" + self.compName)
        .then(function (response) {
            return response.json();
        })
        .then((res) => {
            self.logo = res.logo == "/wahaha/" || null ? "/perficient/wahaha/logo.png" : "/perficient" + res.logo;
            for (var i = 0; i < res.introPhoto.length; i++) {
                if (res.introPhoto[i] != "/wahaha/" && res.introPhoto[i] !== null)
                    self.introPhoto.push("/perficient" + res.introPhoto[i]);
            }
            self.type = res.type;
            self.phone = res.phone;
            self.address = res.address;
            self.introduce = res.introduce;
            self.$nextTick(function () {
                $("[name='picIndex']:first").addClass("active");
                $("[name='pics']:first").addClass("active");
            })
        }).catch(e => { });

    self.score = sessionStorage.getItem("score");
    var arr = [];
    if(self.score<1&&self.score>0){
    	arr.push(0)
    }
    
    
    else{ 
    for (var i = 1; i <= self.score; i++) {
        arr.push(1);
        if ( ( (self.score - i) < 1)&&( (self.score - i) >0)) arr.push(0);
         
      }
    }
    
    console.log(arr);
    self.stars = arr;
}

function getCouInfo() {
    var cs = store.state.courses;
    self.courses = cs;
    self.courseNum = cs.length;
}
