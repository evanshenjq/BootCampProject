import Modal from "@/common/Modal";
var ifEdit;
var time = "";
var self = "";
var name = "";
var faceTo = "";
export default {
  name: "AddCou",
  data() {
    return {
      img: "",
      logoUrl: "",
      logoPreview: false,
      couName: "",
      showCouNameError: true,
      showInputTime: false,
      msg: "",
      startTime: "",
      price: "",
      type: "",
      classHouers: "",
      teacher: "",
      introduce: "",
      action: "New",
      timeBoxs: [{ weekday: "sun" }],
      designA: ["Pre school", "Primary school", "Junior middle school", "Junior high school", "University"],
      designB: [1, 2, 3, 4, 5, 6],
      CourseStartTime:"",
    };
  },
  mounted() {
    if (sessionStorage.getItem("role") !== '2') this.$router.push("/");
    var path;
    self = this;
    name = this.$route.params.name;
    path = this.$route.path.split("/")[1];
    ifEdit = path === 'editCou';
    if (ifEdit) {
      var formData = new FormData();
      formData.append("oldName", name);
      this.action = "Edit";
      var url = "/perficient/editCourse";
      fetch(url, {
        method: 'post',
        body: formData
      }).then(function (response) {
        return response.json();
      })
        .then((res) => {
          this.logoUrl = "/perficient" + res.logo;
          this.couName = res.courseName;
          this.price = res.price;
          this.type = res.type;
          this.classHouers = res.classHouers;
          this.teacher = res.teacher;
          this.introduce = res.description;
          this.CourseStartTime = res.courseStartTime
          this.timeBoxs = getTime(res.time);
          $("#desinForA option:selected").text(res.suitableCrowd.split("-")[0]);
          $("#desinForB option:selected").text(res.suitableCrowd.split("-")[1]);
          this.changeDesignFor();
        }).catch(e => { })
    }
  },
  components: {
    Modal
  },
  watch: {
    couName: function () {
      if (this.couName.trim().length === 0) this.showCouNameError = true;
      else this.showCouNameError = false;
    },
    logoUrl: function () {
      if (this.logoUrl !== "") this.logoPreview = true;
      else this.logoPreview = false;
    }
  },
  methods: {
    changeDesignFor() {
      var a = $("#desinForA option:selected").text();
      if (a === "Pre school") {
        $("#desinForB").hide();
        faceTo = a;
      }
      else {
        $("#desinForB").show();
        if (a === "Primary school") this.designB = [1, 2, 3, 4, 5, 6];
        else if (a === "Junior middle school") this.designB = [1, 2, 3];
        else if (a === "Junior high school") this.designB = [1, 2, 3];
        else if (a === "University") this.designB = [1, 2, 3, 4];
      }
    },
    getDesignFor() {
      var a = $("#desinForA option:selected").text();
      var b = $("#desinForB option:selected").text();
      faceTo = a == "Pre school" ? a : a + "-" + b;
    },
    setDesignFor() {
      $("#designForDiv option").each(function () {
        if ($(this).text() === faceTo.split('-')[0]) $(this).attr('selected', 'selected');
        if ($(this).text() === faceTo.split('-')[1]) $(this).attr('selected', 'selected');
      });
      this.changeDesignFor()
    },
    priceToFloat(e) {
      if (this.price !== "") {
        this.price = parseFloat(this.price).toFixed(2) + "";
      }
    },
    clearNoNum(e) {
      var obj = e.target;
      obj.value = obj.value.replace(/[^\d.]/g, "");
      obj.value = obj.value.replace(/\.{2,}/g, ".");
      obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
      obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');
      if (obj.value.indexOf(".") < 0 && obj.value !== "") {
        obj.value = parseFloat(obj.value);
      }
    },
    rmButton(e) {
      if ($("#addButton").prevAll().length != 2) {
        var a = 0;
        var bro = $(e.target).parent();
        while (bro.prev().attr("name") === "cTime") {
          a += 1;
          bro = bro.prev();
        }
        var arr = this.timeBoxs.slice(0, a).concat(this.timeBoxs.slice(a + 1, this.timeBoxs.length))
        this.timeBoxs = arr;
      } else {
        this.msg = "at least 1 class time";
        this.showInputTime = true;
      }
    },
    addCou(e) {
      var a = true;
      for (var t = 0; t < this.timeBoxs.length; t++) {
        var ssTime = this.timeBoxs[t].start;
        var eeTime = this.timeBoxs[t].end;
        if (eeTime > ssTime && eeTime !== "" && ssTime !== "")
          continue;
        else {
          a = false;
          break;
        }
      }
      if (a) {
        this.showInputTime = false;
        var a = this.timeBoxs.slice(0);
        a[this.timeBoxs.length] = {
          start: "",
          end: "",
          weekday: "sun"
        }
        this.timeBoxs = [];
        this.timeBoxs = a;
      } else {
        this.msg = "Please enter correct course time";
        this.showInputTime = true;
      }
    },
    showErrMsg(e) {

      if (this.startTime >= e) {
        this.msg = "Please enter correct course time";
        this.showInputTime = true;
      } else {
        this.showInputTime = false;
      }
    },
    putStartTime(e) {
      this.startTime = e;
    },
    getLogo(e) {
      this.logoUrl = "";
      this.logoUrl = window.URL.createObjectURL(e.target.files[0]);
    },
    save() {
      if (this.showCouNameError)
        this.$refs.myModal.showMyModal(
          true,
          true,
          true,
          false,
          true,
          "Warning",
          "Name is required!",
          "",
          "OK"
        );
      else {
        if (this.price !== "") {
          this.price = parseFloat(this.price).toFixed(2) + "";
        }
        time = "";
        var ifPost = true;
        var a = 0
        while (a < this.timeBoxs.length) {
          if (this.timeBoxs[a].start < this.timeBoxs[a].end && this.timeBoxs[a].start !== "" && this.timeBoxs[a].end !== "")
            time += "," + this.timeBoxs[a].weekday + " " + this.timeBoxs[a].start + "-" + this.timeBoxs[a].weekday + " " + this.timeBoxs[a].end;
          else {
            ifPost = false;
            this.$refs.myModal.showMyModal(
              true,
              true,
              true,
              false,
              true,
              "Warning",
              "Please enter correct course time",
              "",
              "OK"
            );
          }
          a++;
        }
        if (ifPost) {
          postForm();
        }
      }
    },
    close() {
      this.$refs.myModal.confirm = function () {
        turnToList();
      };
      this.$refs.myModal.showMyModal(
        true,
        true,
        true,
        true,
        true,
        "Confirm",
        "Are you sure to leave?",
        "Yes",
        "No"
      );
    }
  }
};

