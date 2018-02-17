<template>
  <div>
    <div class="modal fade" id="myQrModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Create QrCode</h4>
      </div>
      <div class="modal-body">
        
        <div class="row">
       <span class="col-md-2">Courses:</span>
       <select class="form-control col-md-2" id="select_comp" style="width:150px">
          <option v-for="comp in comps" :value="comp.id">{{comp.courseName}}</option>
        </select>
        </div>
        <br/>
        <span class="demonstration">Time:</span>
          <el-date-picker v-model="value1" type="datetime" placeholder="选择日期时间" format="yyyy-MM-dd HH:mm">
          </el-date-picker>

          <button class="btn btn-info" @click="createQR">create</button>

       
        
        <div id="qrcode" style="width:500px; height:500px; margin-top:15px;"></div>
      </div>
    </div>
  </div>
</div>

    <div class="container">
      <div class="jumbotron">
        <h1><span><img :src="company.logo" style="width:160px;height:160px"></span> Hello,{{company.name}}</h1>
        <p>{{company.introduce}}</p>
      </div>
  
      <nav class="navbar navbar-default" role="navigation">
        <div id="option">
          <button class="btn btn-info" id="selAllDiv" data-toggle="tooltip" title="SelectAll" @click="selAllBtn">
            <input type="checkbox" id="selectAllCheckBox" v-model="selAllCheckbox" readonly="readonly">
            <span class="glyphicon glyphicon-th"></span>
          </button>
          <button class="btn btn-warning" id="createButton" @click="create" data-toggle="tooltip" title="Add">
            <span class="glyphicon glyphicon-plus"></span>
          </button>
          <button class="btn btn-danger" id="delButton" @click="del" disabled="disabled" data-toggle="tooltip" title="Delete">
            <span class="glyphicon glyphicon-minus"></span>
          </button>
          <button class="btn btn-danger" id="createQR" data-toggle="modal" data-target="#myQrModal">
            <span class="glyphicon glyphicon-gift"></span>
          </button>
          
      
        </div>
      </nav>
      <!--./search -->
      <div class="row" v-show="showCourse" id="courseList">
        <div class="col-md-3 col-sm-4 col-xx-6 oneCourseDiv" name="oneCourse" v-for="course in courses">
          <div class="logo" :style="{'background-image': 'url(' + course.logo + ')'}" @mouseover="showDelCourse($event)" @mouseout="hideDelCourse($event)">
            <input type="button" class="btn btn-danger hideDiv pull-right" @click="delOneCourse(course.courseName)" value="✖" data-toggle="tooltip" title="Delete">
            <button type="button" class="btn btn-default hideDiv pull-right" name="editButton" @click="editCourse(course.courseName)" data-toggle="tooltip" title="Edit">
                <span class="glyphicon glyphicon-edit"></span>
            </button>
          </div>
          <div class="row">
            <div class="col-md-12 col-sm-12 col-xx-12 nameDiv toomuchText" name="list_name" data-toggle="tooltip" :title="course.courseName">
              <input type="checkbox" name="selectCheckBox" :value="course.courseName" @click="selDel($event)">
              {{course.courseName}}
            </div>
            <div class="col-md-5 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="course.description">dec:{{course.description}}</div>
            <div class="col-md-5 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="course.type">Type: {{course.type}}</div>
            <div class="col-md-12 col-sm-12 col-xx-12 grayFont toomuchTextt" data-toggle="tooltip" :title="course.classHouers">Lessons: {{course.classHouers}}</div>
            <div class="col-md-12 grayFont toomuchText" data-toggle="tooltip" :title="course.price">
              $<span style="font-size:18px;color:#f63">{{course.price}}</span>
            </div>
  
          </div>
          <br>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="@/assets/js/listCourse.js"></script>
<style src="@/assets/sass/ListTable.scss" scoped></style>
