<template>
<div>
    <search-header></search-header>
    <one-comp ref="onecomp"></one-comp>
    <list-page ref="page"></list-page>
</div>
</template>

<script>
import SearchHeader from "@/common/SearchHeader";
import OneComp from "@/common/OneComp";
import ListPage from "@/common/ListPage";
import store from "@/vuex/store.js";

export default {
  name: "index",
  components: {
    SearchHeader,
    OneComp,
    ListPage
  }
};
</script>
