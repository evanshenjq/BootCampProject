<template>
    <div>
        <div class="breadcrumb">
            <h4>{{action}} Company</h4>
        </div>
        <form class="col-md-6 col-md-push-3" id="myForm" enctype="multipart/form-data">
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
                <div id="compNameInput">
                    <input type="text" class="form-control" v-model="compName" name="name">
                    <p v-if="showCompNameError">Name can not be null!</p>
                </div>
            </div>
            <div class="form-group">
                <label>Type</label>
                <div>
                    <select class="btn btn-default dropdown-toggle" name="type" v-model="type">
                        <option value="comprehensive">Comprehensive</option>
                        <option value="IT">IT</option>
                        <option value="art">Art</option>
                        <option value="tutorship">Tutorship</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label>Phone</label>
                <div>
                    <input class="form-control" type="number" name="phone" v-model="phone">
                </div>
            </div>
            <div class="form-group">
                <label>Address</label>
                <div>
                    <input type="text" class="form-control" name="address" v-model="address">
                </div>
            </div>
            <div class="form-group">
                <label>Introduction</label>
                <div>
                    <textarea class="form-control" rows="3" name="introduce" v-model="introduce"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label>Pictures</label>
                <p class="help-block">Support only pictures.</p>
                <div id="pictures">
                    <input class="btn btn-default" type="file" multiple="true" @change="getFile" accept="image/*" name="introphoto" />
                    <div v-for="preUrl in preUrls">
                        <div class="picturesImg" :style="{'background-image': 'url(' + preUrl + ')'}" @mouseover="showDelPicBtn($event)" @mouseout="hideDelPicBtn($event)">
                            <input type="button" class="btn btn-danger hideDiv pull-right" @click="delOnePic(preUrl)" value="✖">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4 col-md-push-8" id="option">
                    <input type="button" class="btn btn-primary" value="Save" id="saveButton" @click="save" />
                    <input type="button" class="btn btn-warning" value="Close" id="closeButton" @click="close" />
                </div>
            </div>
        </form>
        <modal ref="myModal"></modal>
    </div>
</template>

<script src="@/assets/js/AddComp.js"></script>
<style src="@/assets/sass/AddComp.scss" scoped></style>


