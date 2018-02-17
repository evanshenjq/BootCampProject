<template>
    <div class="row">
        <!-- <div class="col-md-12 col-md-offset-2">  -->
        <div class="col-md-10 col-md-offset-1">
           <div class="col-md-12 panel panel-default">
               <h2 class="compName" name="cpn_name">{{compName}}</h2>
               <div class="boxAfterTitle">
                   <div class="col-md-4 logo" v-if="logo!=null&&logo!=''" :style="{'background-image': 'url(' + logo + ')'}"></div>
                   <div class="col-md-4 logo noPic" v-else :style="{'background-image': 'url(/perficient/wahaha/logo2.jpeg)'}"></div>
                   <div class="col-md-8 infoAfterLogo">
                       <div>
                           <span class="glyphicon glyphicon-heart"></span>
                            <span class="smlLabel">Score:</span>{{score}}
                            <span class="glyphicon glyphicon-star" v-for="star in stars" v-if="star==1"></span>
                            <span class="glyphicon glyphicon-star-empty" v-for="star in stars" v-if="star==0"></span>
                        </div>
                       <div>
                            <span class="glyphicon glyphicon-list-alt"></span>
                            <span class="smlLabel">Type:</span>{{type}}
                       </div>
                        <div>
                            <span class="glyphicon glyphicon-map-marker"></span>
                            <span class="smlLabel">Address:</span>{{address}}
                        </div>
                        <div>
                            <span class="glyphicon glyphicon-earphone"></span>
                            <span class="smlLabel">Phone:</span>{{phone}}
                       </div>
                   </div>
               </div>
           </div>

            <div class="col-md-12 panel panel-default">
                <div class="infoTitle">
                    The course of our shop
                    <span class="num">({{courseNum}})</span>
                </div>
                <div class="boxAfterTitle">
                    <div class="col-md-6 oneCourse" v-for="course in courses" @click="buyCourse(compName,course.courseName)" v-if="course">
                        <div class="introPic col-md-12" v-if="course.logo!=null&&course.logo!=''" :style="{'background-image': 'url(/perficient/wahaha/' + course.logo + ')'}" ></div>
                        <div class="introPic col-md-12" v-else :style="{'background-image': 'url(/perficient/wahaha/logo.png)'}"></div>
                            <p class="courseName col-md-12">{{course.courseName}}</p>
                            <p class="summary col-md-12">{{course.description}}</p>
                            <p class="price col-md-12">${{course.price}}</p>
                    </div>
                    <div class="col-md-6" v-else >
                        <h4>No Fit Courses</h4>
                    </div>
                </div>
            </div>

            <div class="col-md-12 panel panel-default" v-if="introduce!=''">
                <div class="infoTitle">
                    Business introduction
                </div>
                <div class="info">
                    &nbsp&nbsp&nbsp&nbsp
                    {{introduce}}
                </div>
            </div>

            <div class="col-md-12 panel panel-default" v-if="introPhoto.length>0">
                <div class="infoTitle">
                    Official photo album
                </div>
                <div class="boxAfterTitle col-md-6 col-md-push-3">
                    <div id="myCarousel" class="carousel slide">
                        <ol class="carousel-indicators">
                            <li v-for="pic in introPhoto" data-target="#myCarousel" :data-slide-to="$index" name="picIndex"></li>
                        </ol>   

                        <div class="carousel-inner">
                            <div v-for="pic in introPhoto" class="item" name="pics" v-if="pic">
                                <img :src="pic" class="introPic">
                            </div>
                        </div>

                        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script src="@/assets/js/CourseOfCompany.js"></script>
<style src="@/assets/sass/CourseOfCompany.scss" scoped></style>
