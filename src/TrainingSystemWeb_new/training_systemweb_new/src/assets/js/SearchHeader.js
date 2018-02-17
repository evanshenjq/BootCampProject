import store from '@/vuex/store.js'

    export default {
        data() {
            return {
                type: "",
                design: "",
                address: "",
                sort:"Sort by popularity"
            };
        },
        mounted(){
            this.searchInfo();
        },
        methods: {
            
            search_type(event) {
                
                if(this.type==$(event.target).text()){
                    this.type ="";
                    $('#small_t').hide();
                }else{
                    this.type = $(event.target).text();
                    $('#small_t').show();
                }
                this.searchInfo();
            },
            //search ways
            search_designP(event) {  
                if(this.design==$(event.target).text()){
                    this.design ="";
                    $('#small_d').hide();
                }else{
                this.design = $(event.target).text();
                $('#small_d').show();
                }
                this.searchInfo();
            },

             search_design(event) {
                if($(event.target).attr('id')=='p'){
                    if(this.design=='Primary school-'+$(event.target).text()){
                        this.design ="";
                        $('#small_d').hide();
                    }else{
                    this.design = 'Primary school-'+$(event.target).text();
                    $('#small_d').show();
                    }
                }
                if($(event.target).attr('id')=='m'){
                    if(this.design=='Junior middle school-'+$(event.target).text()){
                        this.design ="";
                        $('#small_d').hide();
                    }else{
                    this.design = 'Junior middle school-'+$(event.target).text();
                    $('#small_d').show();
                    }
                }
                if($(event.target).attr('id')=='h'){
                    if(this.design=='Junior high school-'+$(event.target).text()){
                        this.design ="";
                        $('#small_d').hide();
                    }else{
                    this.design = 'Junior high school-'+$(event.target).text();
                    $('#small_d').show();
                    }
                }
                if($(event.target).attr('id')=='u'){
                    if(this.design=='Unviersity-'+$(event.target).text()){
                        this.design ="";
                        $('#small_d').hide();
                    }else{
                    this.design = 'Unviersity-'+$(event.target).text();
                    $('#small_d').show();
                    }
                }
                this.searchInfo();
            },
            judge(str){

                if(this.design==str+$(event.target).text()){
                    this.design ="";
                }else{
                this.design = str+$(event.target).text();
                }
            },
            search_add(event) {
                if(this.address==$(event.target).text()){
                    this.address ="";
                    $('#small_a').hide();
                }else{
                this.address = $(event.target).text();
                $('#small_a').show();
                }
                this.searchInfo();
            },
            search_sort(event) {
                this.sort = $(event.target).text();
                this.searchInfo();
            },


             changeColor(event){
                 if($(event.target).parent().attr('id')=='search_designfor'){
                    $(event.target).css('background','#F0F0F0')
                }else{
                    $(event.target).parent().css('background','#F0F0F0')
                }
            },
            changeWhite(event){
                if($(event.target).parent().attr('id')=='search_designfor'){
                    $(event.target).css('background','#FFF')
                }else{
                    $(event.target).parent().css('background','#FFF')
                }
            },
            searchInfo(){
                var designfor=this.design;
                var type=this.type;
                var address=this.address;
                var filter=type+","+designfor+','+address+' '; 
                var formdata=new FormData();
                if(this.sort=="Sort by popularity"){
                    var sort=1;
                }else{
                    var sort=2;
                }
                //formdata add info
                formdata.append('filter',filter);
                formdata.append('sort',sort);
                formdata.append('searchKey',$('#search_content').val());

                var url="/perficient/search";
                fetch(url,{
                    method:'post',
                    body:formdata
                }).then(function(response){
                    return response.json()
                }).then((res)=> {
                    this.$parent.$refs.onecomp.getAllComps(res);
                    store.commit('setCompList',res);
                    console.log(res);
                })
            },
            clearAll(){
                this.type="";
                this.design="";
                this.address="";
                this.searchInfo();
                $('#small_d').hide();
                $('#small_a').hide();
                $('#small_t').hide();
            }
        }
    };
    $("body").on('click','[data-stopPropagation]',function (e) {
        e.stopPropagation();
    });