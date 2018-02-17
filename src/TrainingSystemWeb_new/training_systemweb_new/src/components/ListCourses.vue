<template>
<div>
    <list-course ref="table"></list-course>
    <list-page ref="page"></list-page>
    <modal ref="myModal"></modal>
</div>
</template>

<script>
import ListCourse from "@/components/ListCourse";
import ListPage from "@/common/ListPage";
import Modal from "@/common/Modal";

export default {
  name: "ListCourses",
  components: {
    ListCourse,
    ListPage,
    Modal
  }
};
</script>
