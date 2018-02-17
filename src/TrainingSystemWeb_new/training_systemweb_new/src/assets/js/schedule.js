export default {
    data() {
      return {
        demoEvents: [{
          date: '2016/12/15',
          title: 'eat',
          desc: 'longlonglong description'
        }, {
          date: '2016/11/12',
          title: 'this is a title',
          desc: 'longlonglong description'
        }]
      }
    },
    mounted() {
      let url = '/perficient/user/course/dates'
      let formData = new FormData();
      formData.append('userId', sessionStorage.getItem('userId'))
      fetch(url, {
          method: 'post',
          body: formData
        }).then(function(response) {
          return response.json();
        })
        .then((res) => {    
                let scheduleData = [];                
                for(let index=0;index<res.length;index++){
                  let a = res [index]
                  //if(a.split(" ")[1].split("-")[0])
                  scheduleData.push(getJson(a));   
                }
                this.demoEvents = []
                this.demoEvents = scheduleData
                }).catch(e => {})
    },
    methods: {
      monthChange() {
  
      },
      dayChange(day) {

      }
    }
  }
  $(document).ready(function() {
  
    $(".wrapper").click(function() {

    })
  })
  function getJson(str) {
  var dt = str.split(" ");
    var d = dt[0].replace('-','/')
    d = d.replace('-','/')
    var tJson = {
      date: d,
      title: dt.slice(3,dt.length).join(' '),
      desc: dt[1]+" "+dt[2]
    };
  
  return tJson;
}