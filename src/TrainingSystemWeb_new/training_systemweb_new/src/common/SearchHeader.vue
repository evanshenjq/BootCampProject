<template>
    <div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#search_conditions" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                
                <div class="collapse navbar-collapse row" id="search_conditions">
                    <!-- TYPE选项下拉栏 -->
                        <div id="search_type" class="col-md-2 col-xs-3 col-md-offset-1">
                            <ul class="nav navbar-nav">
                                <!-- 下拉过滤器 -->
                                <li class="dropdown">
                                    <a href=" " class="dropdown-toggle search_con" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Filter <span class="caret"></span></a >
                                        <ul class="dropdown-menu">
                                            <div id="select_conditions">
                                                <span id="small_d" class="small">{{design}}</span>  &nbsp
                                                <span id="small_t" class="small"> {{type}}</span> &nbsp
                                                <span id="small_a" class="small"> {{address}}</span>
                                            </div>
                                            <div id="search_name">Design for </div>
                                            <li role="separator" class="divider"></li>
                                            <div id="search_designfor" @mouseover="changeColor($event)" @mouseout="changeWhite($event)">
                                                <li>
                                                        <a class="btn btn-link" @click="search_designP($event)" data-stopPropagation="true">Pre school</a>
                                                </li>
                                            </div>

                                            <div id="search_designfor" @mouseover="changeColor($event)" @mouseout="changeWhite($event)">
                                                <li class="dropdown-submenu">
                                                    <a class="btn btn-link" data-stopPropagation="true">Primary school</a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 1</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 2</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 3</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 4</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 5</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="p">Grade 6</a></li>
                                                    </ul>  
                                                </li>
                                            </div>   

                                            <div id="search_designfor" @mouseover="changeColor($event)" @mouseout="changeWhite($event)">
                                            <li class="dropdown-submenu">
                                                <a class="btn btn-link" data-stopPropagation="true">Junior middle school</a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="m">Grade 1</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="m">Grade 2</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="m">Grade 3</a></li>
                                                    </ul>  
                                            </li>
                                            </div>

                                            <div id="search_designfor" @mouseover="changeColor($event)" @mouseout="changeWhite($event)">
                                            <li class="dropdown-submenu">
                                                <a class="btn btn-link" data-stopPropagation="true">Junior high school</a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="h">Grade 1</a></li>
                                                    <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="h">Grade 2</a></li>
                                                    <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="h">Grade 3</a></li>
                                                </ul>  
                                            </li>
                                            </div>
                                            

                                            <div id="search_designfor" @mouseover="changeColor($event)" @mouseout="changeWhite($event)">
                                                <li class="dropdown-submenu">
                                                    <a class="btn btn-link" data-stopPropagation="true">University</a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="u">Grade 1</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="u">Grade 2</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="u">Grade 3</a></li>
                                                        <li><a href="#" @click="search_design($event)" data-stopPropagation="true" id="u">Grade 4</a></li>
                                                    </ul>  
                                                </li>
                                            </div>
                                            
                                            
                                            <div>
                                            <div id="search_name">Type</div>
                                                <li role="separator" class="divider"></li>
                                                <button @click="search_type($event)" class="btn btn-link" data-stopPropagation="true">one-to-one</button>
                                                <button @click="search_type($event)" class="btn btn-link" data-stopPropagation="true">less than 30</button>
                                                <button @click="search_type($event)" class="btn btn-link" data-stopPropagation="true">30-50</button>
                                                <button @click="search_type($event)" class="btn btn-link" data-stopPropagation="true">more than 50</button>
                                            </div>

                                            <div>
                                                <div id="search_name">Address </div>
                                                <li role="separator" class="divider"></li>
                                                <button @click="search_add($event)" class="btn btn-link" data-stopPropagation="true">add1</button>
                                                <button @click="search_add($event)" class="btn btn-link" data-stopPropagation="true">add2</button>
                                            </div>
                                            <div class="col-md-offset-10 col-xs-offset-10">
                                                <button class="glyphicon glyphicon-erase" @click="clearAll()" data-stopPropagation="true"></button>
                                            </div>
                                        </ul>
                                </li>
                            </ul>
                        </div>
                    
                        
                        <!-- 按类型查找 -->
                        
                        <div id="search_sort" class="col-md-2 col-xs-4">
                             <ul class="nav navbar-nav">
                                <!-- 下拉过滤器 -->
                                 <li class="dropdown">
                                    <a href=" " class="dropdown-toggle search_con" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{sort}} <span class="caret"></span></a >
                                         <ul class="dropdown-menu"> 
                                             <li><a href="#" @click="search_sort($event)">Sort by popularity</a></li>
                                             <li><a href="#" @click="search_sort($event)">Sort by score</a></li>                             
                                         </ul>
                                </li>
                            </ul>
                         </div>
                        
                        
                        
                        <!--搜索框 -->

                        <div class="col-md-4 col-xs-4">
                            <form class="navbar-form navbar-left">
                                <div class="form-group">
                                    <input id="search_content" type="text" class="form-control" placeholder="Search">
                                </div>
                                <button type="button" class="btn btn-default glyphicon glyphicon-search" @click="searchInfo"></button>
                            </form>                 
                        </div>

                        

                </div> <!-- row -->
            </div>
        </nav>
    </div>
</template>


<script src="@/assets/js/SearchHeader.js"></script>


<style src="@/assets/sass/SearchHeader.scss" scoped></style>

