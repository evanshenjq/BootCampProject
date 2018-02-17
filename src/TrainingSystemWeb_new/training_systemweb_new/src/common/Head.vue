<template>
 <div class="head">


    <div class="aside" @click='toggleMenu' id="head">
      <div v-for='i in 3' class="line"></div>

    </div>
  </div>
</template>

<script>
export default {
  name: "head",
  data() {
    return {
      imgs: [],
      searchContent: ""
    };
  },

  methods: {
    toggleMenu() {
      var page = document.querySelector("#UserInfo .page");
      var aside = document.querySelector(".head .aside");
      var pageClass = page.className;
      var asideClass = aside.className;
      if (pageClass === "page") {
        page.className = "page toggle";
      } else {
        page.className = "page";
      }
      if (asideClass === "aside") {
        aside.className = "aside closeMenu";
      } else {
        aside.className = "aside";
      }
    }
  }
};
</script>

<style>
.head {
 // border:1px red solid;
  height: 60px;
  background: #262627;
  margin-top: 0px;
}

.aside {
 // border:1px blue solid;
  height: 60px;
  width: 60px;
  cursor: pointer;
  position: absolute;
  top: 0;
  right: 0;
  padding-top: 1px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.aside .line {
  height: 1px;
  width: 25px;
  background: #fff;
  transition: all 0.5s;
}
.aside .line:nth-of-type(2) {
  margin: 6px 0;
}

.closeMenu .line:first-child {
  transform: rotate(45deg);
}

.closeMenu .line:nth-child(2) {
  display: none;
}

.closeMenu .line:last-child {
  transform: rotate(-45deg);
}
</style>
