<template>
    <div>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header" v-if="showHeader">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true" name="modelCancel"> 
                                        &times;
                                    </button>
                        <h4 class="modal-title" id="myModalLabel">
                            {{labelText}}
                        </h4>
                    </div>
                    <div class="modal-body" v-if="showBody" name="modalBody">
                        {{bodyText}}
                    </div>
                    <div class="modal-footer" v-if="showFooter">
                        <button type="button" class="btn btn-primary" v-if="showConfirm" @click="confirm" name="modelYes">
                                        {{confirmText}}
                                    </button>
                        <button type="button" class="btn btn-warning" data-dismiss="modal" v-if="showCancle" name="modelNo">
                                        {{cancleText}}
                                    </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Modal',
        data() {
            return {
                showHeader: true,
                showBody: true,
                showFooter: true,
                showConfirm: true,
                showCancle: true,
                labelText: "hello",
                bodyText: "",
                confirmText: "",
                cancleText: ""
            }
        },
        methods: {
            confirm() {},
            showMyModal(sh, sb, sf, sc, sca, lt, bt, ct, cat) {
                this.showHeader = sh;
                this.showBody = sb;
                this.showFooter = sf;
                this.showConfirm = sc;
                this.showCancle = sca;
                this.labelText = lt;
                this.bodyText = bt;
                this.confirmText = ct;
                this.cancleText = cat;
                $("#myModal").modal("show");
            }
        }
    }
</script>

<style>
    
</style>
