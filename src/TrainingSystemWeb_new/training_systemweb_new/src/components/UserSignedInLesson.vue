<template>
  <div id = 'UserSignedInLesson'>
      <div class="row">
        <div class="col-md-12">
            <ul class="list-group " name="currentLessonList">

            <li class="list-group-item col-md-10 col-xs-10 col-md-offset-1 col-xs-offset-1"  v-for="SignedInRecord in currentSindedInRecordList">
              <div class="row">
                <span id="courseName" class="col-md-3 col-xs-3">
               <span class="highlight glyphicon glyphicon-book">   课程名:</span>
                  {{SignedInRecord.courseName}}
                </span>
                <span id="courseStartTime" class="col-md-4 col-xs-4">
                <span class="highlight glyphicon glyphicon glyphicon-bell">  开课时间:</span>
                {{SignedInRecord.courseStartTime}}
                </span>
                <span id="classHouers" class="col-md-3 col-xs-3">
                <span class="highlight glyphicon glyphicon-calendar" >  当前课时:</span>
                  {{SignedInRecord.classHouers}}
                </span>

              </div>
            </li>


          </ul>               <br>

            <div class="col-md-12 text-center"  v-show="signedInLessonList[0]==null">
                <h3>You have not taken any class yet!</h3>
            </div>

        </div>
    </div>


   <list-page ref="page"></list-page>
  </div>
</template>


<script src="@/assets/js/UserSignedInLesson.js"></script>

<style>
  #UserSignedInLesson{
    width:100%;
    background:#fff;

  }
.highlight{
  color: #19c8a9;
}
</style>