function postForm() {
  var formData = new FormData(document.getElementById("addCouForm"));
  var url = "";
  if (ifEdit) url = "/perficient/editCou";
  else url = "/perficient/addCourse";
  formData.append("companyId", $.session.get("userId"));
  formData.append("time", time.slice(1));
  formData.append("oldName", name);
  self.getDesignFor();
  formData.append("faceTo", faceTo);
  fetch(url, {
    method: "post",
    body: formData
  })
    .then(function (response) {
      return response.json();
    })
    .then(res => {
      if (res.code == 0) {
        self.$refs.myModal.showMyModal(
          true,
          true,
          false,
          true,
          true,
          res.msg,
          "You'll turn to the list of company after 3sec.",
          "",
          ""
        );
        setTimeout(turnToList, 3000);
      } else {
        self.$refs.myModal.showMyModal(
          true,
          true,
          true,
          false,
          true,
          "Warning",
          res.msg,
          "",
          "OK"
        );
      }
    })
    .catch(e => { });
}


function turnToList() {
  self.$router.push("/listCourses");
  $("#myModal").modal("hide");
}

function getTime(str) {
  var tbs = [];
  var ts = str.split(/-|\s|,/);
  for (var i = 0; i < ts.length / 4; i++) {
    var timeJson = {
      weekday: ts[i * 4],
      start: ts[i * 4 + 1],
      end: ts[i * 4 + 3]
    };
    tbs.push(timeJson);
  }
  return tbs;
}