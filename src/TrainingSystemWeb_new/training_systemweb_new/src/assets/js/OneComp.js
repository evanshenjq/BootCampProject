import store from '@/vuex/store.js'
import Modal from '@/common/Modal'

var self;
var pageModel;
var allComps;

export default {
    components:{
        Modal
       },
    data() {
        return {
            comps: [],
        };
    },
    mounted() {
        self = this;
        pageModel = this.$parent.$refs.page;
        resetListPage();
    },
    methods: {
        getAllComps(res) {
            allComps = res;
            getTenComps(1);
            pageModel.flushPageButton();
        },
        turnToComp(comp) {
            store.commit('setCourses',comp.courses);
            var str = JSON.stringify(comp.courses);
            $.session.set('courses',str);
            $.session.set('score',comp.company.score);
            window.open("/CourseOfCompany/" + comp.company.name);
        }
    }
}

function getTenComps(p) {
    p--;
    self.comps = allComps.slice(p * 10, p * 10 + 10);
}

function resetListPage() {
    pageModel.flushPageButton = function () {
        var arr = [];
        pageModel.tPage = parseInt(allComps.length / 10) + 1;
        if (pageModel.tPage > 5)
            arr = [1, 2, 3, 4, 5];
        else
            for (var i = 1; i <= pageModel.tPage; i++)
                arr.push(i);
        pageModel.pButton = arr;
    }
    pageModel.selPage = function (event) {
        var p = $(event.target).text();
        if(p<=pageModel.tPage&&p>0){
            pageModel.nPage = p;
            getTenComps(p);
        }
    }
    pageModel.goPage = function () {
        var p = parseInt($("#inputPageNum").val());
        if(p>pageModel.tPage||p<=0){
            self.$refs.myModal.showMyModal(
                        true,
                        true,
                        true,
                        false,
                        true,
                        "Warning",
                        "Please input correct page number!",
                        "",
                        "OK"
                    );
        }else{
            pageModel.nPage = p;
            getTenComps(p);
        }
    }
}