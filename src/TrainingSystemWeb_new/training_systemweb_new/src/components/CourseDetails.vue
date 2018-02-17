<template>
<div class="container">
	<div id="comp-name">{{compName}}</div>
        <hr>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-6" id="course-image">
                        <img :src="logo" class="img-thumbnail">
                    </div>
                    <div class="col-md-6">
                       <h1 id="course-head">{{name}}</h1>
                        <div id="course-type">Type:<span>{{type}} people</span></div>
                        <div id="course-type">Suitable Crowd:<span>{{designfor}} people</span></div>
                        <p id="price-dollar">$&nbsp;<span id="course-price">{{price}}</span><span class="arrow"></span></p>
                        <!-- <p id="course-intro">Introduction:&nbsp;{{introduction}}</p> -->
                        <div><a class="btn btn-warning btn-lg" href="#" role="button" @click="reserveCourse" id="resr-btn">Reserve</a></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-12 panel panel-default">
            <div class="infoTitle">
                <span>Course Details</span>
            </div>
            <div class="boxAfterTitle">
                    <div class="col-md-6"><p>Course Name<span>{{name}}</span></p></div>
                    <div class="col-md-6"><p>Course Type<span>{{type}} people</span></p></div>
                    <div class="col-md-6"><p>Suitable Crowd<span>{{designfor}} people</span></p></div>
                    <div class="col-md-6"><p>Frequency<span>{{lessons}}</span></p></div>
                    <div class="col-md-6"><p>Teacher<span>{{teacher}}</span></p></div>
                    <div class="col-md-6"><p>Start Time<span>{{courseStartTime}}</span></p></div>
                    <div class="col-md-12"><p>Time in a week<span v-for="time in courseTimes">{{time}};</span></p></div>
            </div>
        </div>
        <div class="col-md-12 panel panel-default">
            <div class="infoTitle">
                <span>Course Introduction</span>
            </div>
            <div class="boxAfterIntr">
                    <div class="col-md-12"><span>{{introduction}}</span></div>
            </div>
        </div>
        <modal ref="myModal"></modal>
</div>
</template>

<script src="@/assets/js/CourseDetails.js"></script>
<style src="@/assets/sass/CourseDetails.scss" scoped></style>

