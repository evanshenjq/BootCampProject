import Modal from "@/common/Modal";
var name;
var self;
var ifEdit;
var tout;
var delPic = [];
export default {
    name: "AddComp",
    data() {
        return {
            logoUrl: "",
            logoPreview: false,
            compName: "",
            showCompNameError: true,
            preUrls: [],
            type: "comprehensive",
            phone: "",
            address: "",
            introduce: "",
            action: "New",
            showDelOnePic: false
        };
    },
    mounted() {
        if (sessionStorage.getItem("role") !== '1') this.$router.push("/");
        self = this;
        name = this.$route.params.name;
        ifEdit = this.$route.path === '/editComp/' + name;
        if (ifEdit) {
            this.action = "Edit";
            var url = "/perficient/editCompany/oldName/" + name;
            fetch(url)
                .then(function (response) {
                    return response.json();
                })
                .then((res) => {
                    this.logoUrl = res.logo == "/wahaha/" ? "" : "/perficient" + res.logo;
                    for (var i = 0; i < res.introPhoto.length; i++) {
                        if (res.introPhoto[i] != "/wahaha/" && res.introPhoto[i] !== null)
                            this.preUrls.push("/perficient" + res.introPhoto[i]);
                    }
                    this.compName = res.name;
                    this.type = res.type;
                    this.phone = res.phone;
                    this.address = res.address;
                    this.introduce = res.introduce;
                }).catch(e => { })
        }
    },
    components: {
        Modal
    },
    watch: {
        compName: function () {
            var reg = /^[\u4e00-\u9fa5_a-zA-Z0-9()（）@!\\.,。，——-\s]+$/;
            this.showCompNameError = !($.trim(this.compName).length > 0 && reg.test(this.compName));
        },
        logoUrl: function () {
            this.logoPreview = this.logoUrl !== "";
        }
    },
    methods: {
        getFile(e) {
            var files = e.target.files;
            this.preUrls = [];
            for (var i = 0; i < files.length; i++) {
                this.preUrls[i] = window.URL.createObjectURL(files[i]);
            }
        },
        getLogo(e) {
            this.logoUrl = "";
            this.logoUrl = window.URL.createObjectURL(e.target.files[0]);
        },
        save() {
            if (this.showCompNameError)
                this.$refs.myModal.showMyModal(
                    true,
                    true,
                    true,
                    false,
                    true,
                    "Warning",
                    "Please input correct name!",
                    "",
                    "OK"
                );
            else postForm();
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
        },
        showDelPicBtn(event) {
            clearTimeout(tout);
            $(event.target).children().show();
        },
        hideDelPicBtn(event) {
            tout = setTimeout(function () {
                $(event.target).children().hide();
            }, 10);
        },
        delOnePic(preUrl) {
            for (var i = 0; i < this.preUrls.length; i++) if (this.preUrls[i] === preUrl) this.preUrls.splice(i, 1);
            var delPicUrl = preUrl.split("/");
            delPic.push(delPicUrl[3]);
        }
    }
};

function turnToList() {
    self.$router.push("/ListComp");
    $("#myModal").modal("hide");
}

function postForm() {
    var formData = new FormData(document.getElementById("myForm"));
    formData.append("oldName", name);
    formData.append("delPic", delPic);
    var url = "";
    if (ifEdit) url = "/perficient/editComp";
    else url = "/perficient/addComp";
    formData.append("oldName", name);
    fetch(url, {
        method: 'post',
        body: formData
    })
        .then(function (response) {
            return response.json();
        })
        .then((res) => {
            if (res.code === 0) {
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
            }
            else {
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
        }).catch(e => { })
}

Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};