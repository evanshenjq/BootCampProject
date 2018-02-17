<template>
    <div>
        <div id="noResultInfo" class="row">
            <p class="text-center panel panel-primary col-md-4 col-md-offset-4" v-show="info">No Company Info!</p>
        </div>
        <div class="row text-center" id="page" v-show="isShow">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a aria-label="Previous" @click="pageSub">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li v-for="p in pButton">
                            <a name="pageNum" @click="selPage($event)">{{p}}</a>
                        </li>
                        <li>
                            <a aria-label="Next" @click="pageAdd">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4" id="page-num">
                <p>
                    pages
                    <a>{{nPage}}</a>/
                    <a>{{tPage}}</a>
                </p>
            </div>
            <div class="input-group col-md-3 col-md-offset-3 col-sm-3 col-sm-offset-3 col-xs-3 col-xs-offset-3" id="page-go">
                <input type="text" class="form-control" placeholder="Jump to page..." id="inputPageNum" @keyup.enter="goPage">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="goPage" @click="goPage">
                        <span class="glyphicon glyphicon-share-alt"></span>
                    </button> 
                </span>
            </div>
        </div>
    </div>
</template>

<script>
    var i = 0;
    export default {
        name: 'ListPage',
        data() {
            return {
                info: false,
                isShow: true,
                nPage: 1,
                tPage: 0,
                pButton: [],
            }
        },
        methods: {
            pageSub() {
                var arr = this.pButton;
                if (arr[0] > 1) {
                    this.pButton = [];
                    for (i = 0; i < 5; i++)
                        this.pButton[i] = arr[i] - 1;
                }
            },
            pageAdd() {
                var arr = this.pButton;
                if (arr[4] < this.tPage) {
                    this.pButton = [];
                    for (i = 0; i < arr.length; i++)
                        this.pButton[i] = arr[i] + 1;
                }
            },
            goPage() {
                var p = parseInt($("#inputPageNum").val());
                if (p > 0 && p <= this.tPage)
                    this.$parent.$refs.table.getAllData(p);
                else this.$parent.$refs.myModal.showMyModal(
                    true,
                    true,
                    true,
                    false,
                    true,
                    "Warning",
                    "Please input correct page number!",
                    "",
                    "OK"
                );
            },
            flushPageButton() {
                this.pButton = [];
                if (this.tPage < 6)
                    for (i = 1; i <= this.tPage; i++) {
                        this.pButton[i - 1] = i;
                    }
                else this.pButton = [1, 2, 3, 4, 5];
            },
            selPage(event) {
                var p = $(event.target).text();
                this.$parent.$refs.table.getAllData(p);
            }
        }
    }
</script>

<style>
    #noResultInfo {
        font-size: larger;
    }

    ul {
        cursor: pointer;
    }

    #page-num{
        padding-top: 26px;
    }
    #page-go{
        padding-top: 21px;
    }
</style>

