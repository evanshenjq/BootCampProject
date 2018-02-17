<template>

  <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="qrModal" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-sm" role="document" id="modal_content">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="close()"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Sign in by qrcode</h4>
      </div>
       <div class="modal-body">
        <div class="box">
          <div style="position: relative;">
            <img style="width: 120px;height: 120px;" id="img" src="http://10.2.1.123:8080/perficient/wahaha/qrcode.png"/>
            <input type="file" v-on:change="getUrl($event)" name="" id="file" value="" />
            <div class="alert alert-danger" role="alert" id="error_info"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  
</template>


<script src="@/assets/js/qrcode.js"></script>

<style type="text/css">
body {
  margin: 0;
}
.module-content {
  min-width: 770px;
  max-width: 1000px;
  width: 100%;
  color: #000;
  margin: 0 auto;
}
.module-head {
  text-align: center;
  font-weight: 500;
  margin: 0;
  font-size: 30px;
  height: 100px;
  line-height: 100px;
  color: #000;
}
.box h3 {
  font-weight: 300;
  margin: 0;
  font-size: 20px;
  height: 60px;
  line-height: 60px;
  color: #000;
}
.url-box {
  height: 30px;
  line-height: 30px;
  font-size: 14px;
}
#file {
  position: absolute;
  width: 120px;
  height: 120px;
  opacity: 0;
  top: 0;
  left: 0;
  overflow: hidden;
  z-index: 10;
  cursor: pointer;
}
#error_info{
  display: none;
}
#modal_content{
  width:230px;
}
</style>