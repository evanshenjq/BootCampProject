<template>
  <div>
    <div class="breadcrumb">
      <h4>{{action}} Course</h4>
    </div>
    <form class="col-md-6 col-md-push-3" id="addCouForm" enctype="multipart/form-data">
      <div class="form-group">
        <label>Logo</label>
        <p class="help-block">Support only pictures.</p>
        <div id="logo">
          <input class="btn btn-default" type="file" @change="getLogo" accept="image/*" name="logo" />
          <img :src="logoUrl" id="logoPreview" v-if="logoPreview">
        </div>
      </div>
  
      <div class="form-group">
        <label>Name</label>
        <div id="couNameInput">
          <input type="text" class="form-control" v-model="couName" name="courseName" id="cName">
          <p v-if="showCouNameError">Name is required</p>
        </div>
      </div>
  
      <div class="form-group">
        <label>Designed for</label>
        <div id="designForDiv">
          <select class="btn btn-default dropdown-toggle" id="desinForA" @change="changeDesignFor">

              <option v-for="d in designA" :value="$index">{{d}}</option>
          </select>
          <select class="btn btn-default dropdown-toggle" id="desinForB" @change="getDesignFor" style="display: none;">
              <option v-for="d in designB" :value="$index">Grade {{d}}</option>
          </select>

        </div>
      </div>
      <div class="form-group">
        <label>Price of Whole Course</label>
        <div>
          <input type="text" v-model="price" class="form-control" @keyup="clearNoNum" v-on:blur="priceToFloat" name="price" />
        </div>
      </div>
  
      <div class="form-group">
        <label>Type</label>
        <div>
          <select class="btn btn-default dropdown-toggle" v-model="type" name="type" id="cType">
                <option value="one-to-one">one-to-one</option>
                <option value="less than 30">less than 30</option>
                <option value="30-50">30-50</option>
                <option value="more than 50">more than 50</option>
            </select>
        </div>
      </div>
  
      <div class="form-group">
        <div>
          <label>CourseStartTime</label>
        </div>
        <el-date-picker v-model="CourseStartTime" type="date" placeholder="Selection date" default-value="2018-01-01" name="CourseStartTime">
        </el-date-picker>
      </div>
  
      <div class="form-group">
        <label>Lessons</label>
        <div>
          <input class="form-control" v-model="classHouers" type="number" name="classHouers" id="cHour">
        </div>
      </div>
  
      <div class="form-group">
        <label>Teacher</label>
        <div>
          <input type="text" v-model="teacher" class="form-control" name="teacher" id="cTheacher">
        </div>
      </div>
  
      <div class="form-group" id="cTime">
        <label>Time</label>
        <div name="cTime" v-for="timebox in timeBoxs">
          <select class="btn btn-default dropdown-toggle" v-model="timebox.weekday">
                  <option value="Sun" selected = "selected">Sun</option>
                  <option value="Mon">Mon</option>
                  <option value="Tue">Tue</option>
                  <option value="Wed">Wed</option>
                  <option value="Thu">Thu</option>
                  <option value="Fri">Fri</option>
                  <option value="Sat">Sat</option>
              </select> From:
          <el-time-select :editable="false" name="startTime" v-model="timebox.start" :picker-options="{
                  start: '08:00',
                  step: '00:15',
                  end: '21:00'
                }" placeholder="Start" @change="putStartTime">
          </el-time-select> To:
          <el-time-select @change="showErrMsg" name="endTime" v-model="timebox.end" :editable="false" :picker-options="{
                  start: '08:00',
                  step: '00:15',
                  end: '21:00'
                }" placeholder="End">
          </el-time-select>
  
          <p class="glyphicon glyphicon-remove" @click="rmButton"></p>
        </div>
  
  
  
        <input type="button" class="btn btn-primary" value="Add" id="addButton" @click="addCou" />
        <p v-if="showInputTime">{{msg}}</p>
      </div>
  
  
      <div class="form-group">
        <label>Introduction</label>
        <div>
          <textarea class="form-control" v-model="introduce" rows="3" name="description" id="cIntroduce"></textarea>
        </div>
      </div>
      <div class="form-group">
        <div class="form-group col-md-3 col-md-push-9" id="option">
          <input type="button" class="btn btn-primary" value="Save" id="saveButton" @click="save" />
          <input type="button" class="btn btn-warning" value="Close" id="closeButton" @click="close" />
        </div>
      </div>
    </form>
    <modal ref="myModal"></modal>
  </div>
</template>

<script src="@/assets/js/addCou.js">
  
</script>

<style src="@/assets/sass/addCou.scss" scoped>
  
</style>

