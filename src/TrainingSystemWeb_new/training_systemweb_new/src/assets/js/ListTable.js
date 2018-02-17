var names = [];
var i = 0;
var self;
var tout;
export default {
  name: "ListTable",
  data() {
    return {
      selectAll: false,
      comps: [],
      nowPage: 0,
      totalPage: 0,
      searchValue: false,
      key: "",
      showTable: true,
      selAllCheckbox: false
    };
  },
  mounted() {
    if (sessionStorage.getItem("role") !== '1') this.$router.push("/");
    $("[data-toggle='tooltip']").tooltip();
    self = this;
    this.getAllData(1);
  },
  methods: {
    create() {
      this.$router.push("/AddComp");
    },
    del() {
      this.$parent.$refs.myModal.confirm = function () {
        delComp();
      };
      this.$parent.$refs.myModal.showMyModal(
        true,
        true,
        true,
        true,
        true,
        "Confirm",
        "Are you sure to delete?",
        "Yes",
        "No"
      );
    },
    search() {
      this.searchValue = true;
      this.getAllData(1);
    },
    selAllBtn() {
      this.selAllCheckbox = !this.selAllCheckbox;
      names = [];
      $("[name=selectCheckBox]").prop("checked", this.selAllCheckbox);
      if (this.selAllCheckbox)
        $("input[name=selectCheckBox]").each(function () {
          names.push($(this).val());
        });
      delButtonDisabled();
    },
    selDel(event) {
      var cb = $(event.target);
      var ischeck = cb.is(":checked");
      var name = cb.val();
      if (ischeck) names.push(name);
      else removeStr(name);
      delButtonDisabled();
      var b =
        $("[name=selectCheckBox]:checked").length ==
        $("[name=selectCheckBox]").length;
      $("input[id='selectAllCheckBox']").prop("checked", b);
    },
    editComp(n) {
      this.$router.push("/editComp/" + n);
    },
    getAllData(p) {
      var url = "/perficient/backStage/" + p;
      if (this.searchValue)
        url = "/perficient/backStage/key/" + p + "?key=" + this.key;
      fetch(url)
        .then(function (response) {
          return response.json();
        })
        .then(res => {
          tPageIsZero(res.totalPage == 0);
          this.comps = res.data;
          this.$parent.$refs.page.nPage = res.nowPage;
          this.$parent.$refs.page.tPage = res.totalPage;
          flushList();
          this.$parent.$refs.page.flushPageButton();
        })
        .catch(e => { });
    },
    showDelComp(event) {
      clearTimeout(tout);
      $(event.target).children().show();
    },
    hideDelComp(event) {
      tout = setTimeout(function () {
        $(event.target).children().css("display", "none");
      }, 1);
    },
    delOneComp(n) {
      names = [n];
      this.$parent.$refs.myModal.confirm = function () {
        delComp();
      };
      this.$parent.$refs.myModal.showMyModal(
        true,
        true,
        true,
        true,
        true,
        "Confirm",
        "Are you sure to delete?",
        "Yes",
        "No"
      );
    }
  }
};

function tPageIsZero(b) {
  self.$parent.$refs.page.info = b;
  self.$parent.$refs.page.isShow = !b;
  self.showTable = !b;
}

function delComp() {
  var ns = "";
  for (i = 0; i < names.length; i++) ns += "," + names[i];
  fetch("/perficient/delComp?names=" + ns)
    .then(function (data) {
      return data.json();
    })
    .then(res => {
      var md = self.$parent.$refs.myModal;
      md.labelText = "Message";
      md.bodyText = res.msg;
      md.showCancle = false;
      md.confirmText = "OK";
      md.confirm = function () {
        $("#myModal").modal("hide");
      };
      self.getAllData(1);
    })
    .catch(e => { });
}

function removeStr(str) {
  for (i = 0; i < names.length; i++) if (names[i] == str) names.splice(i, 1);
}

function delButtonDisabled() {
  if (names.length > 0) $("#delButton").attr("disabled", false);
  else $("#delButton").attr("disabled", true);
}

function flushList() {
  for (i = 0; i < self.comps.length; i++) {
    self.comps[i].logo = "/perficient" + self.comps[i].logo;
    if (self.comps[i].logo == "/perficient/wahaha/") {
      self.comps[i].logo = "/perficient/wahaha/logo.png";
    }
  }
  names = [];
  delButtonDisabled();
  self.selAllCheckbox = false;
  $("input[type='checkbox']").prop("checked", false);
}