<template>
    <div>
        <div class="row">
            <div class="col-md-10 col-md-offset-2 col-xs-10 col-xs-offset-1 ReserveCouDiv" name="ReserveCouDiv" v-for="course in courses" @click="turnToDetail(course.courseName)">
                <div class="col-md-2 col-md-push-0 col-sm-4 col-sm-push-0 col-xs-8 col-xs-push-2 logo" v-if="course.logo!=null&&course.logo!=''" :style="{'background-image': 'url(/perficient/wahaha/' + course.logo + ')'}" name="logo"></div>
                <div class="col-md-2 col-md-push-0 col-sm-4 col-sm-push-0 col-xs-8 col-xs-push-2 logo" v-else :style="{'background-image': 'url(/perficient/wahaha/logo.png)'}"></div>
                <div class="col-md-9 col-sm-7 col-xs-12 detail">
                    <div class="col-md-12 col-sm-12 col-xs-12 nameDiv" name="courseName">
                        Name: {{course.courseName}}
                    </div>
                    
                    <div class="col-md-5 col-sm-5 col-xs-12 info" :title="course.type" name="type">
                        <span class="glyphicon glyphicon-list-alt"></span>
                        Type: {{course.type}}
                    </div>
                    <div class="col-md-7 col-sm-7 col-xs-12 info" :title="course.suitableCrowd" name="SuitableCrowd">
                        <span class="glyphicon glyphicon-user"></span>
                        SuitableCrowd: {{course.suitableCrowd}}
                    </div>   
                    <div class="col-md-5 col-sm-5 col-xs-12 info" :title="course.classHouers" name="classHouers">
                        <span class="glyphicon glyphicon-dashboard"></span>
                        ClassHouers: {{course.classHouers}}
                    </div>
                    <div class="col-md-7 col-sm-7 col-xs-12 info" :title="course.time" name="time">
                        <span class="glyphicon glyphicon-time"></span>
                        Time: {{course.time}}
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12 info" :title="course.price" name="price">
                        <span class="glyphicon glyphicon-usd"></span>
                        Price: {{course.price}}
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12 info" :title="course.description" name="description">
                        <span class="glyphicon glyphicon-file"></span>
                        Dec:{{course.description}}
                    </div>
                </div>
                <br>
            </div>
            <div class="col-md-12 text-center" v-show="allCourses[0]==null" >
                <h3>There is no coureses reserved!</h3>
            </div>
        </div>
        <list-page class="col-md-offset-1" ref="page"></list-page>
        <modal ref="myModal"></modal>
    </div>
</template>

<script src="@/assets/js/ReserveCou.js"></script>
<style src="@/assets/sass/ReserveCou.scss" scoped></style>