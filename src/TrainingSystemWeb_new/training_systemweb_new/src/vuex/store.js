import Vue from 'vue'
import Vuex from 'vuex'
 
Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
      count: 0,
      courses:0
    },
    mutations: {
        setOrgList (state,array) {
          state.count=array;
        },
        setCourses (state,array) {
          state.courses=array;
        }

      }
  })

  export default store