<template>
    <div>
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
            <div class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" id="inputSearch" v-model="key" @keyup.enter="search">
                </div>
                <button class="btn btn-primary" id="search" @click="search" data-toggle="tooltip" title="Search">
                  <span class="glyphicon glyphicon-search"></span>
                </button>
            </div>
        </div>
        <hr/>
        <div class="row" v-show="showTable" id="compList">
            <div class="col-md-3 col-sm-4 col-xx-6 oneCompDiv" name="oneComp" v-for="comp in comps">
                <div class="logo" :style="{'background-image': 'url(' + comp.logo + ')'}" @mouseover="showDelComp($event)" @mouseout="hideDelComp($event)">
                    <input type="button" class="btn btn-danger hideDiv pull-right" @click="delOneComp(comp.name)" value="✖" data-toggle="tooltip" title="Delete">
                    <button type="button" class="btn btn-default hideDiv pull-right" name="editButton" @click="editComp(comp.name)" data-toggle="tooltip" title="Edit">
                        <span class="glyphicon glyphicon-edit"></span>
                    </button>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xx-12 nameDiv toomuchText"  data-toggle="tooltip" :title="comp.name">
                      <input type="checkbox" name="selectCheckBox" :value="comp.name" @click="selDel($event)">
                      <span name="list_name">{{comp.name}}</span>
                    </div>
                    <div class="col-md-5 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="comp.type">Type:{{comp.type}}</div>
                    <div class="col-md-7 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="comp.phone">Phone:{{comp.phone}}</div>
                    <div class="col-md-12 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="comp.address">Address:{{comp.address}}</div>
                    <div class="col-md-12 col-sm-12 col-xx-12 grayFont toomuchText" data-toggle="tooltip" :title="comp.introduce">Introduce:{{comp.introduce}}</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script src="@/assets/js/ListTable.js"></script>
<style src="@/assets/sass/ListTable.scss" scoped></style>
