<template>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1">
            <div class="onecompDiv" name="onecompDiv" v-for="comp in comps">
                <div class="col-md-2 col-md-push-0 logo col-xs-8 col-xs-push-2" v-if="comp.company.logo!=null&&comp.company.logo!=''" :style="{'background-image': 'url(/perficient/wahaha/' + comp.company.logo + ')'}" @click="turnToComp(comp)"></div>
                <div class="col-md-2 col-md-push-0 logo col-xs-8 col-xs-push-2 logo defaultLogo" v-else @click="turnToComp(comp)"></div>
                <div class="col-md-9 col-xs-12">

                    <div class="col-md-12 nameDiv" name="cpn_name" data-toggle="tooltip" :title="comp.company.name">
                        {{comp.company.name}}
                    </div>

                    <div class="col-md-3 info" data-toggle="tooltip" :title="comp.company.popularity">
                        <span class="glyphicon glyphicon-signal"></span>
                        Sales:<span name="sales">{{comp.company.popularity}}</span>
                    </div>

                    <div class="col-md-3 info" data-toggle="tooltip" :title="comp.company.score">
                        <span class="glyphicon glyphicon-star"></span>
                        Score:<span name="score">{{comp.company.score}}</span>
                    </div>

                    <div class="col-md-6 info" data-toggle="tooltip" :title="comp.company.type">
                        <span class="glyphicon glyphicon-list-alt"></span>
                        Type:<span name="type">{{comp.company.type}}</span>
                    </div>

                    <div class="col-md-12 info" data-toggle="tooltip" :title="comp.company.address">
                        <span class="glyphicon glyphicon-map-marker"></span>
                        Address:<span name="address">{{comp.company.address}}</span>
                    </div>

                    <div class="col-md-12 info" data-toggle="tooltip" :title="comp.company.introduce">
                        <span class="glyphicon glyphicon-file"></span>
                        Introduce:<span name="introduce">{{comp.company.introduce}}</span>
                    </div>

                    <div class="col-md-12 info" data-toggle="tooltip" :title="comp.company.phone">
                        <span class="glyphicon glyphicon-earphone"></span>
                        Phone:<span name="phone">{{comp.company.phone}}</span>
                    </div>

                </div>
                <br>
            </div>
            <div class="col-md-12 text-center" v-show="comps[0]==null" >
                <h3>There is no matching company!</h3>
            </div>
            
        </div>
        <modal ref="myModal"></modal>
    </div>
</template>

<script src="@/assets/js/OneComp.js"></script>
<style src="@/assets/sass/OneComp.scss" scoped></style>


